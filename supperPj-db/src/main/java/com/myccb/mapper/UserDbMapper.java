package com.myccb.mapper;

import com.github.pagehelper.Page;
import com.myccb.bean.db.UserDb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDbMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserDb record);

    int insertSelective(UserDb record);

    UserDb selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserDb record);

    int updateByPrimaryKey(UserDb record);

    UserDb find(UserDb record);

    UserDb selectUserRole(Map<String, String> record);

    UserDb findUserByPwd(UserDb record);

    List<UserDb> list(UserDb record);

    Page<UserDb> pageList(UserDb record);
}