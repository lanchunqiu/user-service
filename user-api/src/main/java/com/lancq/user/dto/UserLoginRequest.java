package com.lancq.user.dto;

import java.io.Serializable;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/1
 **/
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 686223598602505582L;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginRequest{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
