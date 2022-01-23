package com.easykotlin.learn.study9;

/**
 * 可变参数
 */
public class VarArgs {

    /**
     * 添加元素
     */
    public static <T> String appendElement(T... element) {
        StringBuilder sb = new StringBuilder();
        /*for (T e : element) {
            sb.append(e);
            sb.append(",");
        }*/
        int length = element.length;
        for (int i = 0; i < length; i++) {
            sb.append(element[i]);
            if (i != length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
