package com.myccb;

import com.alibaba.fastjson.JSON;
import com.myccb.comm.util.ApplicationContextFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;
import org.springframework.web.context.WebApplicationContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 * 测试启动类
 * @auther 黄弋峰
 */
public class MockMvcTest {

    @Autowired
    public WebApplicationContext context;
    public MockMvc mvc;
    public String token;
    public String preLoginData;
    public String sessionId;

    private static final Logger logger = LoggerFactory.getLogger(MockMvcTest.class);

    @Before
    public void setMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * 登录
     * @param s
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void login(String s) throws Exception{
        logger.info("----------开始测试" + "登录----------");
        //读取json路径下的报文
        String s1 = TestUtil.readFileToString("./jsonFile/login.json");
        //读取报文内容
        Map<String, String> map = JSON.parseObject(s1,Map.class);
        map.put("preLoginData",s);
        //映射报文
        String s2 = JSON.toJSONString(map);
        MockHttpServletResponse response = mvc
                .perform(MockMvcRequestBuilders.post("/login")
                        .header("mockMvcTest","1").content(s2)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse();
        String result = response.getContentAsString();
        Map<String, Object> resultMap = JSON.toJavaObject(JSON.parseObject(result), Map.class);
        sessionId = String.valueOf(response.getHeaders("sessionId")).replace("[","").replace("]","");
        logger.info("----------返回结果：" + resultMap + "----------");
        token = String.valueOf(response.getHeaders("token")).replace("[","]").replace("]","");
        logger.info("----------返回token：" + token + "----------");
    }

    /**
     * 测试类启动项
     * @param jsonFliePath
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> runTest (String jsonFliePath) throws Exception{
        MockHttpServletResponse response = mvc
                .perform(MockMvcRequestBuilders.post("/appMid/request/json/")
                        .content(TestUtil.readFileToString(jsonFliePath))
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse();
        String result = response.getContentAsString();
        Map<String, Object> resultMap = JSON.toJavaObject(JSON.parseObject(result), Map.class);
        logger.info("开始返回", resultMap);
        Map<String, Object> header = (Map<String, Object>) resultMap.get("header");
        String code = (String) header.get("code");
        Assert.assertTrue("返回码不正确","0000".equals(code));
        return resultMap;
    }

    /**
     * 定时任务类测试
     * @param className
     * @param map
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws SecurityException
     * @throws InvocationTargetException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> runTaskTest(String className, Map<String, Object> map) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, SecurityException, InvocationTargetException{
        Object createInstance = ApplicationContextFactory.getBean(className);
        Method method = createInstance.getClass().getDeclaredMethod("doStepJob", Map.class);
        return (Map<String, Object>) method.invoke(createInstance, map);
    }


}
