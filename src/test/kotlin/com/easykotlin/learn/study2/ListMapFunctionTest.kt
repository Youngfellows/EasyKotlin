package com.easykotlin.learn.study2

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ListMapFunctionTest {

    /**
     * 创建对象
     */
    val listMapFunction: ListMapFunction = ListMapFunction()

    @Test
    fun testListMapFunction1() {
        listMapFunction.listMapFunction1()
    }

    @Test
    fun testListMapFunction2() {
        listMapFunction.listMapFunction2()
    }
}