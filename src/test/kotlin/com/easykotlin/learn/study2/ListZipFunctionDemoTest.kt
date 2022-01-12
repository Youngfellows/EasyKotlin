package com.easykotlin.learn.study2

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ListZipFunctionDemoTest {

    /**
     * 创建对象
     */
    private val listZipFunctionDemo: ListZipFunctionDemo = ListZipFunctionDemo()

    @Test
    fun testListZipFunction1() {
        listZipFunctionDemo.listZipFunction()
    }

    @Test
    fun testTistUnZipFunction() {
        listZipFunctionDemo.listUnZipFunction()
    }
}