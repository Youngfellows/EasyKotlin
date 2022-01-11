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

    @Test
    fun testListOperator2() {
        listOperatorDemo.listOperator2()
    }

    @Test
    fun testListOperator3() {
        listOperatorDemo.listOperator3()
    }

    @Test
    fun testListOperator4() {
        listOperatorDemo.listOperator4()
    }

    @Test
    fun testListOperator5() {
        listOperatorDemo.listOperator5()
    }
}