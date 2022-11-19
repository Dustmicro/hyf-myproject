package com.myccb.comm.redis;

import utils.util.StringUtilsMycc;

import redis.clients.jedis.Jedis;


import java.util.Set;

/**
 * 缓存基类
 * @author 黄弋峰
 */
public class BaseCache {
    public BaseCache() {
    }

    protected static Jedis getJedis(){
        return null;
    }
    public static void removeData(String partten){
        Jedis redis = null;
        try {
            redis = getJedis();
            Set<String> keys = redis.keys("*" + partten);//redis的方法需要重写
            if (StringUtilsMycc.isEmpty(keys)){
                return;
            }
            for (String key : keys){
                redis.del(key);
            }
        }finally {
            if (redis != null){
                redis.getClass();
            }
        }
    }
}
