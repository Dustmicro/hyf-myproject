package utils.cache;

import com.myccb.bean.entity.mapping.Mapping;
import com.myccb.comm.redis.BaseCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import utils.constant.DomainContant;
import utils.util.DateUtil;
import utils.util.SerializeUtil;

/**
 * 映射缓存工具类
 * @author 黄弋峰 2022/11/12
 */
public class MappingCache extends BaseCache {
    private static final Logger logger = LoggerFactory.getLogger(MappingCache.class);

    //后缀 用来刷缓存时删除 所有以这个为后缀的数据
    public final static String _SUFFIX_MAPPING = "_SUFFIX_MAPPING";
    //日志
    public final static String LOG_SERVICE_CODE = "LOG_SERVICE_CODE";

    /**
     * 获取值
     * @param domain
     * @param key
     * @return
     */
    public static String getValue(String domain, String key) {
        Jedis redis = null;
        long startTime = DateUtil.getCurrentDate().getTime();
        try {
            redis = getJedis();
            Object object = SerializeUtil.unserialize(redis.get((domain + key + _SUFFIX_MAPPING).getBytes()));
            if (object == null) {
                return null;
            }

            Mapping mapping = (Mapping) object;
            return mapping.getValue();
        } finally {
            if (redis != null) {
                redis.close();
            }

            logger.debug(domain + "::" + key + " redis 耗时：" + (DateUtil.getCurrentDate().getTime() - startTime));
        }
    }

    /**
     * 获取公用域下的key值
     *
     * @param key
     * @return
     */
    public static String getValue(String key) {
        Mapping mapping = getMapping(key);
        return mapping == null ? "" : mapping.getValue();
    }

    public static Mapping getMapping(String key) {
        Jedis redis = null;
        long startTime = DateUtil.getCurrentDate().getTime();

        try {
            redis = getJedis();
            Object obj = SerializeUtil.unserialize(redis.get((DomainContant.COMMON_DOMAIN + key + _SUFFIX_MAPPING).getBytes()));
            if (obj instanceof Mapping) {
                return (Mapping) obj;
            }
        } finally {
            if (redis != null) {
                redis.close();
            }
            logger.debug( key + " redis 耗时：" + (DateUtil.getCurrentDate().getTime() - startTime));

        }
        return null;
    }
}
