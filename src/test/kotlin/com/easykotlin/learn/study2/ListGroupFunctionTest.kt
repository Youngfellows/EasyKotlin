package com.easykotlin.learn.study2

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ListGroupFunctionTest {

    /**
     * 创建对象
     */
    val listGroupFunctionDemo: ListGroupFunctionDemo = ListGroupFunctionDemo()

    @Test
    fun testListGroupFunction() {
        listGroupFunctionDemo.listGroupFunction1()
    }
}