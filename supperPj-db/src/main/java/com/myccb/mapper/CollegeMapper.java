package com.myccb.mapper;

import com.myccb.bean.db.CollegeDb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CollegeMapper {
    int deleteByPrimaryKey(String num);

    CollegeDb selectByPrimaryKey(String num);

    CollegeDb find(CollegeDb param);

    CollegeDb findForMember(String userId);

    int insert(CollegeDb param);

    int updateByPrimaryKeySelective (CollegeDb param);

    List<CollegeDb> findUserByPwd(CollegeDb CollegeDb);

    List<CollegeDb> selectUserRole(Map map);
}
