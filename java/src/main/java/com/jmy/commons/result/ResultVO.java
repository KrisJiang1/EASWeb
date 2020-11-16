package com.jmy.commons.result;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//自定义统一响应体
@Component
public class ResultVO<T> {

    private int code;

    private String msg;

    private T data;

    public ResultVO() {
    }

    public ResultVO(T data) {
        this(ResultCode.SUCCESS,data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
