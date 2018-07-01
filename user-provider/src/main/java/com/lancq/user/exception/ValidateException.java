package com.lancq.user.exception;

import com.lancq.user.ResponseCodeEnum;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/1
 **/
public class ValidateException extends RuntimeException  {
    /**
     * versionId
     */
    private static final long serialVersionUID = 7172827201346602909L;


    /**
     * 返回码
     */
    private String errorCode;
    /**
     * 信息
     */
    private String errorMessage;

    /**
     * 构造函数
     */
    public ValidateException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param errorCode
     */
    public ValidateException(String errorCode) {
        super(errorCode);
        this.errorCode= ResponseCodeEnum.SYS_PARAM_NOT_RIGHT.getCode();
        this.errorMessage=ResponseCodeEnum.SYS_PARAM_NOT_RIGHT.getMsg();
    }

    /**
     * 构造函数
     *
     * @param cause
     */
    public ValidateException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param errorCode
     * @param cause
     */
    public ValidateException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    /**
     * 构造函数
     *
     * @param errorCode
     * @param message
     */
    public ValidateException(String errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    /**
     * 构造函数
     *
     * @param errorCode
     * @param message
     * @param cause
     */
    public ValidateException(String errorCode, String message, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
