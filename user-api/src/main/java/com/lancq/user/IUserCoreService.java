package com.lancq.user;

import com.lancq.user.dto.*;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/1
 **/
public interface IUserCoreService {
    UserLoginResponse login(UserLoginRequest request);

    CheckAuthResponse validToken(CheckAuthRequest request);

    UserRegisterResponse register(UserRegisterRequest request);
}
