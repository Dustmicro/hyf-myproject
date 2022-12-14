package com.myccb.service;

import com.myccb.appmid.common.gateway.rewrite.AppMidRequestHeader;
import com.myccb.appmid.service.process.Service;
import com.myccb.bean.CollegeUserReq;
import com.myccb.bean.UserReq;
import com.myccb.bean.db.CollegeUserDb;
import com.myccb.bean.db.UserDb;
import com.myccb.comm.CommService;
import utils.util.StringUtilsMycc;
import com.myccb.comm.constant.CommConstant;
import com.myccb.mapper.CollegeUserDbMapper;
import com.myccb.mapper.UserDbMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.myccb.appmid.common.gateway.util.ServiceExceptionMycc;
import org.springframework.util.Assert;

import java.util.*;


/**
 * 用户服务
 * @author 黄弋峰
 */
public class UserActiveService {
    private static final Logger logger = LoggerFactory.getLogger(UserActiveService.class);

    /**
     * 用户新增服务
     * @param userReq
     * @param sqlSession
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("InsertUser")
    public String InsertUser(UserReq userReq, SqlSession sqlSession) throws ServiceExceptionMycc {
        logger.info("人员新增服务开始，请求参数，{}",userReq);
        CommService.CheckEmpty(userReq.getUserName(), "用户姓名");
//        CommService.CheckEmpty(userReq.getAge(), "用户年龄");
        try {
//            UserDb db = UserDb.builder()
//                    .userName(userReq.getUserName())
//                    .age(userReq.getAge())
//                    .build();
//            db.setUserName(userReq.getUserName());
//            db.setAge(userReq.getAge());
            UserDb db = SetReqToDb(userReq);
            sqlSession.getMapper(UserDbMapper.class).insert(db);
        }catch (Exception e){
            logger.info("新增出错", e);
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE,"新增异常");
        }
        return CommConstant.SUCCESS;
    }

    /**
     * 修改用户信息服务
     * 待优化点：1：修改目标用户之前先查询该用户是否存在，查询的结果可能是多条
     *         2：将请求类字段设置到数据库操作可以提取出来用作公共方法
     *         3：传来的用户只要查库存在就做更新操作
     * @param userReq
     * @param sqlSession
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("UpdateUser")
    public String UpdateUser(UserReq userReq, SqlSession sqlSession) throws ServiceExceptionMycc{
        logger.info("人员修改服务开始，请求参数，{}",userReq);
        CommService.CheckEmpty(userReq.getUserName(), "用户姓名");
        try {
//            UserDb db = UserDb.builder()
//                    .userName(userReq.getUserName())
//                    .userId(userReq.getUserId())
//                    .age(userReq.getAge())
//                    .build();
//            db.setUserName(userReq.getUserName());
            UserDb db = SetReqToDb(userReq);
            UserDb user = sqlSession.getMapper(UserDbMapper.class).find(db);
            Assert.isNull(user,"该用户不存在");
//            if (){
//                throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "该用户不存在");
//            }
            if (user.getStatusCd() == null){
                throw new ServiceExceptionMycc(CommConstant.ERROR_CODE,"该用户不存在");
            }
            sqlSession.getMapper(UserDbMapper.class).updateByPrimaryKeySelective(user);

        }catch (Exception e){
            logger.info("修改用户信息异常", e);
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "修改用户信息异常");
        }
        return CommConstant.SUCCESS;
    }

    /**
     * 查询服务类
     * @param userReq
     * @param sqlSession
     * @param header
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("SelectUser")
    public Map<String , List<UserReq>> SelectUser(UserReq userReq, SqlSession sqlSession, AppMidRequestHeader header) throws ServiceExceptionMycc{
        logger.info("人员查询服务开始，请求参数，{}",userReq);
//        CommService.CheckEmpty(userReq.getUserId(),"用户id");
        Assert.isNull(userReq.getUserId(),"用户id为空！！" );
        List<UserReq> list = new ArrayList<>();
        try {
            UserDb db = SetReqToDb(userReq);
            list = (List<UserReq>) sqlSession.getMapper(UserDbMapper.class).find(db);
        }catch (Exception e){
            logger.info("查询异常");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE,"查询异常");
        }
        Map<String , List<UserReq>> map = new HashMap<>();
        map.put(CommConstant.DATA,list);
        return map;
    }

    /**
     * 删除服务类
     * @param userReq
     * @param sqlSession
     * @param header
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("deleteUser")
    public String deleteUser(UserReq userReq, SqlSession sqlSession, AppMidRequestHeader header) throws ServiceExceptionMycc{
        logger.info("人员删除服务，请求参数，{}", userReq);
//        CommService.CheckEmpty(userReq.getUserId(),"用户id");
        Assert.isNull(userReq.getUserId(),"用户id为空！！" );
        try {
            UserDb db = SetReqToDb(userReq);
            //查询用户权限
            UserDb role = sqlSession.getMapper(UserDbMapper.class).selectByPrimaryKey(db.getUserId());
            if ("1".equals(role.getAccount())){
                logger.info("该用户拥有权限，允许操作！");
                sqlSession.getMapper(UserDbMapper.class).deleteByPrimaryKey(db.getUserId());
            } else {
                throw new ServiceExceptionMycc(CommConstant.ERROR_CODE,"该用户没有权限，禁止该操作！");
            }
            UserService.CheckDepartment(userReq.getUserId(),userReq.getDepartmentId(),sqlSession);
            CollegeUserReq collegeUserReq = new CollegeUserReq();
            collegeUserReq.setCollegeNum(String.valueOf(userReq.getUserId()));
            //查询该成员是否还有部门信息
            List<CollegeUserDb> list = Collections.singletonList(sqlSession.getMapper(CollegeUserDbMapper.class).selectByPrimaryKey(collegeUserReq.getCollegeNum()));
            if (!StringUtilsMycc.isEmpty(list)){
                throw new ServiceExceptionMycc(CommConstant.ERROR_CODE,"该成员关联的有部门信息不能删除！！");
            }
        } catch (ServiceExceptionMycc e){
            logger.info("该用户没有权限，禁止该操作！", e.getDesc());
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE,"该用户没有权限，禁止该操作！");
        } catch (Exception e){
            logger.info("删除异常");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE,"删除异常");
        }
        return CommConstant.SUCCESS;
    }

    /**
     * 将请求报文字段设置到数据库
     * @param userReq
     * @return
     */
    private UserDb SetReqToDb(UserReq userReq){
        return UserDb.builder()
                .age(userReq.getAge())
                .userName(userReq.getUserName())
                .userId(String.valueOf(userReq.getUserId()))
                .build();
    }
}
