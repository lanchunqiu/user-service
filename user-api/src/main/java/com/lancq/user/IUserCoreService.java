package com.lancq.user;

import com.lancq.user.dto.UserLoginRequest;
import com.lancq.user.dto.UserLoginResponse;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/1
 **/
public interface IUserCoreService {
    UserLoginResponse login(UserLoginRequest request);
}
