package com.myccb;


import com.alibaba.fastjson.JSON;
import myccb.HttpCilent;
import org.junit.Assert;
import org.slf4j.Logger;
import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TestUtil {
    private static final Logger logger = LoggerFactory.getLogger(TestUtil.class);

    private TestUtil(){

    }

    public static String readFileToString(String jsonFilePath){
        File file = new File(jsonFilePath);
        try{
            return FileUtils.readFileToString(file, String.valueOf("UTF-8"));
        }catch (IOException e){
            logger.debug("json转换异常！");
        }
        return null;
    }
    @SuppressWarnings("uncheck")
    public static void runTest(String jsonFilePath, String token){
        String json = TestUtil.readFileToString(jsonFilePath);
        HttpCilent.Response rs = null;
        try {
            rs = HttpCilent.operate(TestCommConstant.JSONURL,json,TestCommConstant.MRTHOD_POST,TestCommConstant.MESSAGE_TYPE_JSON);
            String content = rs.getContent();
            logger.info(TestCommConstant.CONTENT,content);
            Assert.assertNotNull(content);
            Map<String, Object> map = JSON.parseObject(content, Map.class);
            Map<String, String> header = (Map<String, String>) map.get(TestCommConstant.RSPHEADER);
            String rspCode = header.get(TestCommConstant.CODE);
            boolean flag = TestCommConstant.SUCCESS_CODE.equals(rspCode);
            Assert.assertTrue(TestCommConstant.FALSE_MSG,flag);
        }catch (IOException e){
            logger.info(TestCommConstant.EXCEPTIONMSG,e);
        }
    }
}
