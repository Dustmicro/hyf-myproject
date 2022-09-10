package com.myccb.comm;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Collection;
import java.util.Map;

import static java.util.Objects.isNull;

/**
 * 字符串工具类
 * @author 黄弋峰
 */
public class StringUtilsMycc extends StringUtils {

    /**空字符串**/
    private static final String NULLSTR = " ";
    /**下划线**/
    private static final char SEPARATOR = '_';

    /**
     * 判断传回来的参数是否为空
     * @param value
     * @param defaultValue
     * @param <T>
     * @return
     */
    public static <T> T nvl(T value, T defaultValue){
        return value != null ? value:defaultValue;
    }

    /**
     * 判断一个Collection是否为空，包含List,set,
     * @param coll
     * @return true为空：false为非空
     */
    public static boolean isEmpty(Collection<?> coll){
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * 判断一个Collection是否为非空，包含List,set,
     * @param coll
     * @return true为非空；false为非空
     */
    public static boolean isNotEmpty(Collection<?> coll){
        return ! isEmpty(coll);
    }

    /**
     * 判断一个对象是否为空
     * @param object
     * @return
     */
    public static boolean isNull(Object object){
        return object == null;
    }

    /**
     * 判断一个对象数组是否为空
     * @param object
     * @return
     */
    public static boolean isEmpty(Object[] object){
        return isNull(object) || (object.length == 0);
    }

    /**
     * 判断一个对象数组是否为非空
     * @param object
     * @return
     */
    public static boolean isNotEmpty(Object[] object){
        return !isEmpty(object);
    }

    /**
     * 判断一个Map是否为空
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map){
        return isNull(map) || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map){
        return !isEmpty(map);
    }
}
