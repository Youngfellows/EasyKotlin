package com.easykotlin.learn.study2

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ListFilterDemoTest {

    /**
     * 创建对象
     */
    val listFilterDemo: ListFilterDemo = ListFilterDemo()

    @Test
    fun testListFilterFunction1() {
        listFilterDemo.listFilterFunction1()
    }

    @Test
    fun testListFilterFunction2() {
        listFilterDemo.listFilterFunction2()
    }

    @Test
    fun testListFilterFunction3() {
        listFilterDemo.listFilterFunction3()
    }
}