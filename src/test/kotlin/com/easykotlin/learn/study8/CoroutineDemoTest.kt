package com.easykotlin.learn.study8

import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CoroutineDemoTest {

    /**
     *创建对象
     */
    val coroutineDemo: CoroutineDemo = CoroutineDemo()

    @Test
    fun testCoroutineDemo1() = runBlocking {
        coroutineDemo.coroutineDemo1()
    }

    @Test
    fun testCoroutineDemo2() = runBlocking {
        coroutineDemo.coroutineDemo2()
    }

    @Test
    fun testCoroutineDemo3() = runBlocking {
        coroutineDemo.coroutineDemo3()
    }

    @Test
    fun testCoroutineDemo4() {
        coroutineDemo.coroutineDemo4()
    }

}