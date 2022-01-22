package com.easykotlin.learn.study8

import kotlinx.coroutines.*

/**
 * 创建协程
 */
class CoroutineBuilders {

    /**
     * 使用launch函数创建协程,没有返回值
     */
    fun launchCreateCoroutine() {
        val job: Job = GlobalScope.launch {
            //挂起当前上下文，而不是阻塞
            println("[launchCreateCoroutine],Before Thread:${Thread.currentThread().name}")
            delay(1000)
            println("[launchCreateCoroutine],After Thread:${Thread.currentThread().name}")
        }
        //Main线程阻塞2秒
        println("[launchCreateCoroutine],Main Thread:${Thread.currentThread().name}")
        Thread.sleep(2000)
        println("Now,T Can Quit ...")
    }

    /**
     * 使用async函数创建xiec,有返回值
     */
    fun asyncCreateCoroutine() = runBlocking {
        val job: Job = GlobalScope.launch {
            //使用async函数创建xiec,有返回值
            val heroDeffer: Deferred<MutableMap<String, Any?>> = async(Dispatchers.Default) {
                println("[asyncCreateCoroutine],Thread:${Thread.currentThread().name}")
                delay(1000)
                //返回的对象
                mutableMapOf<String, Any?>(Pair("name", "杨过"), "age" to 18, Pair("wife", "小龙女"))
            }

            //获取协程的执行结果
            val hero: MutableMap<String, Any?> = heroDeffer.await()
            val iterator: MutableIterator<MutableMap.MutableEntry<String, Any?>> = hero.iterator()
            while (iterator.hasNext()) {
                val enty: MutableMap.MutableEntry<String, Any?> = iterator.next()
                val key: String = enty.key
                val value: Any? = enty.value
                println("${key}:${value}")
            }
        }
        job.join()
        delay(3000)
        println("Now,I Can Quit ...")
    }

    /**
     *  使用async函数创建xiec,有返回值
     */
    fun asyncCreateCoroutine2() = runBlocking {
        val job: Job = GlobalScope.launch {
            // 使用async函数创建xiec,有返回值
            val piDeffer: Deferred<Double> = async {
                println("Running in Job1 ...")
                delay(1000)
                //返回值
                3.1415926
            }

            val desDefferred: Deferred<String> = async {
                println("Running In job2 ...")
                delay(3000)
                //返回值
                "小明很聪明"
            }

            //获取协程异步执行的结果
            val pi: Double = piDeffer.await()
            val des: String = desDefferred.await()
            println("${des},他能记住: ${pi}")
        }

        job.join()
        delay(3000)
        println("Now,I Can Quit ...")
    }

    /**
     * 启动协程的start参数
     */
    fun asyncCreateCoroutine3() = runBlocking {
        val job: Job = GlobalScope.launch {
            //使用默认 start: CoroutineStart = CoroutineStart.DEFAULT启动协程
            val cityDefer: Deferred<String> = async {
                println("[Deferred 1],Start Thread:${Thread.currentThread().name}")
                delay(1000)
                "深圳市南山区"
            }
            // start: CoroutineStart = CoroutineStart.LAZY启动协程
            //类似懒加载,只有在返回的JOB或Deferred对象显示的调用start(),join()或者await时才启动协程
            val companyDeffer: Deferred<List<String>> = async(start = CoroutineStart.LAZY) {
                println("[Deferred 2],Start Thread:${Thread.currentThread().name}")
                delay(3000)
                mutableListOf<String>("华为", "小米", "腾讯", "百度")
            }

            /**
             * 获取协程返回结果
             */
            val city: String = cityDefer.await()
            val companys: List<String> = companyDeffer.await()
            println("city:${city}")
            companys.forEach {
                println(it)
            }
        }

        //等待协程job执行完成
        job.join()
        println("Now,I Can Quit ...")
    }

    /**
     * 对协程执行结果进行回调
     */
    fun coroutineCallback() = runBlocking {
        //创建一个协程
        val job: Job = GlobalScope.launch {
            //获取协程返回值
            val deferred: Deferred<List<String>> = async {
                println("[Job] Thread:${Thread.currentThread().name}")
                delay(3000)
                mutableListOf<String>("苹果", "香蕉", "荔枝")
            }

            //对协程的执行结果进行回调
            deferred.invokeOnCompletion {
                if (it != null) {
                    //未获取到协程执行结果,异常了
                    println("Exception: ${it.message}")
                } else {
                    //正常获取到协程执行结果
                    println("Result is complete ...")
                }
            }

            //取消协程,获取不到协程的执行结果
            //deferred.cancelAndJoin()
            val fruits: List<String> = deferred.await()
            println("fruits:${fruits}")
        }
        //等待协程执行完毕
        job.join()
        delay(5000)
        println("Now,I Can Quit ...")
    }

    /**
     * runBlocking创建的协程直接运行在当前线程上,同事阻塞当前线程直到结束
     */
    fun runBlockingCreateCoroutine(): MutableList<String> = runBlocking(Dispatchers.Default) {
        println("[runBlockingCreateCoroutine],Thread:${Thread.currentThread().name}")
        //创建一个协程，在指定的协程调度器中运行,同时挂起改协程,阻塞当前线程
        //val job1: Job = launch(Dispatchers.IO) {
        //val job1: Job = launch(Dispatchers.Unconfined) {//无限制,暂停之后不一定在当前线程
        //val job1: Job = launch(Dispatchers.Default) {//默认,暂定后还是在当前线程
        //val job1: Job = launch(coroutineContext) {//使用父级的上下文,也就是runBlocking的上下文
        val job1: Job = launch(newSingleThreadContext("My_Thread")) {//创建自己的新线程上下文
            println("[Job1],doing,Thread:${Thread.currentThread().name}")
            delay(1000)
            println("[Job1],done,Thread:${Thread.currentThread().name}")
        }
        println("[runBlockingCreateCoroutine],XXX,Thread:${Thread.currentThread().name}")
        delay(3000)
        println("Now,I Can Quit ...")

        //runBlocking最后一行是协程的返回值
        mutableListOf<String>("华山", "衡山", "庐山", "黄山", "泰山", "终南山")
    }

}