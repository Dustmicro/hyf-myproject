package com.myccb.service;

import com.myccb.appmid.common.gateway.rewrite.AppMidRequestHeader;
import com.myccb.appmid.common.gateway.util.ServiceExceptionMycc;
import com.myccb.appmid.service.process.Service;
import com.myccb.bean.CollegeReq;
import com.myccb.bean.db.CollegeDb;
import com.myccb.comm.constant.CommConstant;
import com.myccb.mapper.CollegeMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;


/**
 * 部门服务类
 * @author 黄弋峰 2022/11/10
 */
public class CollegeService {
    private static final Logger logger = LoggerFactory.getLogger(CollegeService.class);

    /**
     * 部门查询服务类（单笔查询）
     * @param collegeReq
     * @param sqlSession
     * @param appMidRequestHeader
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("selectCollege")
    public List<CollegeDb> selectCollege (CollegeReq collegeReq, SqlSession sqlSession, AppMidRequestHeader appMidRequestHeader)throws ServiceExceptionMycc{
        logger.info("查询部门服务开始，请求参数，{}" ,collegeReq);
        Assert.isNull(collegeReq.getNum(),"必输项部门编号为空！");
        List<CollegeDb> map = new ArrayList<>();
        try{
            CollegeDb db = SetReqToDb(collegeReq);
            CollegeDb college = sqlSession.getMapper(CollegeMapper.class).selectByPrimaryKey(db);
            map.add(college);
        } catch (Exception e){
            logger.info("查询数据异常，有大问题！！");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE,"查询数据异常，有大问题！！");
        }
        return map;
    }

    private CollegeDb SetReqToDb(CollegeReq collegeReq){
        return CollegeDb.builder()
                .num(collegeReq.getNum())
                .CollegeName(collegeReq.getCollegeName())
                .address(collegeReq.getAddress())
                .MembeNum(collegeReq.getClooegeMember())
                .build();
    }
}
