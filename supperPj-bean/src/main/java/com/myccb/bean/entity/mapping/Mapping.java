package com.myccb.bean.entity.mapping;

import java.io.Serializable;
import java.util.Date;

/**
 * 映射表
 * @author 黄弋峰 2022/11/12
 */
public class Mapping implements Serializable {
    private int id;

    //域，如常量域域，如常量域
    private String domain;

    //名称
    private String name;

    //键
    private String key;

    //值
    private String value;

    //描述
    private String remark;

    //创建时间
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
