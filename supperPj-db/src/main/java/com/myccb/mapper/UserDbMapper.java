package com.myccb.mapper;

import com.github.pagehelper.Page;
import com.myccb.bean.db.UserDb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDb record);

    int insertSelective(UserDb record);

    UserDb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDb record);

    int updateByPrimaryKey(UserDb record);

    UserDb find(UserDb record);

    UserDb findUserByPwd(UserDb record);

    List<UserDb> list(UserDb record);

    Page<UserDb> pageList(UserDb record);
}