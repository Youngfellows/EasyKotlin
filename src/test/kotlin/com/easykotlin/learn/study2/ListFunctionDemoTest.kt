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
}