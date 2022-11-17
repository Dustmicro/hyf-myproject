package com.myccb.bean.db;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class CollegeUserDb implements Serializable {
    private String collegeNum;

    private String collegeName;

    private String collegeMember;

    private String membeNum;

    private String address;

    private Long tel;

    private Integer statusCd;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getCollegeNum() {
        return collegeNum;
    }

    public void setCollegeNum(String collegeNum) {
        this.collegeNum = collegeNum == null ? null : collegeNum.trim();
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    public String getCollegeMember() {
        return collegeMember;
    }

    public void setCollegeMember(String collegeMember) {
        this.collegeMember = collegeMember == null ? null : collegeMember.trim();
    }

    public String getMembeNum() {
        return membeNum;
    }

    public void setMembeNum(String membeNum) {
        this.membeNum = membeNum == null ? null : membeNum.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Integer getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(Integer statusCd) {
        this.statusCd = statusCd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}