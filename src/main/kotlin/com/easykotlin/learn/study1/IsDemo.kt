package com.easykotlin.learn.study1

/**
 * 类型判断
 */
class IsDemo {

    /**
     * 类型判断,返回长度
     */
    fun strLen(any: Any): Int {
        when (any) {
            is String -> {
                return any.length
            }
            is Number -> {
                return any.toString().length
            }
            is Char -> {
                return 1
            }
        }
        return -1
    }

    /**
     * 类型判断,返回长度
     */
    fun strLen2(any: Any): Int {
        if (any is String) {
            return any.length
        } else if (any is Number) {
            return any.toString().length
        } else if (any is Char) {
            return 1
        }
        return -1
    }
}