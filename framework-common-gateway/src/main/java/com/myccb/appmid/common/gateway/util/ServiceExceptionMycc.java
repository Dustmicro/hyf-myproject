package com.myccb.appmid.common.gateway.util;


import com.myccb.appmid.common.gateway.rewrite.AppMidRequestHeader;

public class ServiceExceptionMycc extends Exception {
    private String code;
    private String desc;
    private AppMidRequestHeader requestHeader;
    private static final long serialVersionUID = 1L;

    public ServiceExceptionMycc(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public ServiceExceptionMycc(AppMidRequestHeader requestHeader, String code, String desc){
        this.desc = desc;
        this.code = code;
        this.requestHeader = requestHeader;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public AppMidRequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(AppMidRequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }
}
