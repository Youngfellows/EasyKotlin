package com.easykotlin.learn.study8

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.lang.Exception

@RunWith(JUnit4::class)
class SuspendCoroutineDemoTest {

    /**
     * 创建对象
     */
    val suspendCoroutineDemo: SuspendCoroutineDemo = SuspendCoroutineDemo()

    @Test
    fun testNormalCallback() {
        suspendCoroutineDemo.longTimeMethod(object : Result<String> {
            override fun onSucess(t: String) {
                println("sucess: $t")
            }

            override fun onFailed(e: Exception) {
                println("failed: $e")
            }
        })
    }

    @Test
    fun testRequest() {
        suspendCoroutineDemo.request()
    }


}