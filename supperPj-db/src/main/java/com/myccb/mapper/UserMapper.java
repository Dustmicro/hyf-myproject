package com.myccb.mapper;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    UserMapper selectByPrimaryKey(String userId);

    int insert(UserMapper param);

    int updateByPrimaryKeySelective (String userId);
}
