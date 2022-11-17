package com.myccb.bean;

/**
 * 部门请求实体
 * @author 黄弋峰  2022/11/10
 */
public class CollegeUserReq {
    private String collegeNum;

    private String collegeName;

    private String collegeMember;

    private String membeNum;

    private String address;

    private Long tel;

    public String getCollegeNum() {
        return collegeNum;
    }

    public void setCollegeNum(String collegeNum) {
        this.collegeNum = collegeNum;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeMember() {
        return collegeMember;
    }

    public void setCollegeMember(String collegeMember) {
        this.collegeMember = collegeMember;
    }

    public String getMembeNum() {
        return membeNum;
    }

    public void setMembeNum(String membeNum) {
        this.membeNum = membeNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
