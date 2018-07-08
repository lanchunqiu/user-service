package com.lancq.user.dto;

import com.lancq.user.abs.AbstractResponse;

import java.io.Serializable;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/8
 **/
public class UserRegisterResponse extends AbstractResponse implements Serializable {
    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserRegisterResponse{" +
                "uid=" + uid +
                '}';
    }
}
