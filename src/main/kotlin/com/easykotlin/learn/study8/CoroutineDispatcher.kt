package com.easykotlin.learn.study8

import kotlinx.coroutines.*

/**
 * 协程的上下文和调度
 */
class CoroutineDispatcher {

    /**
     * 协程的调度
     * 使用runBlocking创建一个协程
     */
    fun coroutineDispatcher() = runBlocking {
        println("[coroutineDispatcher],Thread:${Thread.currentThread().name}")
        val jobs: ArrayList<Job> = arrayListOf<Job>()
        //Unconfined: 无限制,默认的协程中运行
        jobs += launch(Dispatchers.Unconfined) {
            println("[Unconfined],Start Thread:${Thread.currentThread().name}")
            delay(1000)
            println("[Unconfined],Done Thread:${Thread.currentThread().name}")
        }

        //coroutineContext: 使用父级上下文,也就是runBlocking的上下文
        jobs += launch(coroutineContext) {
            println("[coroutineContext],Start Thread:${Thread.currentThread().name}")
            delay(1000)
            println("[coroutineContext],Done Thread:${Thread.currentThread().name}")
        }

        //Default: 默认,暂停后还是在当前线程
        jobs += launch(Dispatchers.Default) {
            println("[Default],Start Thread:${Thread.currentThread().name}")
            delay(1000)
            println("[Default],Done Thread:${Thread.currentThread().name}")
        }

        //Default: 默认,暂停后还是在当前线程
        jobs += launch {
            println("[Default],x Start Thread:${Thread.currentThread().name}")
            delay(1000)
            println("[Default],x Done Thread:${Thread.currentThread().name}")
        }

        //newSingleThreadContext: 创建自己的线程
        jobs += launch(newSingleThreadContext("My_Thread")) {
            println("[MyThread],Start Thread:${Thread.currentThread().name}")
            delay(1000)
            println("[MyThread],Done Thread:${Thread.currentThread().name}")
        }

        //等待协程执行完成
        jobs.forEach() {
            it.join()
        }
    }

    /**
     * 不是父子协程
     */
    fun notFather2child() {
        //创建一个job协程,并在内部再创建2个协程
        val job: Job = GlobalScope.launch {
            //使用不同的上下文,也是一个全局作用域的协程,不是job的子协程
            val job1: Job = GlobalScope.launch {
                println("[Job1]: 我有自己的上下文")
                delay(1000)
                println("[Job1]: 在job取消后,我还能继续执行...")
            }

            //继承父级上下文,是job协程一个子协程
            val job2: Job = launch(coroutineContext) {
                println("[Job2]: 继承父级上下文")
                delay(1000)
                //父协程取消,导致子协程也会被取消
                println("[Job2]: 在job取消后,我不能继续执行...")
            }
        }
        println("[notFather2child]")
        //阻塞500毫秒
        Thread.sleep(500)

        //取消job
        job.cancel()

        //阻塞2000毫秒
        Thread.sleep(2000)
        println("Now,I Can Quit")
    }

    /**
     * 不是父子协程
     */
    fun father2child() = runBlocking {
        //创建一个job协程,并在内部再创建2个协程
        val job: Job = GlobalScope.launch {
            //继承父级上下文,是job协程一个子协程
            val job1: Job = launch(coroutineContext) {
                delay(1000)
                println("[Job1]: Done ...")
            }

            //继承父级上下文,是job协程一个子协程
            val job2: Job = launch(coroutineContext) {
                delay(1500)
                println("[Job2]: Done ...")
            }

            //继承父级上下文,是job协程一个子协程
            val job3: Job = launch(coroutineContext) {
                delay(2000)
                println("[Job3]: Done ...")
            }

            //继承父级上下文,是job协程一个子协程
            val job4: Job = launch(coroutineContext) {
                delay(2500)
                println("[Job4]: Done ...")
            }

            //等待协程执行
            job1.join()
            job2.join()
            job3.join()
            job4.join()
        }
        println("[notFather2child]")
        job.join()
        println("Now,I Can Quit")
    }

    /**
     * 多个coroutineContext + 操作
     */
    fun coroutineContextPlus() {
        //创建一个job协程
        val job: Job = GlobalScope.launch {
            //创建一个job协程，不是job的子协程,因此job取消了,job1还能继续执行
            val job1: Job = GlobalScope.launch(Dispatchers.Default) {
                println("[Job1],不是job的子协程,有自己的协程上下文")
                delay(1000)
                println("[Job1],不是job的子协程,有自己的协程上下文,不受job取消影响,还能继续执行...")
            }
            //等待协程执行
            job1.join()
        }

        println("[coroutineContextPlus]")
        //阻塞
        Thread.sleep(500)
        //取消协程
        job.cancel()
        Thread.sleep(2000)
        println("Now,I Can Quit")
    }

    /**
     * 多个coroutineContext + 操作
     */
    fun coroutineContextPlus2() {
        //创建一个job协程
        val job: Job = GlobalScope.launch {
            //创建一个job协程，使用Dispatchers.Default + coroutineContext
            //使得是job的子协程,因此job取消了,job1不能继续执行
            val job1: Job = GlobalScope.launch(Dispatchers.Default + coroutineContext) {
                println("[Job1],是job的子协程,使用job的协程上下文")
                delay(1000)
                println("[Job1],是job的子协程,使用job的协程上下文,受job取消影响,不能继续执行...")
            }
            //等待协程执行
            job1.join()
        }

        println("[coroutineContextPlus]")
        //阻塞
        Thread.sleep(500)
        //取消协程
        job.cancel()
        Thread.sleep(2000)
        println("Now,I Can Quit")
    }

    /**
     * coroutineContext与job对象相加,job对象可以管理改协程
     */
    fun coroutineContextPlusJob() = runBlocking {
        //创建一个job来管理生命周期
        val job: Job = Job()
        launch(coroutineContext + job) {
            delay(500)
            println("job1 is done")
        }

        launch(coroutineContext + job) {
            delay(1000)
            println("job2 is done")
        }

        launch(Dispatchers.Default + job) {
            delay(1500)
            println("job3 is done")
        }

        launch(Dispatchers.Unconfined + job) {
            delay(20000)
            println("job4 is done")
        }

        launch(Dispatchers.Unconfined + job) {
            delay(2500)
            println("job5 is done")
        }

        println("coroutineContextPlusJob")
        delay(1800)
        println("取消协程job")
        println("Now,I Can Quit")
    }
}