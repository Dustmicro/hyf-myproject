package com.myccb.comm.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

/**
 * 上下文工厂
 * @author 黄弋峰
 */
public class ApplicationContextFactory {
    private ApplicationContextFactory(){

    }

    private static ApplicationContext applicationContext;

    private static void setApplicationContext(final ApplicationContext applicationContext){
        ApplicationContextFactory.applicationContext = applicationContext;
    }

    public static Object getBean(Class<?> className){
        return applicationContext.getBean(className);
    }

    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> t){
        Object bean = applicationContext.getBean(beanName);

        if (t.isAssignableFrom(bean.getClass())){
            return (T) bean;
        }
        return null;
    }

    /**
     * 获取应用名称
     * @return
     */
    public static String getApplicationName(){
        return applicationContext.getEnvironment().getProperty("spring.application.name");
    }

    public static String getMessage(String key){
        return applicationContext.getMessage(key,null, Locale.getDefault());
    }

    public static String getActiveProfile(){
        return applicationContext.getEnvironment().getActiveProfiles()[0];
    }
}
