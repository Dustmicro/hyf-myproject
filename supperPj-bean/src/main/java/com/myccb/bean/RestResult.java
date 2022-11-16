package com.myccb.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回对象实体
 * @author 黄弋峰 2022/11/16
 */
public class RestResult<T> {

    /**响应头**/
    Map<String, String> header;
    /**响应体**/
    @JSONField(serialize = false)
    T body;

    public Map<String, String> getHeader(){
        return header;
    }

    public void setHeader(Map<String, String> header){
        this.header = header;
    }

    public T getBody(){
        return body;
    }

    public void setBody(T body){
        this.body = body;
    }

    /**
     * 返回成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> success(T data){
        RestResult<T> re = new RestResult<>();
        Map<String, String> header = new HashMap<>();
        header.put("code", "000000");
        header.put("message", "成功");
        re.setHeader(header);
        re.setBody(data);
        return re;
    }

    /**
     * 返回失败的
     * @param errorCode
     * @param errMsg
     * @return
     */
    public static RestResult<Object> failure(String errorCode, String errMsg){
        RestResult<Object> re = new RestResult<>();
        Map<String, String> header = new HashMap<>();
        header.put("code", errorCode);
        header.put("message", errMsg);
        re.setHeader(header);
        return re;
    }
}
