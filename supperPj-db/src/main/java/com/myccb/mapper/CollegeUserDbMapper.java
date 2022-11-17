package com.myccb.mapper;

import com.github.pagehelper.Page;
import com.myccb.bean.db.CollegeUserDb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollegeUserDbMapper {
    int deleteByPrimaryKey(String collegeNum);

    int insert(CollegeUserDb record);

    int insertSelective(CollegeUserDb record);

    CollegeUserDb selectByPrimaryKey(String collegeNum);

    int updateByPrimaryKeySelective(CollegeUserDb record);

    int updateByPrimaryKey(CollegeUserDb record);

    CollegeUserDb find(CollegeUserDb record);

    List<CollegeUserDb> list(CollegeUserDb record);

    Page<CollegeUserDb> pageList(CollegeUserDb record);
}