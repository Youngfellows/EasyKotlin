package com.easykotlin.learn.study1

/**
 * 可空数据类型
 */
class NullableTypes {

    /**
     * y: String?可空数据类型
     */
    fun testNullable1(x: String, y: String?): Int {
        return x.length
    }

    /**
     * y: String?可空数据类型
     *  ?. 安全调用,如果y不为空，则返回y的长度,否则返回null
     */
    fun testNullable2(x: String, y: String?): Int? {
        return y?.length
    }


    /**
     * y: String?可空数据类型
     * !!.断言调用,如果y不为空，则返回y的长度,否则抛出异常
     */
    fun testNullable3(x: String, y: String?): Int? {
        return y!!.length
    }


}