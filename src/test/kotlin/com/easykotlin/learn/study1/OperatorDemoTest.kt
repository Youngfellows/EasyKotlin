package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class OperatorDemoTest {

    @Test
    fun testPointUnaryMinus() {
        val point = Point(1, 2)
        val np = -point//调用重载后"-"操作符号
        println(point)
        println(np)
        val mp = +point
        println(mp)
    }

    @Test
    fun testCounterIndexPlus() {
        val counter = Counter(3)
        val counter1 = counter + 3 //自定义重载的 + 运算符
        println(counter)
        println(counter1)
    }
}