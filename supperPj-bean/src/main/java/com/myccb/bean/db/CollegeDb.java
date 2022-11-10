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
    private String CollegeName;
    /**成员**/
    private String ClooegeMember;
    /**编号**/
    private String num;
    /**成员编号**/
    private String MembeNum;
    private String address;
    private String status;

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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMembeNum() {
        return MembeNum;
    }

    public void setMembeNum(String membeNum) {
        MembeNum = membeNum;
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
}
