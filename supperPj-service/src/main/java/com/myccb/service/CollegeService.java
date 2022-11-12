package com.myccb.service;

import com.myccb.appmid.common.gateway.rewrite.AppMidRequestHeader;
import com.myccb.appmid.common.gateway.util.ServiceExceptionMycc;
import com.myccb.appmid.service.process.Service;
import com.myccb.bean.CollegeReq;
import com.myccb.bean.db.CollegeDb;
import com.myccb.comm.StringUtilsMycc;
import com.myccb.comm.constant.CommConstant;
import com.myccb.mapper.CollegeMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public Map<String , List<CollegeDb>> selectCollege (CollegeReq collegeReq, SqlSession sqlSession, AppMidRequestHeader appMidRequestHeader)throws ServiceExceptionMycc{
        logger.info("查询部门服务开始，请求参数，{}" ,collegeReq);
        Assert.isNull(collegeReq.getNum(),"必输项部门编号为空！");
        List<CollegeDb> list = new ArrayList<>();
        try{
            CollegeDb db = SetReqToDb(collegeReq);
            list = (List<CollegeDb>) sqlSession.getMapper(CollegeMapper.class).find(db);
        } catch (Exception e){
            logger.info("查询数据异常，有大问题！！");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE,"查询数据异常，有大问题！！");
        }
        Map<String , List<CollegeDb>> map = new HashMap<>();
        map.put(CommConstant.DATA, list);
        return map;
    }

    /**
     * 删除部门服务
     * @param collegeReq
     * @param sqlSession
     * @param appMidRequestHeader
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("deleteCollege")
    public String deleteCollege (CollegeReq collegeReq, SqlSession sqlSession, AppMidRequestHeader appMidRequestHeader) throws ServiceExceptionMycc{
        logger.info("删除部门服务开始，请求参数，{}", collegeReq);
        Assert.isNull(collegeReq.getNum(),"必输项部门编号为空！");
        try {
            CollegeDb db = SetReqToDb(collegeReq);
            CollegeDb collegeDb = sqlSession.getMapper(CollegeMapper.class).selectByPrimaryKey(db.getNum());
            if (collegeDb != null) {
                throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "该部门下还存在人员，不可删除！");
            } else {
                sqlSession.getMapper(CollegeMapper.class).deleteByPrimaryKey(db.getNum());
            }
        } catch (ServiceExceptionMycc e) {
            logger.info("该部门下还存在人员，不可删除！", e.getDesc());
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "该部门下还存在人员，不可删除！");
        } catch (Exception e) {
            logger.info("该部门下还存在人员，不可删除！");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "该部门下还存在人员，不可删除！");
        }
        return CommConstant.SUCCESS;
    }

    @Service("updateCollege")
    public String updateCollege (CollegeReq collegeReq, SqlSession sqlSession, AppMidRequestHeader appMidRequestHeader) throws ServiceExceptionMycc{
        logger.info("修改部门服务开始，请求参数，{}", collegeReq);
        Assert.isNull(collegeReq.getNum(), "必输项部门编号为空！");
        try {

        } catch () {

        }
    }

    /**
     * 将请求参数设置到数据库
     * @param collegeReq
     * @return
     */
    private CollegeDb SetReqToDb(CollegeReq collegeReq){
        return CollegeDb.builder()
                .num(collegeReq.getNum())
                .collegeName(collegeReq.getCollegeName())
                .address(collegeReq.getAddress())
                .membeNum(collegeReq.getClooegeMember())
                .build();
    }
}
