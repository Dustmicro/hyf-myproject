package com.myccb.bean.db;

import java.io.Serializable;
import java.util.Date;

public class DictionaryDb implements Serializable {
    private Integer id;
    /**字典值**/
    private String dicDictionary;
    /**字典值编号**/
    private String dicNum;
    /**字典值状态**/
    private String statusCd;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDicDictionary() {
        return dicDictionary;
    }

    public void setDicDictionary(String dicDictionary) {
        this.dicDictionary = dicDictionary == null ? null : dicDictionary.trim();
    }

    public String getDicNum() {
        return dicNum;
    }

    public void setDicNum(String dicNum) {
        this.dicNum = dicNum == null ? null : dicNum.trim();
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd == null ? null : statusCd.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}