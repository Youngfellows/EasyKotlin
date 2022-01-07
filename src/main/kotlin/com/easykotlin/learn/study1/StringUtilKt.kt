package com.easykotlin.learn.study1

/**
 * 可空类型使用
 */
class StringUtilKt {

    /**
     * 获取字符串长度
     */
    fun getLength1(str: String): Int {
        return str.length
    }

    /**
     * 获取字符串长度,str可为空,如果str为空，则返回null
     */
    fun getLength2(str: String?): Int? {
        return str?.length
    }

    /**
     * 获取字符串长度,str可为空,如果str为空，则抛出异常
     */
    fun getLength3(str: String?): Int? {
        return str!!.length
    }
}