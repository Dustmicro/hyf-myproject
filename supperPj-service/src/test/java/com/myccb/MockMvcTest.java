package com.myccb;

import com.alibaba.fastjson.JSON;
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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import java.awt.*;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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

    @SuppressWarnings("uncheck")
    public void login(String s) throws Exception{
        logger.info("----------开始测试" + "登录----------");
        //读取json路径下的报文
        String s1 = TestUtil.readFileToString("./jsonFile/login.json");
        //读取报文内容
        Map<String, String> map = JSON.parseObject(s1,Map.class);
        map.put("preLoginData",s);
        //映射报文
        String s2 = JSON.toJSONString(map);
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post("/login"))
                .header("mockMvcTest","1")
                .content(s2)
                .contentType(PageAttributes.MediaType.)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .getResponse;
        String result = response.getContentAsString();
        Map<String, Object> resultMap = JSON.toJavaObject(JSON.parseObject(result), Map.class);
        sessionId = String.valueOf(response.getHeaders("sessionId")).replace("[","").replace("]","");
        logger.info("----------返回结果：" + resultMap + "----------");
        token = String.valueOf(response.getHeaders("token")).replace("[","]").replace("]","");
        logger.info("----------返回token：" + token + "----------");
    }


}
