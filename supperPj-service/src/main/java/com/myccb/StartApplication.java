package com.myccb;

import com.myccb.comm.util.ServiceStartInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.myccb.appmid","com.myccb"})
public class StartApplication {
    private static final Logger logger = LoggerFactory.getLogger(StartApplication.class);
    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(StartApplication.class);
//        ServiceStartInit.InitSystemConfig(context);
        SpringApplication.run(StartApplication.class, args);
        logger.info("启动成功！");
    }
}
