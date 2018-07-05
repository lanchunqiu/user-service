package com.lancq.user.dto;

import java.io.Serializable;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/5
 **/
public class CheckAuthRequest implements Serializable {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CheckAuthRequest{" +
                "token='" + token + '\'' +
                '}';
    }
}
