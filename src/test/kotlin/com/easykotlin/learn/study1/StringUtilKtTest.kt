package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class StringUtilKtTest {

    /**
     * 创建对象
     */
    val stringUtilKt: StringUtilKt = StringUtilKt()

    @Test
    fun testGetLength() {
        val web: String = "www.google.com"
        var length: Int? = stringUtilKt.getLength1(web)
        println("length=${length}")

        var city: String? = "深圳市南山区"
        length = stringUtilKt.getLength2(city)
        println("length=${length}")

        city = null
        length = stringUtilKt.getLength2(city)
        println("length=${length}")

        city = null
        length = stringUtilKt.getLength3(city)
        println("length=${length}")
    }
}