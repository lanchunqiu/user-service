package com.lancq.user.dto;

import com.lancq.user.abs.AbstractRequest;

import java.io.Serializable;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/8
 **/
public class UserRegisterRequest extends AbstractRequest implements Serializable {
    private String username;

    private String password;

    private String mobile;

    private String sex;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserRegisterRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
