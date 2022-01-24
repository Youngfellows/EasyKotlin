package com.easykotlin.learn.study10

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class KotlinThreadDemo {
    /**
     * 创建对象
     */
    val kotlinThread: KotlinThread = KotlinThread()

    @Test
    fun testCreateThread1() {
        kotlinThread.createThread1()
    }

    @Test
    fun testCreateThread2() {
        kotlinThread.createThread2()
    }

    @Test
    fun testCreateThread3() {
        kotlinThread.createThread3()
    }

    @Test
    fun testCreateThread4() {
        kotlinThread.createThread4()
    }

    @Test
    fun testCreateThread5() {
        kotlinThread.createThread5()
    }

    @Test
    fun testSyncGet2SaveTo() {
        val url: String = "https://www.qq.com/"
        val destFileName: String = "./file/企鹅新闻.html"
        kotlinThread.syncGet2SaveTo(url, destFileName) { content ->
            println(content)
        }
    }

    @Test
    fun testStartThread() {
        kotlinThread.startThread()
    }
}