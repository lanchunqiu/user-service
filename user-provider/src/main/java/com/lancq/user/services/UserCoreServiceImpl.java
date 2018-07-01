package com.lancq.user.services;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.lancq.user.IUserCoreService;
import com.lancq.user.ResponseCodeEnum;
import com.lancq.user.dal.entity.User;
import com.lancq.user.dal.persistence.UserMapper;
import com.lancq.user.dto.UserLoginRequest;
import com.lancq.user.dto.UserLoginResponse;
import com.lancq.user.exception.ExceptionUtil;
import com.lancq.user.exception.ServiceException;
import com.lancq.user.exception.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/1
 **/
@Service("userCoreService")
public class UserCoreServiceImpl implements IUserCoreService {
    Logger Log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserMapper userMapper;

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        Log.info("login request->" + request);
        UserLoginResponse response = new UserLoginResponse();
        try{
            beforeValidate(request);
            User user = userMapper.getUserByUserName(request.getUserName());
            if(user == null || !user.getPassword().equals(request.getPassword())){
                response.setCode(ResponseCodeEnum.USERORPASSWORD_ERRROR.getCode());
                response.setMsg(ResponseCodeEnum.USERORPASSWORD_ERRROR.getMsg());
                return response;
            }
            response.setUid(user.getId());
            response.setAvatar(user.getAvatar());
            response.setMobile(user.getMobile());
            response.setCode(ResponseCodeEnum.SUCCESS.getCode());
            response.setMsg(ResponseCodeEnum.SUCCESS.getMsg());
        } catch (Exception e){
            Log.error(e.getMessage());
            ServiceException exception = (ServiceException) ExceptionUtil.handlerException4biz(e);
            response.setCode(exception.getErrorCode());
            response.setMsg(exception.getErrorMessage());
        } finally {
            Log.info("login response->" + response);
        }
        return response;
    }

    private void beforeValidate(UserLoginRequest request){
        if(request == null){
            throw new ValidateException("用户对象为空");
        }
        if(StringUtils.isBlank(request.getUserName())){
            throw new ValidateException("用户名为空");
        }
        if(StringUtils.isBlank(request.getPassword())){
            throw new ValidateException("密码为空");
        }
    }
}
