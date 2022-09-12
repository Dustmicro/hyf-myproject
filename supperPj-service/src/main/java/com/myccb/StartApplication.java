package com.myccb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.myccb.appmid","com.myccb"})
public class StartApplication {
    private static final Logger logger = LoggerFactory.getLogger(StartApplication.class);
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringApplication.class);
//        ServiceStar
        logger.info("启动成功！");
    }
}
