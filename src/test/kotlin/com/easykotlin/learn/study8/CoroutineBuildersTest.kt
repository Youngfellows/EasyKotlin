package com.easykotlin.learn.study8

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CoroutineBuildersTest {

    /**
     * 创建对象
     */
    val coroutineBuilders: CoroutineBuilders = CoroutineBuilders()

    @Test
    fun testLaunchCreateCoroutine() {
        coroutineBuilders.launchCreateCoroutine()
    }

    @Test
    fun testAsyncCreateCoroutine() {
        coroutineBuilders.asyncCreateCoroutine()
    }

    @Test
    fun testAsyncCreateCoroutine2() {
        coroutineBuilders.asyncCreateCoroutine2()
    }

    @Test
    fun testAsyncCreateCoroutine3() {
        coroutineBuilders.asyncCreateCoroutine3()
    }

    @Test
    fun testCoroutineCallback() {
        coroutineBuilders.coroutineCallback()
    }

    @Test
    fun testRunBlockingCreateCoroutine() {
        val mountains: MutableList<String> = coroutineBuilders.runBlockingCreateCoroutine()
        mountains.forEach() {
            println(it)
        }
    }

    @Test
    fun testCreateCoroutine() {
        val coroutineScope: CoroutineScope = CoroutineScope()
        coroutineScope.createCoroutine()
    }
}