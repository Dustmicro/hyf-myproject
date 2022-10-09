package com.myccb.comm.redis;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

public class JWTCache extends BaseCache{
    public static final String SESSION_PREFIX = "session_";

    public static String getValue(String jdi){
        RedisProperties.Jedis jedis = null;

        return null;
    }
}
