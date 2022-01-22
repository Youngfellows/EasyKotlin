package com.easykotlin.learn.study8

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CoroutineDemo2Test {

    /**
     * 创建对象
     */
    val coroutineDemo: CoroutineDemo2 = CoroutineDemo2()

    @Test
    fun testEbusiness() {
        if (coroutineDemo is IEbusiness) {
            println("xxxxx")
        }
        coroutineDemo.ebusiness()
    }

    @Test
    fun testCreateThread() {
        coroutineDemo.createThread()
    }

    @Test
    fun testCreateCoroutine() {
        coroutineDemo.createCoroutine()
    }

}