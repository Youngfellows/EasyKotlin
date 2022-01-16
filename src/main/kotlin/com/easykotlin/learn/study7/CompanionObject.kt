package com.easykotlin.learn.study7

/**
 * 伴生对象(companion object)
 * 1.用companion object关键字声明
 * 2.一个类只能有1个伴生对象
 */
class CompanionObject {

    /**
     * 伴生对象HttpUtils
     */
    companion object HttpUtils {

        /**
         * 网络是否连接
         */
        fun connect(speed: Double): Boolean {
            if (speed > 100) {
                return true
            }
            return false
        }
    }
}