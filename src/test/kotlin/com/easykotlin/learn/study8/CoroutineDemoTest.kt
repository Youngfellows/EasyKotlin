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

    @Test
    fun testCoroutineDemo5() {
        coroutineDemo.coroutineDemo5()
    }

    @Test
    fun testCreateThread() {
        coroutineDemo.createThread()
    }

    @Test
    fun testCreateCoroutine() {
        coroutineDemo.createCoroutine()
    }

    @Test
    fun testDaemonThread() {
        coroutineDemo.daemonThread()
    }

    @Test
    fun testDaemonCoroutine() {
        coroutineDemo.daemonCoroutine()
    }

    @Test
    fun testCancelCoroutine1() {
        coroutineDemo.cancelCoroutine1()
    }

    @Test
    fun testCancelCoroutine2() {
        coroutineDemo.cancelCoroutine2()
    }

    @Test
    fun testCancelCoroutine3() {
        coroutineDemo.cancelCoroutine3()
    }

    @Test
    fun testFinallyCoroutine4() {
        coroutineDemo.finallyCoroutine4()
    }

    @Test
    fun testFinallyCoroutine5() {
        coroutineDemo.finallyCoroutine5()
    }

    @Test
    fun testTimeouts() {
        coroutineDemo.timeouts()
    }

    @Test
    fun testSuspendMethod1() {
        coroutineDemo.suspendMethod1()
    }

    @Test
    fun testSuspendAsync() {
        coroutineDemo.suspendAsync()
    }

    @Test
    fun testDispatchersAndThreads() {
        coroutineDemo.dispatchersAndThreads()
    }

    @Test
    fun testChildrenCoroutine() {
        coroutineDemo.childrenCoroutine()
    }

    @Test
    fun testChildrenCoroutine2() {
        coroutineDemo.childrenCoroutine2()
    }
}