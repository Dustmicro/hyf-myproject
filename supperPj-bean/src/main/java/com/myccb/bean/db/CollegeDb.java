package com.myccb.bean.db;

import lombok.Builder;
import lombok.Data;

/**
 * 部门实体
 * @author 黄弋峰 2022/11/10
 */
@Data
@Builder
public class CollegeDb {
    private String collegeName;
    /**成员**/
    private String clooegeMember;
    /**编号**/
    private String num;
    /**成员编号**/
    private String membeNum;
    private String address;
    private String status;
    private String tel;
    /**用户id**/
    private String userId;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getClooegeMember() {
        return clooegeMember;
    }

    public void setClooegeMember(String clooegeMember) {
        this.clooegeMember = clooegeMember;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
