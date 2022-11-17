package com.myccb.service;

import com.myccb.appmid.common.gateway.util.ServiceExceptionMycc;
import com.myccb.appmid.service.process.Service;
import com.myccb.bean.CollegeReq;
import com.myccb.bean.db.CollegeDb;
import com.myccb.bean.db.UserDb;
import com.myccb.comm.constant.CommConstant;
import com.myccb.config.AppUserContext;
import com.myccb.mapper.CollegeDbMapper;
import com.myccb.mapper.UserDbMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.util.Assert;

/**
 * 学院服务
 * @author 黄弋峰 2022/11/17
 */
public class CollegeService {
    private static final Logger logger = LoggerFactory.getLogger(CollegeService.class);

    /**
     * 新增学院服务
     * @param collegeReq
     * @param sqlSession
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("addCollege")
    public String addCollege (CollegeReq collegeReq, SqlSession sqlSession) throws ServiceExceptionMycc {
        logger.info("新增学院服务开始，{}",collegeReq);
        Assert.isNull(collegeReq.getCollegeNum(), "必传项学院编号为空！！");
        Assert.isNull(collegeReq.getCollegeName(), "必传项学院名称为空！！");
        Assert.isNull(collegeReq.getMainUser(), "必传项主要负责人名称为空！！！");
        Assert.isNull(collegeReq.getTel(), "必传项电话为空！！");
        Assert.isNull(collegeReq.getAddress(), "必传项地址为空！！");
        try {
            CollegeDb db = setReqToDb(collegeReq);
            UserDb userId = AppUserContext.getUserDb();
            UserDb checkRole = sqlSession.getMapper(UserDbMapper.class).selectByPrimaryKey(userId.getUserId());
            if ("1".equals(checkRole)) {
                if (collegeReq.getUserId() == null) {
                    UserDb user = UserDb.builder()
                            .userName(collegeReq.getMainUser())
                            .tel(collegeReq.getTel())
                            .build();
                    UserDb num = sqlSession.getMapper(UserDbMapper.class).find(user);
                    if (num == null) {
                        throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "该成员未注册，请先注册该成员！！");
                    } else {
                        db.setUserId(num.getUserId());
                    }
                }
            } else {
                throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "只有队长才有权限进行该操作！！");
            }
            sqlSession.getMapper(CollegeDbMapper.class).insert(db);
        } catch (ServiceExceptionMycc e) {
            logger.info("该成员未注册，请先注册该成员！！");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, e.getDesc());
        } catch (ExceptionInInitializerError e) {
            logger.info("只有队长才有权限进行该操作！！");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, e.getLocalizedMessage());
        } catch (Exception e) {
            logger.info("新增学院异常！！");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "新增学院异常！！");
        }
        return CommConstant.SUCCESS;
    }

    /**
     * 将请求数据设置到数据库中
     * @param collegeReq
     * @return
     */
    private CollegeDb setReqToDb(CollegeReq collegeReq){
        return CollegeDb.builder()
                .collegeNum(collegeReq.getCollegeNum())
                .collegeName(collegeReq.getCollegeName())
                .tel(collegeReq.getTel())
                .userId(collegeReq.getUserId())
                .mainUser(collegeReq.getMainUser())
                .address(collegeReq.getAddress())
                .build();
    }
}
