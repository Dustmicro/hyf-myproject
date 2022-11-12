package com.myccb.service;


import com.myccb.bean.db.UserDb;
import com.myccb.comm.StringUtilsMycc;
import com.myccb.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户操作类
 * @author 黄弋峰
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMapper userMapper;

    /**
     * 通过用户id查询用户
     * @param userId
     * @return
     */
    public UserDb findUserById(Long userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 通过账号、密码查询用户
     * @param name
     * @param password
     * @return
     */
    public UserDb findUserByPwd(String name, String password){
        UserDb db = UserDb.builder()
                .name(name)
                .password(password)
                .build();
        List<UserDb> list = userMapper.findUserByPwd(db);
        if (StringUtilsMycc.isNotEmpty(list)){
            return list.get(0);
        }
        return null;
    }

    /**
     * 校验用户权限
     * @param userId
     * @param serviceId
     * @return
     */
    public boolean CheckRole(String userId, String serviceId){
        boolean flag = false;
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("serviceId", serviceId);
        List<UserDb> list = userMapper.selectUserRole(map);
        if (StringUtilsMycc.isNotEmpty(list)){
            flag = true;
        }
        return flag;
    }

    /**
     * 是否本部门校验
     * @param userId
     * @param departmentId
     * @return
     */
    public static boolean CheckDepartment(Long userId, Integer departmentId, SqlSession sqlSession){
        boolean flag = false;
        UserDb department = sqlSession.getMapper(UserMapper.class).selectByPrimaryKey(userId);
        if (departmentId.equals(department.getCollegeNum())){
            flag = true;
            logger.info("是该部门人员，可以操作！");
        }
        return flag;
    }
}
