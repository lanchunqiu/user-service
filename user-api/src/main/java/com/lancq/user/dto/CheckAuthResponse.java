package com.lancq.user.dto;

import com.lancq.user.abs.AbstractResponse;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/5
 **/
public class CheckAuthResponse extends AbstractResponse {
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "CheckAuthResponse{" +
                "uid='" + uid + '\'' +
                "} " + super.toString();
    }
}
