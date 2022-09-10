package com.myccb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.myccb.appmid","com.myccb"})
public class StartApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringApplication.class);
//        ServiceStar
    }
}
