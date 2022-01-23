package com.easykotlin.learn.study8

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.selects.select
import kotlin.coroutines.CoroutineContext

/**
 * Channel机制
 */
class CoroutineChannel {

    /**
     * 生产者消费者
     */
    fun producer2consumer() = runBlocking {
        //定义通道
        val channel: Channel<Int> = Channel<Int>()

        //生产者协程
        val job1: Job = launch(Dispatchers.Default) {
            //发送消息
            repeat(5) {
                println("[job1] send ${it}")
                delay(200)
                channel.send((it + 1) * (it + 1))
            }
        }

        //消费者协程
        val job2: Job = launch(Dispatchers.Unconfined) {
            //接收消息
            repeat(5) {
                val receive: Int = channel.receive()
                println("[job2], receive:${receive}")
            }
        }

        //等待协程执行完毕
        delay(2000)
        println("Now,Receive Done!")
    }

    /**
     * 关闭channel
     */
    fun closeChannel() = runBlocking {
        //定义通道
        val channel: Channel<Int> = Channel<Int>()

        //生产者协程
        val job1: Job = launch(Dispatchers.Default) {
            //发送消息
            repeat(5) {
                println("[job1] send ${it}")
                delay(200)
                channel.send((it + 1) * (it + 1))
                if (it == 2) {
                    channel.close()
                }
            }
        }

        //消费者协程
        val job2: Job = launch(Dispatchers.Unconfined) {
            //接收消息
            repeat(5) {
                try {
                    val receive: Int = channel.receive()
                    println("[job2], receive:${receive}")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        //等待协程执行完毕
        delay(2000)
        println("Now,Receive Done!")
    }

    /**
     * 管道1
     */
    fun produce1(): ReceiveChannel<Int> = GlobalScope.produce<Int>(Dispatchers.Default) {
        //发送0~4
        repeat(5) {
            send(it)
        }
    }

    /**
     * 管道2接收管道1的数据
     */
    fun produce2(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> {
        return GlobalScope.produce<Int>(Dispatchers.Unconfined) {
            for (x in numbers) {
                send(x * x)
            }
        }
    }

    /**
     * 管道3接收管道2的数据
     */
    fun produce3(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> {
        return GlobalScope.produce<Int>(Dispatchers.IO) {
            for (x in numbers) {
                send(x + 1)
            }
        }
    }

    /**
     * Channel缓冲区
     */
    fun channelCache() = runBlocking {
        //创建带2个缓冲区的channel
        val channel: Channel<Int> = Channel<Int>(2)

        //发送协程1
        val job1: Job = launch(Dispatchers.Default) {
            //循环发送数据
            repeat(6) {
                println("Sending ${it}")
                channel.send(it)
            }
        }

        //接收数据协程
        val job2: Job = launch(Dispatchers.Unconfined) {
            repeat(6) {
                val receive: Int = channel.receive()
                println("Receive ${receive}")
            }
        }
        delay(2000)
        println("Receive Done!")
    }

    /**
     * Channel缓冲区
     */
    fun channelCache2() = runBlocking {
        //创建带2个缓冲区的channel
        val channel: Channel<Int> = Channel<Int>(2)

        //发送协程1
        val job1: Job = launch(Dispatchers.Default) {
            //循环发送数据
            repeat(6) {
                delay(50)
                println("Sending ${it}")
                channel.send(it)
            }
        }

        //接收数据协程
        val job2: Job = launch(Dispatchers.Unconfined) {
            repeat(6) {
                delay(1000)
                val receive: Int = channel.receive()
                println("Receive ${receive}")
            }
        }
        //delay(5000)
        //println("Receive Done!")
    }

    /**
     * 使用actor创建协程
     */
    fun actorCreateCoroutine() = runBlocking {
        //创建协程,内部包含channel
        val actor: SendChannel<Int> = actor<Int>(coroutineContext) {
            //接收数据
            var sum: Int = 0
            for (i in channel) {
                sum += i
            }
            println("sum=${sum}")
        }

        //发送数据1~10
        repeat(10) {
            actor.send(it + 1)
        }

        //关闭channel
        actor.close()
    }

    /**
     * 管道produceX
     */
    fun produceX(context: CoroutineContext): ReceiveChannel<String> = GlobalScope.produce<String>(context) {
        while (true) {
            delay(400)
            send("杨过")
        }
    }

    /**
     * 管道produceY
     */
    fun produceY(context: CoroutineContext): ReceiveChannel<String> = GlobalScope.produce<String>(context) {
        while (true) {
            delay(600)
            send("小龙女")
        }
    }

    /**
     * select表达式能够同时等待多个挂起函数,然后选择第一个可用的结果
     */
    suspend fun selectProduces(channel1: ReceiveChannel<String>, channel2: ReceiveChannel<String>): Map<String, Any?> {
        return select<Map<String, Any?>> {
            val onReceive = channel1.onReceive
            println(onReceive)
            val onReceive2 = channel1.onReceive
            println(onReceive2)
        }
    }

    fun select() = runBlocking {
        val produceX = produceX(coroutineContext)
        val produceY = produceY(coroutineContext)
        repeat(10) {
            selectProduces(produceX, produceY)
        }
        //关闭子协程
        coroutineContext.cancelChildren()
    }
}