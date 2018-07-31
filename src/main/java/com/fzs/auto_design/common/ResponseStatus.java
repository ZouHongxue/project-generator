package com.fzs.auto_design.common;

public enum  ResponseStatus {

    SUCCESS(0, "SUCCESS"),
    ERROR1(100, "系统异常"),
    ERROR11(110, "数据源服务异常"),
    ERROR12(120, "数据源返回空"),
    ERROR13(130, "暂无数据"),
    ERROR14(140, "数据引擎服务异常"),
    ERROR2(200, "参数异常"),
    ERROR201(201, "操作不允许"),
    ERROR202(202, "重复"),
    ERROR203(203, "参数缺失"),
    ERROR204(204, "目标对象不存在"),
    ERROR3(300, "数据异常"),
    ERROR4(400, "业务异常"),
    ERROE401(401, "鉴权失败"),
    ERROE403(403, "拒绝服务"),
    ERROE409(409, "未获取到当前登录用户");

    private int code;
    private String msg;

    ResponseStatus() {}

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
