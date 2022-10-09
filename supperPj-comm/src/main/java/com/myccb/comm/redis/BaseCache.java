package com.myccb.comm.redis;

import com.myccb.comm.StringUtilsMycc;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import java.util.Set;

/**
 * 缓存基类
 * @author 黄弋峰
 */
public class BaseCache {
    public BaseCache() {
    }

    protected static RedisProperties.Jedis getJedis(){
    }
    public static void removeData(String partten){
        RedisProperties.Jedis redis = null;
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
