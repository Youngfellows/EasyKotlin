package com.easykotlin.learn.study8

import kotlinx.coroutines.*

/**
 * 挂起函数
 */
class SuspendFunction {

    /**
     * delay挂起函数,类似于Thread.sleep(),但是不会阻塞线程
     */
    fun delaySuspend() {
        println("[sleepSuspend],1,Current Thread Is ${Thread.currentThread().name}")
        //创建一个协程
        val job: Job = GlobalScope.launch {
            println("[Job],3,Current Thread Is ${Thread.currentThread().name}")
            //挂起1秒
            delay(1000)
            println("[Job],4,Current Thread Is ${Thread.currentThread().name}")
        }

        println("[sleepSuspend],2,Current Thread Is ${Thread.currentThread().name}")
        Thread.sleep(2000)//主线程阻塞2秒
        println("Now,I Can Quit ...")
    }

    /**
     * yield挂起当前的协程，将当前的协程分发到CoroutineDispatcher队列,
     * 等其他协程完成/挂起之后,再继续执行先去的协程
     */
    fun yieldSuspend() = runBlocking {
        //创建协程Job1
        val job1: Job = launch {
            println("[Job1],1,Thread:${Thread.currentThread().name}")
            yield()
            println("[Job1],3,Thread:${Thread.currentThread().name}")
            yield()
            println("[Job1],5,Thread:${Thread.currentThread().name}")
        }

        val job2: Job = launch {
            println("[Job2],2,Thread:${Thread.currentThread().name}")
            yield()
            println("[Job2],4,Thread:${Thread.currentThread().name}")
            yield()
            println("[Job2],6,Thread:${Thread.currentThread().name}")
        }

        println("[Main],0,Thread:${Thread.currentThread().name}")
        //无论是否调用下面的两句,上面的两个协程都会运行
        //job1.join()
        //job2.join()
    }

    /**
     * withCentext不会创建新的协程,类似于runBlocking,最后一行是返回值
     */
    fun withContextSuspend() {
        println("[withContextSuspend],Start,Thread:${Thread.currentThread().name}")
        /**
         * 创建一个协程
         */
        val job: Job = GlobalScope.launch {
            println("[Job] 1, Thread:${Thread.currentThread().name}")

            //Dispatchers.Default表示使用后台线程的公共线程池
            val price: Double = withContext(Dispatchers.Default) {
                println("[Job] 2,withContext Thread:${Thread.currentThread().name}")
                delay(1000)
                println("[Job] 3,withContext Thread:${Thread.currentThread().name}")
                3.1415926
            }

            //Dispatchers.IO适用于I/O密集型操作的线程池
            val hero: MutableMap<String, Any?> = withContext(Dispatchers.IO) {
                println("[Job] 4,withContext Thread:${Thread.currentThread().name}")
                delay(1000)
                println("[Job] 5,withContext Thread:${Thread.currentThread().name}")
                mutableMapOf<String, Any?>(
                    Pair("name", "杨过"),
                    Pair("age", 18),
                    "konghu" to "玄铁剑法",
                    "wife" to "小龙龙",
                    Pair("city", "黑木崖")
                )
            }

            //Dispatchers.Unconfined,表示在被调用的线程中启动协程,直到程序运行到第一个挂起点,
            //协程会在相应的挂起函数所使用的任何线程中恢复
            val phone: String = withContext(Dispatchers.Unconfined) {
                println("[Job] 6,withContext Thread:${Thread.currentThread().name}")
                delay(1000)
                println("[Job] 7,withContext Thread:${Thread.currentThread().name}")
                "华为P50 PRO"
            }

            println("phone:${phone},price:${price}")
            val iterator: MutableIterator<MutableMap.MutableEntry<String, Any?>> = hero.iterator()
            while (iterator.hasNext()) {
                val entry: MutableMap.MutableEntry<String, Any?> = iterator.next()
                val key: String = entry.key
                val value: Any? = entry.value
                println("$key : $value")
            }
        }

        println("[withContextSuspend] 0, Thread:${Thread.currentThread().name}")
        //主线程阻塞4秒
        Thread.sleep(4000)
        println("Now,I Can Quit ...")
    }

    /**
     * withContext在使用NonCancellable时,能够让协程任务执行完毕,即使会被调用者取消
     */
    fun withContext2NonCancellable() {
        //创建一个协程
        val job: Job = GlobalScope.launch {
            val hero: MutableMap<String, Any?> = withContext(NonCancellable) {
                println("[withContext job],Before Thread:${Thread.currentThread().name}")
                delay(2000)
                println("[withContext job],After Thread:${Thread.currentThread().name}")
                mutableMapOf<String, Any?>(
                    Pair("name", "杨过"),
                    Pair("age", 18),
                    "konghu" to "玄铁剑法",
                    "wife" to "小龙龙",
                    Pair("city", "黑木崖")
                )
            }

            //获取协程的执行结果
            val iterator: MutableIterator<MutableMap.MutableEntry<String, Any?>> = hero.iterator()
            while (iterator.hasNext()) {
                val entry: MutableMap.MutableEntry<String, Any?> = iterator.next()
                val key: String = entry.key
                val value: Any? = entry.value
                println("$key : $value")
            }
        }

        println("[withContext],Thread:${Thread.currentThread().name}")
        //取消协程
        job.cancel()
        //主线程休眠5秒
        Thread.sleep(5000)
        println("Now,I Can Quit")
    }

    /**
     * 跟withContext类似,coroutineScope也会有返回值,但是coroutineScope采用
     * 父协程的CoroutineContext，无法使用其他的CoroutineDispatcher
     */
    fun coroutineScopeSuspend() {
        //创建一个协程
        val job: Job = GlobalScope.launch {
            //挂起函数的返回值
            val distance: Double = withContext(Dispatchers.Default) {
                println("[withContext],Start Thread:${Thread.currentThread().name}")
                delay(1000)
                println("[withContext],Start Thread:${Thread.currentThread().name}")
                987.654321
            }

            //coroutineScope挂起函数
            val city: String = coroutineScope {
                println("[coroutineScope],Start Thread:${Thread.currentThread().name}")
                delay(1000)
                println("[coroutineScope],Start Thread:${Thread.currentThread().name}")
                "深圳&&广州"
            }

            println("${city}的距离是:${distance}千米")
        }
        println("[coroutineScopeSuspend],Thread:${Thread.currentThread().name}")
        //主线程阻塞5秒
        Thread.sleep(5000)
        println("Now,I Can Quit")
    }
}