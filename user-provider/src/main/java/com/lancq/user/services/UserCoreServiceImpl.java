package com.lancq.user.services;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.lancq.user.IUserCoreService;
import com.lancq.user.ResponseCodeEnum;
import com.lancq.user.dal.entity.User;
import com.lancq.user.dal.persistence.UserMapper;
import com.lancq.user.dto.CheckAuthRequest;
import com.lancq.user.dto.CheckAuthResponse;
import com.lancq.user.dto.UserLoginRequest;
import com.lancq.user.dto.UserLoginResponse;
import com.lancq.user.exception.ExceptionUtil;
import com.lancq.user.exception.ServiceException;
import com.lancq.user.exception.ValidateException;
import com.lancq.user.utils.JwtTokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

            Map<String,Object> map = new HashMap<String,Object>();
            map.put("uid", user.getId());
            map.put("exp", DateTime.now().plusSeconds(40).toDate().getTime()/1000);
            response.setToken(JwtTokenUtils.generatorToken(map));
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

    @Override
    public CheckAuthResponse validToken(CheckAuthRequest request) {
        CheckAuthResponse response = new CheckAuthResponse();
        beforeValidateAuth(request);
        try{
            Claims claims = JwtTokenUtils.phaseToken(request.getToken());
            response.setUid(claims.get("uid").toString());
            response.setCode(ResponseCodeEnum.SUCCESS.getCode());
            response.setCode(ResponseCodeEnum.SUCCESS.getMsg());
        } catch (ExpiredJwtException e){
            Log.error("Expire:" + e);
            response.setCode(ResponseCodeEnum.TOKEN_EXPIRE.getCode());
            response.setCode(ResponseCodeEnum.TOKEN_EXPIRE.getMsg());
        } catch (SignatureException e){
            Log.error("Expire:" + e);
            response.setCode(ResponseCodeEnum.SIGNATURE_ERROR.getCode());
            response.setCode(ResponseCodeEnum.SIGNATURE_ERROR.getMsg());
        } catch (Exception e){
            Log.error("login occur exception:" + e);
            ServiceException serviceException = (ServiceException) ExceptionUtil.handlerException4biz(e);
            response.setCode(serviceException.getErrorCode());
            response.setCode(serviceException.getErrorMessage());
        } finally {
            Log.info("response->" + response);
        }


        return null;
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
    private void beforeValidateAuth(CheckAuthRequest request){
        if(request == null){
            throw new ValidateException("用户对象为空");
        }
        if(StringUtils.isBlank(request.getToken())){
            throw new ValidateException("token信息为空");
        }
    }
}
