package com.myccb;

import org.slf4j.Logger;
import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

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
//        try {
////            rs = HttpCilent.operate()
//        }catch (IOException e){
//            logger.info("!!!");
//        }
    }
}
