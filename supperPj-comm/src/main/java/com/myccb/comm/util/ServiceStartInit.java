package com.myccb.comm.util;

import org.springframework.context.ApplicationContext;

/**
 * 初始化服务类
 * @author 黄弋峰
 */
public class ServiceStartInit {
    private ServiceStartInit(){

    }

    public static void InitSystemConfig(ApplicationContext context){
        try {
            ApplicationContextFactory.setApplicationContext(context);
        }catch (Exception e){
            throw new IllegalStateException("系统初始化失败", e);
        }
    }
}
