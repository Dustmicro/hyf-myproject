package com.myccb.service;

import com.myccb.appmid.common.gateway.util.ServiceExceptionMycc;
import com.myccb.appmid.service.process.Service;
import com.myccb.bean.db.DictionaryDb;
import com.myccb.bean.db.UserDb;
import com.myccb.comm.constant.CommConstant;
import com.myccb.config.AppUserContext;
import com.myccb.mapper.DictionaryDbMapper;
import com.myccb.mapper.UserDbMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.util.Assert;

/**
 * 字典值服务
 * @author 黄弋峰
 */
public class DictionaryService {
    private static final Logger logger = LoggerFactory.getLogger(DictionaryService.class);

    /**
     * 新增字典值服务
     * @param dictionaryDb
     * @param sqlSession
     * @return
     * @throws ServiceExceptionMycc
     */
    @Service("insertDictionary")
    public String insertDictionary (DictionaryDb dictionaryDb, SqlSession sqlSession) throws ServiceExceptionMycc {
        logger.info("新增字典值服务开始，请求参数，{}", dictionaryDb);
        Assert.isNull(dictionaryDb.getDicName(),"必输项字典值名称为空！！");
        Assert.isNull(dictionaryDb.getDicTypeId(),"必输项字典值编号为空！！");
        Assert.isNull(dictionaryDb.getMark(),"必输项字典值描述为空！！");
        try {
            UserDb user = AppUserContext.getUserDb();
            UserDb userRole = sqlSession.getMapper(UserDbMapper.class).selectByPrimaryKey(user.getUserId());
            if ("5".equals(userRole.getPermissions())) {
                throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "不是超级管理员，只有超级管理员才能进行该操作！！");
            }
            DictionaryDb dictionary = DictionaryDb.builder()
                    .dicName(dictionaryDb.getDicName())
                    .build();
            DictionaryDb db = sqlSession.getMapper(DictionaryDbMapper.class).find(dictionary);
            if (db != null) {
                throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "字典值名称重复，请重新输入！！");
            } else {
                sqlSession.getMapper(DictionaryDbMapper.class).insert(dictionaryDb);
            }
        } catch (ServiceExceptionMycc e) {
            logger.info("新增字典值异常！！");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, e.getDesc());
        } catch (Exception e) {
            logger.info("新增字典值异常！！");
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "新增字典值异常！！");
        }
        return CommConstant.SUCCESS;
    }
}
