package com.myccb.comm;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 字符串工具类
 * @author 黄弋峰
 */
public class StringUtilsMycc extends Assert {

    /**空字符串**/
    private static final String NULLSTR = " ";
    /**下划线**/
    private static final char SEPARATOR = '_';
    private static Object BeanConvertUtil;

    public static void hasValue(Object value,String msg){
        Assert.notNull(value, msg);
        Assert.hasLength(value.toString(), msg);

    }

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
        Assert.isNull(coll);
        return coll.isEmpty();
    }

    /**
     * 判断一个Collection是否为非空，包含List,set,
     * @param coll
     * @return true为非空；false为非空
     */
    public static boolean isNotEmpty(Collection<?> coll){
        return ! isEmpty(coll);
    }

//    /**
//     * 判断一个对象是否为空
//     *
//     * @param object
//     * @return
//     */
//    public static boolean isNull(Object object){
//
//        return false;
//    }

    /**
     * 判断一个对象数组是否为空
     * @param object
     * @return
     */
    public static boolean isEmpty(Object[] object){
        Assert.isNull(object);
        return (object.length == 0);
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
        Assert.isNull(map);
        return map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map){
        return !isEmpty(map);
    }

    /**
     * 判断list 是否为空
     * @param jsonObject
     * @param key
     * @param message
     */
    public static void isNotNull(Map jsonObject, String key, String message) {
        Assert.notEmpty(jsonObject, message);

        if (!jsonObject.containsKey(key)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判断是否只有一条记录数据
     *
     * @param targetList
     * @param message
     */
    public static void isOne(List<?> targetList, String message) {
        Assert.notNull(targetList, message);

        if (targetList.size() != 1) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 校验map 中是否有值
     *
     * @param targetMap
     * @param message
     */
    public static void hasSize(Map<?, ?> targetMap, String message) {
        Assert.isNull(targetMap, message);

        if (targetMap.size() < 1) {
            throw new IllegalArgumentException(message);
        }

    }

    /**
     * 判断 jsonObject 是否为空
     *
     * @param info
     * @param key
     * @param message
     */
    public static void hasKeyAndValue(Map info, String key, String message) {
        isNotNull(info, key, message);
        hasLength(info.get(key) == null ? "" : info.get(key).toString(), message);
    }

//    /**
//     * 判断 jsonObject 是否为空
//     *
//     * @param info
//     * @param key
//     * @param message
//     */
//    public static void hasKeyAndValue(Object info, String key, String message) {
//        hasKeyAndValue(BeanConvertUtil.beanCovertMap(info), key, message);
//    }


    /**
     * 校验是否为JSON
     *
     * @param msg
     * @return
     */
    public static Boolean isJsonObject(String msg) {
        try {
            JSONObject.parseObject(msg);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Boolean isPageJsonObject(String msg) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(msg);
            if (!jsonObject.containsKey("meta") || !jsonObject.containsKey("param")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Description:判断字段空null <br>
     *
     * @param s
     * @return boolean
     */
    public static boolean isNullOrNone(String s) {
        if (s == null || "".equals(s.trim())) {
            return true;
        }

        return false;
    }

    /**
     * 检验是否在 infos 中存在 flowComponent 对应组件的key
     *
     * @param infos
     * @param flowComponent
     * @param key
     * @param message
     */
    public static void hasKeyByFlowData(JSONArray infos, String flowComponent, String key, String message) {

        for (int infoIndex = 0; infoIndex < infos.size(); infoIndex++) {
            JSONObject _info = infos.getJSONObject(infoIndex);
            if (_info.containsKey(flowComponent) && _info.getString("flowComponent").equals(flowComponent)) {
                hasKeyAndValue(_info, key, message);
                break;
            }
        }

    }

    @SuppressWarnings("rawtypes")
    public static boolean objIsEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            if (o.toString().trim().equals("")) {
                return true;
            }
            if (o.equals("null") || o.equals("NULL")) {
                return true;
            }
        } else if (o instanceof List) {
            if (((List) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Set) {
            if (((Set) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Object[]) {
            if (((Object[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof int[]) {
            if (((int[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof long[]) {
            if (((long[]) o).length == 0) {
                return true;
            }
        }
        return false;
    }


//    /**
//     * 检验是否在 infos 中存在 flowComponent 对应组件的key
//     *
//     * @param key
//     * @param message
//     */
//    public static void isEmail(JSONObject info, String key, String message) {
//        hasKeyAndValue(info, key, message);
//        if (!ValidatorUtil.isEmail(info.getString(key))) {
//            throw new IllegalArgumentException(message);
//        }
//    }

    public static void judgeAttrValue(JSONObject paramObj){
        if (!paramObj.containsKey("attrs")) {
            return;
        }

        JSONArray attrs = paramObj.getJSONArray("attrs");
        if (attrs.size() < 1) {
            return;
        }
        JSONObject attr = null;
        for (int attrIndex = 0; attrIndex < attrs.size(); attrIndex++) {
            attr = attrs.getJSONObject(attrIndex);
            if (!"Y".equals(attr.getString("required"))) {
                continue;
            }
//            Assert.hasKeyAndValue(attr, "value", attr.getString("specName") + "不能为空");
//
//            //整数
//            if ("2002".equals(attr.getString("specValueType"))) {
//                Assert.isInteger(attr.getString("value"), attr.getString("specName") + "不是整数");
//            }
//
//            //整数
//            if ("3003".equals(attr.getString("specValueType"))) {
//                Assert.isMoney(attr.getString("value"), attr.getString("specName") + "不是金额类型 如 3.00");
//            }
//
//            // 日期4004
//            if ("4004".equals(attr.getString("specValueType"))) {
//                Assert.isDate(attr.getString("value"), DateUtil.DATE_FORMATE_STRING_B, attr.getString("specName") + "不是日期格式 YYYY-MM-DD");
//            }
//
//            // 日期5005
//            if ("5005".equals(attr.getString("specValueType"))) {
//                Assert.isDate(attr.getString("value"), DateUtil.DATE_FORMATE_STRING_A, attr.getString("specName") + "不是日期格式 YYYY-MM-DD hh:mm:ss");
//            }
        }
    }
}
