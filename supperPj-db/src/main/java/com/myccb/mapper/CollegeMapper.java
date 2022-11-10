package com.myccb.mapper;

import com.myccb.bean.db.CollegeDb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CollegeMapper {
    int deleteByPrimaryKey(String num);

    CollegeDb selectByPrimaryKey(CollegeDb param);

    CollegeDb find(CollegeDb param);

    int insert(CollegeDb param);

    int updateByPrimaryKeySelective (String userId);

    List<CollegeDb> findUserByPwd(CollegeDb CollegeDb);

    List<CollegeDb> selectUserRole(Map map);
}
