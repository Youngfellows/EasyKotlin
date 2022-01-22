package com.easykotlin.learn.study8

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SuspendFunctionTest {

    /**
     * 创建对象
     */
    val suspendFunction: SuspendFunction = SuspendFunction()

    @Test
    fun testDelaySuspend() {
        suspendFunction.delaySuspend()
    }

    @Test
    fun testYieldSuspend() {
        suspendFunction.yieldSuspend()
    }

    @Test
    fun testWithContextSuspend() {
        suspendFunction.withContextSuspend()
    }

    @Test
    fun testWithContext2NonCancellable() {
        suspendFunction.withContext2NonCancellable()
    }

    @Test
    fun testCoroutineScopeSuspend() {
        suspendFunction.coroutineScopeSuspend()
    }
}