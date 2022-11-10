package com.myccb.bean;

/**
 * 部门请求实体
 * @author 黄弋峰  2022/11/10
 */
public class CollegeReq {
    private String CollegeName;
    /**成员**/
    private String ClooegeMember;
    /**地址**/
    private String address;
    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    public String getCollegeName() {
        return CollegeName;
    }

    public void setCollegeName(String collegeName) {
        CollegeName = collegeName;
    }

    public String getClooegeMember() {
        return ClooegeMember;
    }

    public void setClooegeMember(String clooegeMember) {
        ClooegeMember = clooegeMember;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
