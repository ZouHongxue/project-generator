package com.fzs.auto_design.common;

import java.io.Serializable;

/**
 * Rest返回信息
 */
public class Response implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public Response() {}

    public Response(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Response successInstance(Object data) {
        return new Response(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMsg(), data);
    }

    public static Response failInstance(int code, String msg) {
        return new Response(code, msg,null);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
