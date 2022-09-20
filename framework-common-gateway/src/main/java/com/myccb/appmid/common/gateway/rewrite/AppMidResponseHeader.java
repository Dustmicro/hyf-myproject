package com.myccb.appmid.common.gateway.rewrite;

/**
 * 服务响应头
 */
public class AppMidResponseHeader {
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AppMidResponseHeader{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
