package com.run.boot.exception;

/**
 * @author : maweijie
 * @date : 2019/1/31
 * @description:封装异常
 */
public class RunbootException extends RuntimeException {
    private final Integer status;
    private final Object[] params;

    public RunbootException(Integer code, String msg, Object... params) {
        super(msg);
        this.status = code;
        this.params = params;
    }

    public RunbootException(Integer code, String msg, Exception e, Object... parms) {
        super(msg, e);
        this.status = code;
        this.params = parms;
    }

    public RunbootException(Integer code, String msg, Throwable t, Object... params) {
        super(msg, t);
        this.status = code;
        this.params = params;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Object[] getParams() {
        return this.params;
    }
}
