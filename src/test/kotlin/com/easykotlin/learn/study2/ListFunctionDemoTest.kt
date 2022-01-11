package com.easykotlin.learn.study2

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ListFunctionDemoTest {

    private val listFunctionDemo: ListFunctionDemo = ListFunctionDemo()

    @Test
    fun testListFunction1() {
        listFunctionDemo.listFunction1()
    }

    @Test
    fun testListFunction2() {
        listFunctionDemo.listFunction2()
    }

    @Test
    fun testListFunction3() {
        listFunctionDemo.listFunction3()
    }

    @Test
    fun testListFunction4() {
        listFunctionDemo.listFunction4()
    }

    @Test
    fun testListFunction5() {
        listFunctionDemo.listFunction5()
    }

    @Test
    fun testListFunction6() {
        listFunctionDemo.listFunction6()
    }
}