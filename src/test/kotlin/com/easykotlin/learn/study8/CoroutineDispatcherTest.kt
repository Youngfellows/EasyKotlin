package com.easykotlin.learn.study8

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CoroutineDispatcherTest {

    /**
     * 创建对象
     */
    val dispatcher: CoroutineDispatcher = CoroutineDispatcher()

    @Test
    fun testCoroutineDispatcher() {
        dispatcher.coroutineDispatcher()
    }

    @Test
    fun testNotFather2child() {
        dispatcher.notFather2child()
    }

    @Test
    fun testFather2child() {
        dispatcher.father2child()
    }

    @Test
    fun testCoroutineContextPlus() {
        dispatcher.coroutineContextPlus()
    }

    @Test
    fun testCoroutineContextPlus2() {
        dispatcher.coroutineContextPlus2()
    }

    @Test
    fun testCoroutineContextPlusJob() {
        dispatcher.coroutineContextPlusJob()
    }
}