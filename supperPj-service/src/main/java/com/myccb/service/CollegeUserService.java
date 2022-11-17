package com.myccb.service;

import com.myccb.appmid.common.gateway.rewrite.AppMidRequestHeader;
import com.myccb.appmid.common.gateway.util.ServiceExceptionMycc;
import com.myccb.appmid.service.process.Service;
import com.myccb.bean.CollegeUserReq;
import com.myccb.bean.db.CollegeUserDb;
import com.myccb.bean.db.UserDb;
import com.myccb.comm.constant.CommConstant;
import com.myccb.mapper.CollegeUserDbMapper;
import com.myccb.mapper.UserDbMapper;
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
public class CollegeUserService {
    private static final Logger logger = LoggerFactory.getLogger(CollegeUserService.class);

    /**
     * 部门查询服务类（单笔查询）
     * @param collegeUserReq
     * @param sqlSession
     * @param appMidRequestHeader
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("selectCollege")
    public Map<String , List<CollegeUserDb>> selectCollege (CollegeUserReq collegeUserReq, SqlSession sqlSession, AppMidRequestHeader appMidRequestHeader)throws ServiceExceptionMycc{
        logger.info("查询部门服务开始，请求参数，{}" , collegeUserReq);
        Assert.isNull(collegeUserReq.getCollegeNum(),"必输项部门编号为空！");
        List<CollegeUserDb> list = new ArrayList<>();
        try{
            CollegeUserDb db = SetReqToDb(collegeUserReq);
            list = (List<CollegeUserDb>) sqlSession.getMapper(CollegeUserDbMapper.class).find(db);
        } catch (Exception e){
            logger.info("查询数据异常，有大问题！！");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE,"查询数据异常，有大问题！！");
        }
        Map<String , List<CollegeUserDb>> map = new HashMap<>();
        map.put(CommConstant.DATA, list);
        return map;
    }

    /**
     * 删除部门服务
     * @param collegeUserReq
     * @param sqlSession
     * @param appMidRequestHeader
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("deleteCollege")
    public String deleteCollege (CollegeUserReq collegeUserReq, SqlSession sqlSession, AppMidRequestHeader appMidRequestHeader) throws ServiceExceptionMycc{
        logger.info("删除部门服务开始，请求参数，{}", collegeUserReq);
        Assert.isNull(collegeUserReq.getCollegeNum(),"必输项部门编号为空！");
        try {
            CollegeUserDb db = SetReqToDb(collegeUserReq);
            CollegeUserDb collegeUserDb = sqlSession.getMapper(CollegeUserDbMapper.class).selectByPrimaryKey(db.getCollegeNum());
            if (collegeUserDb != null) {
                throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "该部门下还存在人员，不可删除！");
            } else {
                sqlSession.getMapper(CollegeUserDbMapper.class).deleteByPrimaryKey(db.getCollegeNum());
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

    /**
     * 修改部门服务
     * @param collegeUserReq
     * @param sqlSession
     * @param appMidRequestHeader
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("updateCollege")
    public String updateCollege (CollegeUserReq collegeUserReq, SqlSession sqlSession, AppMidRequestHeader appMidRequestHeader) throws ServiceExceptionMycc{
        logger.info("修改部门服务开始，请求参数，{}", collegeUserReq);
        Assert.isNull(collegeUserReq.getCollegeNum(), "必输项部门编号为空！");
        try {
            CollegeUserDb db = SetReqToDb(collegeUserReq);
            sqlSession.getMapper(CollegeUserDbMapper.class).updateByPrimaryKeySelective(db);
            /**同时修改成员表信息**/
            UserDb user = SetCollegeToUserDb(db);
            sqlSession.getMapper(UserDbMapper.class).updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            logger.info("修改部门服务异常！");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "修改部门服务异常！");
        }
        return CommConstant.SUCCESS;
    }

    /**
     * 新增部门服务
     * @param collegeUserReq
     * @param sqlSession
     * @param appMidRequestHeader
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("insertCollege")
    public String insertCollege (CollegeUserReq collegeUserReq, SqlSession sqlSession, AppMidRequestHeader appMidRequestHeader) throws ServiceExceptionMycc{
        logger.info("新增部门服务开始，请求参数，{}", collegeUserReq);
        Assert.isNull(collegeUserReq.getCollegeNum(),"必输项学院编号为空！");
        Assert.isNull(collegeUserReq.getCollegeMember());
        try {
            //应当添加一个权限校验
            CollegeUserDb db = SetReqToDb(collegeUserReq);
            sqlSession.getMapper(CollegeUserDbMapper.class).insert(db);
        } catch (Exception e) {
            logger.info("新增部门异常！！");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "新增部门异常！！");
        }
        return CommConstant.SUCCESS;
    }

    /**
     * 将请求参数设置到数据库
     * @param collegeUserReq
     * @return
     */
    private CollegeUserDb SetReqToDb(CollegeUserReq collegeUserReq){
        return CollegeUserDb.builder()
                .collegeNum(collegeUserReq.getCollegeNum())
                .collegeName(collegeUserReq.getCollegeName())
                .address(collegeUserReq.getAddress())
                .membeNum(collegeUserReq.getMembeNum())
                .build();
    }

    private UserDb SetCollegeToUserDb(CollegeUserDb db){
        return UserDb.builder()
                .collegeNum(db.getCollegeNum())
                .collegeName(db.getCollegeName())
                .userId(db.getMembeNum())
                .build();
    }
}
