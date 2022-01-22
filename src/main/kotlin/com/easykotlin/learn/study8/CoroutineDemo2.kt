package com.easykotlin.learn.study8

import kotlinx.coroutines.*
import kotlin.concurrent.thread

/**
 * 协程及其使用
 */
class CoroutineDemo2 : IEbusiness {

    /**
     * 电子商务,使用协程获取异步执行的结果
     */
    fun ebusiness() = runBlocking {
        val detailDifferd: Deferred<String> = GlobalScope.async {
            getDetail()
        }
        val commentsDiffer: Deferred<String> = GlobalScope.async {
            getComments()
        }
        val recommentDiffer: Deferred<String> = GlobalScope.async {
            getRecommend()
        }

        //获取协程的执行结果
        val detail: String = detailDifferd.await()
        val comments: String = commentsDiffer.await()
        val recomment: String = recommentDiffer.await()
        println(detail)
        println(comments)
        println(recomment)
    }

    /**
     *商品详情
     */
    override fun getDetail(): String {
        println("[getDetail],Thread:${Thread.currentThread().name}")
        return "商品详情"
    }

    /**
     * 获取商品评价
     */
    override fun getComments(): String {
        println("[getComments],Thread:${Thread.currentThread().name}")
        return "商品评价"
    }

    /**
     * 获取商品推荐
     */
    override fun getRecommend(): String {
        println("[getRecommend],Thread:${Thread.currentThread().name}")
        return "商品推荐"
    }

    /**
     * 线程占用更多的内存
     */
    fun createThread() {
        val start: Long = System.currentTimeMillis()

        val threads: List<Thread> = List(100000) {
            //创建线程
            thread {
                Thread.sleep(1000)//阻塞1秒
                println("Thread:${Thread.currentThread().name}")
            }
        }
        threads.forEach {
            it.join()
        }
        val speed: Long = (System.currentTimeMillis() - start) / 1000
        println("Threads: speed=${speed} s")
    }

    /**
     * 协程占用更小的内存
     */
    fun createCoroutine() = runBlocking {
        val start: Long = System.currentTimeMillis()
        val jobs: List<Job> = List(100000) {
            //创建协程
            launch(Dispatchers.Default) {
                //挂起当前上下文,而不是阻塞1秒
                delay(1000)
                println("Thread:${Thread.currentThread().name}")
            }
        }

        //等待协程执行完成
        jobs.forEach {
            it.join()
        }
        val speed: Long = (System.currentTimeMillis() - start) / 1000
        println("Coroutines: speed=${speed} s")
    }
}