package com.myccb.service;

import com.myccb.appmid.common.gateway.rewrite.AppMidRequestHeader;
import com.myccb.bean.UserReq;
import com.myccb.bean.db.UserDb;
import com.myccb.comm.CommService;
import com.myccb.comm.constant.CommConstant;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.myccb.appmid.common.gateway.util.ServiceExceptionMycc;


public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public String InsertUser(UserReq userReq, SqlSession sqlSession, AppMidRequestHeader header) throws ServiceExceptionMycc {
        logger.info("人员新增服务开始，请求参数，{}",userReq);
        CommService.CheckEmpty(userReq.getUserName(), "用户姓名");
        CommService.CheckEmpty(userReq.getAge(), "用户年龄");
        try {
            UserDb db = new UserDb();
            db.setUserName(userReq.getUserName());
            db.setAge(userReq.getAge());
        }catch (Exception e){
            logger.info("新增出错", e);
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE,"新增异常");
        }
        return null;
    }
}
