package com.easykotlin.learn.study8

import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Android使用suspendCancellableCoroutine将回调转换为协程
 */
class SuspendCoroutineDemo {

    /**
     * 普通回调
     * @param result 回调
     */
    fun longTimeMethod(result: Result<String>) {
        println("normalCallback ...")
        val thread: Thread = Thread {
            Thread.sleep(5000)
            if (System.currentTimeMillis() % 10 > 6) {
                result.onSucess("${System.currentTimeMillis()}")
            } else {
                result.onFailed(Exception("Failed xxxx"))
            }
        }
        thread.start()
        thread.join()
    }

    /**
     * Android使用suspendCancellableCoroutine将回调转换为协程
     */
    fun request() = runBlocking {
        val job: Job = GlobalScope.launch {
            try {
                val result: String = getResult()
                println("result: $result")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        job.join()
        delay(10 * 1000)
        println("Now,I Can Quit ...")
    }

    /**
     * Android使用suspendCancellableCoroutine将回调转换为协程
     * @return 字符串类型
     */
    private suspend fun getResult(): String = suspendCancellableCoroutine<String> {
        longTimeMethod(object : Result<String> {
            override fun onSucess(t: String) {
                if (it.isCancelled) {
                    return
                }
                //发送结果
                it.resume(t)
            }

            override fun onFailed(e: Exception) {
                //发送结果
                it.resumeWithException(e)
            }

        })
    }
}