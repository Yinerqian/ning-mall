/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.atguigu.gulimall.common.utils;


import com.atguigu.gulimall.common.exception.ErrorCode;

import java.io.Serializable;

/**
 * 响应数据
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编码：0表示成功，其他值表示失败
     */
    private int code = 0;
    /**
     * 消息内容
     */
    private String message = "success";

    private Boolean successFlag = true;
    /**
     * 响应数据
     */
    private T content;

    public Result<T> ok(T content) {
        this.setContent(content);
        return this;
    }

    public boolean success(){
        return code == 0;
    }

    public Result<T> error() {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.message = MessageUtils.getMessage(this.code);
        return this;
    }

    public Result<T> error(int code) {
        this.code = code;
        this.message = MessageUtils.getMessage(this.code);
        return this;
    }

    public Result<T> error(int code, String msg) {
        this.code = code;
        this.message = msg;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(Boolean successFlag) {
        this.successFlag = successFlag;
    }

    public Result<T> error(String msg) {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.message = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

}
