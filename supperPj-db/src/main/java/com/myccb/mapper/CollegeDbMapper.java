package com.myccb.mapper;

import com.github.pagehelper.Page;
import com.myccb.bean.db.CollegeDb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollegeDbMapper {
    int deleteByPrimaryKey(String collegeNum);

    int insert(CollegeDb record);

    int insertSelective(CollegeDb record);

    CollegeDb selectByPrimaryKey(String collegeNum);

    int updateByPrimaryKeySelective(CollegeDb record);

    int updateByPrimaryKey(CollegeDb record);

    CollegeDb find(CollegeDb record);

    List<CollegeDb> list(CollegeDb record);

    Page<CollegeDb> pageList(CollegeDb record);
}