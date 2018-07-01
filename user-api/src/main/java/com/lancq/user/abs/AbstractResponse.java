package com.lancq.user.abs;

import java.io.Serializable;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/1
 **/
public abstract class AbstractResponse implements Serializable {
    private static final long serialVersionUID = -7716370995066962411L;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
