package com.easykotlin.learn.study2

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ListOperatorDemoTest {

    /**
     * 创建对象
     */
    private val listOperatorDemo: ListOperatorDemo = ListOperatorDemo()

    @Test
    fun testListOperator1() {
        listOperatorDemo.listOperator1()
    }
}