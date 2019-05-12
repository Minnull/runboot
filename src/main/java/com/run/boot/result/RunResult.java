package com.run.boot.result;

import java.io.Serializable;

/**
 * @author : maweijie
 * @date : 2019/1/31
 * @description:统一返回数据格式
 */
public class RunResult<T> implements Serializable {

    /*状态码*/
    private Integer code;

    /*消息提示*/
    private String msg;

    /*具体数据*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public void setError(Integer status, String errMsg) {
        this.code = status;
        this.msg = errMsg;
    }
}
