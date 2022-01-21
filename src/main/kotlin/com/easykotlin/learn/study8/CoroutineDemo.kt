package com.easykotlin.learn.study8

import kotlinx.coroutines.*

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
}