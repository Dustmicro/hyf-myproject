package com.myccb.mapper;

import com.myccb.bean.db.UserDb;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    UserMapper selectByPrimaryKey(String userId);

//    int select(UserDb param);
    UserDb find(UserDb param);

    int insert(UserDb param);

    int updateByPrimaryKeySelective (String userId);
}
