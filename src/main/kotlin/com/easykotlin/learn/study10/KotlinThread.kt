package com.easykotlin.learn.study10

import kotlinx.coroutines.runBlocking
import java.io.File
import java.net.URL
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis
import java.lang.Thread as Thread

/**
 * 在kotlin中使用线程
 */
class KotlinThread {
    /**
     * 创建线程方式1:使用对象表达式创建
     */
    fun createThread1() {
        val thread = object : Thread() {
            override fun run() {
                println("[A]使用Thread的对象表达式:Start,Thread:${Thread.currentThread().name}")
                //模拟耗时任务,注射3秒
                val timeMillis = measureTimeMillis {
                    Thread.sleep(1000)
                }
                println("[A]使用Thread的对象表达式:Done,timeMillis=${timeMillis},Thread:${Thread.currentThread().name}")
            }
        }
        thread.start()
        //等到阻塞函数执行完成
        thread.join()
    }

    /**
     * 创建线程方式2:使用 Lambda 表达式
     */
    fun createThread2() {
        val thread: Thread = Thread({
            println("[B]使用Lambda 表达式:Start,Thread:${Thread.currentThread().name}")
            Thread.sleep(1000)
            println("[B]使用Lambda 表达式:Done,Thread:${Thread.currentThread().name}")
        })
        thread.start()
        //等到阻塞函数执行完成
        thread.join()
    }

    /**
     * 创建线程方式2:使用 Lambda 表达式
     */
    fun createThread3() {
        val thread = Thread {
            println("[C]使用Lambda 表达式:Start,Thread:${Thread.currentThread().name}")
            Thread.sleep(1000)
            println("[C]使用Lambda 表达式:Done,Thread:${Thread.currentThread().name}")
        }
        thread.start()
        //等到阻塞函数执行完成
        thread.join()
    }

    /**
     * 使用 Kotlin 封装的 thread 函数
     */
    fun createThread4() {
        val thread = Thread {
            println("D 使用 Lambda 表达式:Start,Thread:${Thread.currentThread()}")
            Thread.sleep(1000)
            println("D 使用 Lambda 表达式:Done,Thread:${Thread.currentThread()}")
        }
        thread.isDaemon = false
        thread.name = "MY_THREAD_JACK"
        thread.priority = 3
        thread.start()
        //等到阻塞函数执行完成
        thread.join()
    }

    /**
     * 使用 Kotlin 封装的 thread 函数
     */
    fun createThread5() = runBlocking {
        val thread = thread(start = true, isDaemon = false, name = "JACK_THREAD", priority = 3) {
            println("E 使用 Kotlin 封装的函数,Start, thread(): ${Thread.currentThread()}")
            Thread.sleep(1000)
            println("E 使用 Kotlin 封装的函数,Done, thread(): ${Thread.currentThread()}")
        }
        //等着阻塞函数执行完成
        thread.join()
    }

    /**
     * 同步方法
     */
    fun syncGet2SaveTo(url: String, destFileName: String, block: (text: String) -> Unit) {
        val thread = Thread() {
            println("[syncGet2SaveTo],Start, thread(): ${Thread.currentThread()}")
            val timeMillis = measureTimeMillis {
                //Thread.sleep(1000)
                val content = getRequestContent(url)
                appendFile(content, destFileName)
                val text: String = getContent(destFileName)
                //回调
                block(text)
            }
            println("[syncGet2SaveTo],Done,time:${timeMillis}, thread(): ${Thread.currentThread()}")
        }
        thread.start()
        thread.join()
    }

    /**
     * 同步代码块，写文件
     */
    //@Synchronized
    fun appendFile(text: String, destFile: String) {
        val file: File = File(destFile)
        if (!file.exists()) {
            file.createNewFile()
        }
        //file.writeText(text, Charsets.UTF_8)
        synchronized(this) {
            file.appendText(text, Charsets.UTF_8)
        }
    }

    /**
     * 同步方法，读文件
     */
    @Synchronized
    fun getContent(fileName: String): String {
        val file: File = File(fileName)
        return file.readText(Charsets.UTF_8)
    }

    /**
     * 同步方法，网络请求
     */
    @Synchronized
    fun getRequestContent(url: String): String {
        return URL(url).readText(Charsets.UTF_8)
    }

    /**
     * 可变字段
     */
    @Volatile
    private var running: Boolean = false

    /**
     * 可变字段,启动线程
     */
    fun startThread() {
        running = true
        val thread = Thread() {
            val timeMillis = measureTimeMillis {
                while (running) {
                    Thread.sleep(200)
                    println("runing,Thread:${Thread.currentThread().name}")
                }
            }
            println("Done,times:${timeMillis}")
        }
        println("Start Thread ...")
        thread.start()
        //阻塞5秒之后暂停
        Thread.sleep(3000)
        stopThread()
        thread.join()
    }

    /**
     * 停止线程
     */
    fun stopThread() {
        running = false
        println("Sopt Thread ....")
    }
}