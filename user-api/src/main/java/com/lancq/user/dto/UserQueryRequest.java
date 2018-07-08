package com.lancq.user.dto;

import com.lancq.user.abs.AbstractRequest;

import java.io.Serializable;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/8
 **/
public class UserQueryRequest extends AbstractRequest implements Serializable {
    private Integer uid;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserQueryRequest{" +
                "uid=" + uid +
                '}';
    }
}
