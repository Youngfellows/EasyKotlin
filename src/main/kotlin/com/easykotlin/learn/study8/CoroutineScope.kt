package com.easykotlin.learn.study8

import kotlinx.coroutines.*
import java.lang.RuntimeException


/**
 * CoroutineScope可以创建协程
 */
class CoroutineScope {

    /**
     * 创建协程
     */
    fun createCoroutine() {
        GlobalScope.launch {
            delay(1000)
            throw RuntimeException("This is an exception")
            val result: String = doSomething()
            println(result)
        }
        println("createCoroutine")
        Thread.sleep(2000)
        println("Now,I Can Quit")
    }

    /**
     * 挂起函数
     */
    suspend fun doSomething(): String = withContext(Dispatchers.Default) {
        "深圳市南山区科技园"
    }

}