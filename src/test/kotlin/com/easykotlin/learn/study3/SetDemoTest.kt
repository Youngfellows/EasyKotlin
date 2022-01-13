package com.easykotlin.learn.study3

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SetDemoTest {

    /**
     * 创建对象
     */
    private val setDemo: SetDemo = SetDemo()


    @Test
    fun testSetCreate() {
        setDemo.setCreate()
    }

    @Test
    fun testSetOperator() {
        setDemo.setOperator()
    }
}