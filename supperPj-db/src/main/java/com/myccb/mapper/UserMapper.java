package com.myccb.mapper;

import com.myccb.bean.db.UserDb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    UserDb selectByPrimaryKey(Long userId);

//    int select(UserDb param);
    UserDb find(UserDb param);

    int insert(UserDb param);

    int updateByPrimaryKeySelective (String userId);

    List<UserDb> findUserByPwd(UserDb UserDb);

    List<UserDb> selectUserRole(Map map);
}
