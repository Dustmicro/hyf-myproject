package com.example.bean;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**第几页**/
    int page;
    /**单页数据条数**/
    int startNum;
    /**开始条数**/
    int pageSize;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
