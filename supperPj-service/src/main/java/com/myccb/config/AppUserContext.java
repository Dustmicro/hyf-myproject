package com.myccb.config;

/**
 * 登录通过userInfo可获取到登录的用户信息
 * @author 黄弋峰 2022/11/16
 */
public class AppUserContext {
    private static final ThreadLocal<UserDb> userInfo = new ThreadLocal<>();

    private AppUserContext(){

    }

    public static UserDb getUserDb(){
        return userInfo.get();
    }

    public static void setUserDb(UserDb userDb){
        userInfo.set(userDb);
    }

    public static void remove(){
        userInfo.remove();
    }
}
