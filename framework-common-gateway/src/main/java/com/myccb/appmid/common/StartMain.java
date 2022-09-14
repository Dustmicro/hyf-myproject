package com.myccb.appmid.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ConfigurationPropertiesScan
@ComponentScan(basePackages = "com.myccb.appmid")
public class StartMain {
    private static final Logger logger = LoggerFactory.getLogger(StartMain.class);
    public static void main(String[] args) {
        SpringApplication.run(StartMain.class,args);
        logger.info("启动成功！");
    }
}
