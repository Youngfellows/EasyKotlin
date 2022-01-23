package com.easykotlin.learn.study9;

import com.alibaba.fastjson.JSON;

/**
 * JSON转化工具类
 */
public class JSONUtils {

    /**
     * @param o 需要转化的对象
     * @return 将对象转化为JSON字符串
     */
    public static String toJsonString(Object o) {
        return JSON.toJSONString(o);
    }

    /**
     * 将一个json字符串转化为为对象
     *
     * @param json   json字符串
     * @param tClass 需要转化对象的字节码
     * @param <T>    返回对象的泛型
     * @return 返回对象
     */
    public static <T> T parseObject(String json, Class<T> tClass) {
        return JSON.parseObject(json, tClass);
    }

}
