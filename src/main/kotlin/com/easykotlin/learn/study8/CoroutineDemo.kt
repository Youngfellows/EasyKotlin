package com.easykotlin.learn.study8

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class CoroutineDemo {

    /**
     * 使用协程,Default执行之后，线程不变
     */
    suspend fun coroutineDemo1() = coroutineScope {
        launch(Dispatchers.Default) {
            println("before: thread name=${Thread.currentThread().name}")
            delay(3000)
            println("after: thread name=${Thread.currentThread().name}")
        }
        println("hello: thread name=${Thread.currentThread().name}")
        Thread.sleep(5000)
        println("world: thread name=${Thread.currentThread().name}")
    }

    /**
     * Unconfined执行之后，线程切换了
     */
    suspend fun coroutineDemo2() = coroutineScope {
        println("coroutineDemo2: thread name=${Thread.currentThread().name}")
        launch(Dispatchers.Unconfined) {
            println("coroutineDemo2 before: thread name=${Thread.currentThread().name}")
            delay(3000)
            println("coroutineDemo2 after: thread name=${Thread.currentThread().name}")
        }
        println("coroutineDemo2 hello: thread name=${Thread.currentThread().name}")
        Thread.sleep(5000)
        println("coroutineDemo2 world: thread name=${Thread.currentThread().name}")
    }

    /**
     * Unconfined执行之后，线程切换了
     */
    suspend fun coroutineDemo3() = coroutineScope {
        println("coroutineDemo3: thread name=${Thread.currentThread().name}")
        launch(Dispatchers.Unconfined) {
            suspendMethod()
        }
        println("coroutineDemo3 hello: thread name=${Thread.currentThread().name}")
        Thread.sleep(5000)
        println("coroutineDemo3 world: thread name=${Thread.currentThread().name}")
    }

    /**
     * 挂起函数
     */
    suspend fun suspendMethod() {
        println("suspendMethod before: thread name=${Thread.currentThread().name}")
        delay(3000)
        println("suspendMethod after: thread name=${Thread.currentThread().name}")
    }

    /**
     * 桥接: runBlocking
     * 阻塞和非阻塞
     */
    fun coroutineDemo4() = runBlocking {
        println("coroutineDemo4 1: thread name=${Thread.currentThread().name}")
        launch(Dispatchers.Default) {
            println("coroutineDemo4 3: thread name=${Thread.currentThread().name}")
            delay(2000)
            println("coroutineDemo4 4: thread name=${Thread.currentThread().name}")
        }
        println("coroutineDemo4 2: thread name=${Thread.currentThread().name}")
        delay(3000)
        println("coroutineDemo4 5: thread name=${Thread.currentThread().name}")
    }

    /**
     * 等待一个任务执行完毕
     */
    fun coroutineDemo5() = runBlocking {
        val job1: Job = launch {
            println("coroutineDemo5,job1 thread:${Thread.currentThread().name}")
            println("coroutineDemo5,job start")
            delay(3000)
            println("coroutineDemo5,job1 hello,thread:${Thread.currentThread().name}")
        }

        val job2: Job = launch {
            println("coroutineDemo5,job2 thread:${Thread.currentThread().name}")
            println("coroutineDemo5,job2 start")
            delay(3000)
            println("coroutineDemo5,job2 hello,thread:${Thread.currentThread().name}")
        }
        println("coroutineDemo5,HELLO,thread:${Thread.currentThread().name}")
        println("coroutineDemo5,job1 is active: ${job1.isActive} :${job1.isCompleted}")
        println("coroutineDemo5,job2 is active: ${job2.isActive} :${job2.isCompleted}")

        job1.join()
        println("HI")
        println("coroutineDemo5,job1 is active: ${job1.isActive} :${job1.isCompleted}")
        println("coroutineDemo5,job2 is active: ${job2.isActive} :${job2.isCompleted}")

        job2.join()
        println("HEY")
        println("coroutineDemo5,job1 is active: ${job1.isActive} :${job1.isCompleted}")
        println("coroutineDemo5,job2 is active: ${job2.isActive} :${job2.isCompleted}")
    }

    /**
     * 协程是轻量级的,报错
     * java.lang.OutOfMemoryError: GC overhead limit exceeded
     */
    fun createThread() {
        val listJobs: List<Thread> = List(1000_000) {
            Thread() {
                Thread.sleep(1000)
                println(".")
            }
        }
        listJobs.forEach {
            it.start()
        }
        listJobs.forEach {
            it.join()
        }
    }

    /**
     * 协程是轻量级的
     */
    fun createCoroutine() = runBlocking {
        val listJobs: List<Job> = List(1000_000) {
            launch {
                delay(1000L)
                println("---------")
            }
        }
        listJobs.forEach {
            it.join()
        }
    }

    /**
     * 协程 vs 守护线程
     */
    fun daemonThread() {
        val thread: Thread = Thread() {
            repeat(100) {
                println("I am sleeping ${it},thread: ${Thread.currentThread().name}")
                Thread.sleep(500)
            }
        }
        println("daemonThread,thread: ${Thread.currentThread().name}")
        //必须在启动线程前调用,否则会报错：Exception in thread "main"
        thread.isDaemon = true
        thread.start()
        Thread.sleep(2000)
    }

    /**
     * 取消协程
     */
    fun daemonCoroutine() = runBlocking {
        val job: Job = launch(coroutineContext) {
            repeat(100) {
                println("I am sleeping ${it},thread: ${Thread.currentThread().name}")
                delay(500)
            }
        }
        delay(2000)
        println("CurentThread: ${Thread.currentThread().name}")
        println("Job is alive: ${job.isActive},isComplete: ${job.isCompleted}")

        job.cancel()
        println("Job is cancel: ${job.isCancelled}")
        println("Now ,I can Quit ...")
    }

    /**
     *  计算代码的协程取消失效
     */
    fun cancelCoroutine1() = runBlocking {
        val job: Job = launch(Dispatchers.Default) {
            println("Thread: ${Thread.currentThread().name}")
            var nextPrintTime: Long = 0
            var i: Int = 0
            while (i < 100) {
                val currentTimeMillis: Long = System.currentTimeMillis()
                if (currentTimeMillis > nextPrintTime) {
                    println("I am sleeping ${i++} ,Thread: ${Thread.currentThread().name}")
                    nextPrintTime += 500
                }
            }
        }
        println("Beaore CurrentThread: ${Thread.currentThread()}")
        //delay(1000L)
        println("After CurrentThread: ${Thread.currentThread()}")
        println("Before cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted},cancel: ${job.isCancelled}")

        job.cancel()
        println("Job cancel: ${job.isCancelled}")
        println("After cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted},cancel: ${job.isCancelled}")

        delay(3000L)
        println("Job x cancel: ${job.isCancelled}")

        println("Now I Can Quit ")
    }

    /**
     *  计算代码协程的有效取消: 显式检查取消状态isActive
     */
    fun cancelCoroutine2() = runBlocking {
        val job: Job = launch(Dispatchers.Default) {
            println("Thread: ${Thread.currentThread().name}")
            var nextPrintTime: Long = 0
            var i: Int = 0
            while (i < 100) {
                //取消协程
                if (!isActive) {
                    return@launch
                }
                val currentTimeMillis: Long = System.currentTimeMillis()
                if (currentTimeMillis > nextPrintTime) {
                    println("I am sleeping ${i++} ,Thread: ${Thread.currentThread().name}")
                    nextPrintTime += 500
                }
            }
        }
        println("Beaore CurrentThread: ${Thread.currentThread()}")
        //delay(1000L)
        println("After CurrentThread: ${Thread.currentThread()}")
        println("Before cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted},cancel: ${job.isCancelled}")

        job.cancel()
        println("Job cancel: ${job.isCancelled}")
        println("After cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted},cancel: ${job.isCancelled}")

        delay(3000L)
        println("Job x cancel: ${job.isCancelled}")

        println("Now I Can Quit ")
    }

    /**
     *  计算代码协程的有效取消:  循环调用一个挂起函数yield()
     */
    fun cancelCoroutine3() = runBlocking {
        val job: Job = launch(Dispatchers.Default) {
            println("Thread: ${Thread.currentThread().name}")
            var nextPrintTime: Long = 0
            var i: Int = 0
            while (i < 100) {
                //取消协程
                /* if (!isActive) {
                     return@launch
                 }*/
                yield()
                val currentTimeMillis: Long = System.currentTimeMillis()
                if (currentTimeMillis > nextPrintTime) {
                    println("I am sleeping ${i++} ,Thread: ${Thread.currentThread().name}")
                    nextPrintTime += 500
                }
            }
        }
        println("Beaore CurrentThread: ${Thread.currentThread()}")
        //delay(1000L)
        println("After CurrentThread: ${Thread.currentThread()}")
        println("Before cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted},cancel: ${job.isCancelled}")

        job.cancel()
        println("Job cancel: ${job.isCancelled}")
        println("After cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted},cancel: ${job.isCancelled}")

        delay(3000L)
        println("Job x cancel: ${job.isCancelled}")

        println("Now I Can Quit ")
    }

    /**
     *  当我们取消一个协程任务时，如果有try {...} finally {...}代码块，那么finally {...}中的代码会被正常执行完毕
     */
    fun finallyCoroutine4() = runBlocking {
        val job: Job = launch(Dispatchers.Default) {
            println("Thread: ${Thread.currentThread().name}")
            var nextPrintTime: Long = 0
            var i: Int = 0
            try {
                while (i < 100) {
                    //取消协程
                    /* if (!isActive) {
                         return@launch
                     }*/
                    yield()
                    val currentTimeMillis: Long = System.currentTimeMillis()
                    if (currentTimeMillis > nextPrintTime) {
                        println("I am sleeping ${i++} ,Thread: ${Thread.currentThread().name}")
                        nextPrintTime += 500
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                println("I am running finally")
                delay(1000L)
                //因为主线程在挂起函数delay(1000L)以及后面的打印逻辑还没执行完，就已经结束退出。
                println("And I've delayed for 1 sec ?")
            }
        }
        println("Beaore CurrentThread: ${Thread.currentThread()}")
        //delay(1000L)
        println("After CurrentThread: ${Thread.currentThread()}")
        println("Before cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted},cancel: ${job.isCancelled}")

        job.cancel()
        println("Job cancel: ${job.isCancelled}")
        println("After cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted},cancel: ${job.isCancelled}")

        delay(3000L)
        println("Job x cancel: ${job.isCancelled}")

        println("Now I Can Quit ")
    }

    /**
     * 如果我们想要上面的例子中的finally{...}完整执行，不被取消函数操作所影响，
     * 我们可以使用 run 函数和 NonCancellable 上下文将相应的代码包装在 run (NonCancellable) {...}
     */
    fun finallyCoroutine5() = runBlocking {
        val job: Job = launch(Dispatchers.Default) {
            println("Thread: ${Thread.currentThread().name}")
            var nextPrintTime: Long = 0
            var i: Int = 0
            try {
                while (i < 100) {
                    //取消协程
                    /* if (!isActive) {
                         return@launch
                     }*/
                    yield()
                    val currentTimeMillis: Long = System.currentTimeMillis()
                    if (currentTimeMillis > nextPrintTime) {
                        println("I am sleeping ${i++} ,Thread: ${Thread.currentThread().name}")
                        nextPrintTime += 500
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                /*  run(NonCancellable) {
                      println("I am running finally")
                      delay(1000L)
                      //因为主线程在挂起函数delay(1000L)以及后面的打印逻辑还没执行完，就已经结束退出。
                      println("And I've just delayed for 1 sec because I'm non-cancellable")
                  }*/
            }
        }
        println("Beaore CurrentThread: ${Thread.currentThread()}")
        //delay(1000L)
        println("After CurrentThread: ${Thread.currentThread()}")
        println("Before cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted},cancel: ${job.isCancelled}")

        job.cancel()
        println("Job cancel: ${job.isCancelled}")
        println("After cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted},cancel: ${job.isCancelled}")

        delay(3000L)
        println("Job x cancel: ${job.isCancelled}")

        println("Now I Can Quit ")
    }

    /**
     * 设置协程的超时时间
     */
    fun timeouts() = runBlocking {
        try {
            withTimeout(3000L) {
                repeat(100) {
                    println("***********I am sleeping ${it}***************")
                    delay(500L)
                }
            }
        } catch (e: Exception) {
            println("error ....")
            e.printStackTrace()
        } finally {
            println("xxxxxxxxxxx")
        }
    }

    /**
     * 挂起函数的组合执行,按默认顺序执行
     */
    fun suspendMethod1() = runBlocking {
        val time: Long = measureTimeMillis {
            val a: Int = doJob1()
            val b: Int = doJob2()
            println("[suspendMethod1] 最终结果： ${a + b}")
        }
        println("suspendMethod1 completed in ${time} ms")
    }

    /**
     * 挂起函数的执行结果1
     */
    suspend fun doJob1(): Int {
        println("doing job1 ...")
        delay(1000L)
        println("job1 done ...")
        return 10
    }

    /**
     * 挂起函数的执行结果1
     */
    suspend fun doJob2(): Int {
        println("doing job2 ...")
        delay(1000L)
        println("job2 done ...")
        return 20
    }

    /**
     * 如果在调用 doJob1 和 doJob2 之间没有时序上的依赖关系, 并且我们希望通过同时并发地执行这两个函数来更快地得到答案,
     * 那该怎么办呢？这个时候，我们就可以使用async来实现异步。
     */
    fun suspendAsync() = runBlocking {
        val time: Long = measureTimeMillis {
            val a: Deferred<Int> = async { doJob1() }
            val b: Deferred<Int> = async { doJob2() }
            println("[suspendAsync] 最终结果： ${a.await() + b.await()}")
        }
        println("suspendAsync completed in ${time} ms")
    }

    /**
     * 调度和线程
     */
    fun dispatchersAndThreads() = runBlocking {
        val jobs: ArrayList<Job> = arrayListOf<Job>()
        jobs += launch(Dispatchers.Unconfined) {
            //无限制
            println("Unconfined: Before thread ${Thread.currentThread().name}")
            delay(1000)
            println("Unconfined: After thread ${Thread.currentThread().name}")
        }
        jobs += launch(coroutineContext) {
            //使用父级的上下文,也就是runBlocking的上下文
            println("coroutineContext: thread ${Thread.currentThread().name}")
        }

        jobs += launch(Dispatchers.Default) {
            println("Default: thread ${Thread.currentThread().name}")
        }

        jobs += launch {
            println("default:: thread ${Thread.currentThread().name}")
        }

        jobs += launch(newSingleThreadContext("MyThread")) {
            //创建自己的新线程
            println("MyThread:: thread ${Thread.currentThread().name}")
        }
        jobs.forEach() {
            it.join()
        }
    }

    /**
     * 父子协程
     */
    fun childrenCoroutine() = runBlocking {
        //创建一个协程，并在内部创建2个协程
        //job2是job的子协程，job1不是job的子协程
        val job: Job = GlobalScope.launch {
            println("GlobalScoe,thread: ${Thread.currentThread().name}")
            //第一个使用不同的上下文
            val job1: Job = GlobalScope.launch {
                println("job1 start ...")
                delay(1000)
                println("jo1 end ...")
            }
            //第二个继承父级上下文
            val job2: Job = GlobalScope.launch(coroutineContext) {
                println("job2 start ...")
                delay(1000)
                //父协程被取消,会导致子协程也被取消,因此不打印
                println("jo2 end ...")
            }
            job1.join()
            job2.join()
        }
        //job.join()
        println("childrenCoroutine,thread: ${Thread.currentThread().name}")
        Thread.sleep(500L)
        job.cancel()
        Thread.sleep(5000L)
        println("Now,Quit ....")
    }


    /**
     * 父协程等等子协程执行完毕
     */
    fun childrenCoroutine2() = runBlocking {
        //创建一个协程，并在内部创建2个协程
        //job2是job的子协程，job1不是job的子协程
        val job: Job = GlobalScope.launch {
            println("GlobalScoe,thread: ${Thread.currentThread().name}")
            //第一个使用不同的上下文
            val job1: Job = GlobalScope.launch(coroutineContext) {
                println("job1 start ...")
                delay(1000)
                println("jo1 end ...")
            }
            //第二个继承父级上下文
            val job2: Job = GlobalScope.launch(coroutineContext) {
                println("job2 start ...")
                delay(1000)
                println("jo2 end ...")
            }
            //第二个继承父级上下文
            val job3: Job = GlobalScope.launch(coroutineContext) {
                println("job3 start ...")
                delay(1000)
                println("jo3 end ...")
            }
            job1.join()
            job2.join()
            job3.join()
        }
        job.join()
        println("childrenCoroutine,thread: ${Thread.currentThread().name}")
        //job.cancel()
        //Thread.sleep(5000L)
        println("Now,Quit ....")
    }

}