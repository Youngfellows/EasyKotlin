package com.easykotlin.learn.study11

/**
 * 伴生类
 */
class UtilObjectKotlin {

    companion object {
        /**
         * 静态方法
         */
        @JvmStatic
        fun ok(): String {
            return "UtilObjectKotlin.ok()"
        }
    }
}