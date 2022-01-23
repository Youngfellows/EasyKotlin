package com.easykotlin.learn.study8

import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CoroutineChannelTest {

    /**
     * 创建对象
     */
    val coroutineChannel: CoroutineChannel = CoroutineChannel()

    @Test
    fun testProducer2consumer() {
        coroutineChannel.producer2consumer()
    }

    @Test
    fun testCloseChannel() {
        coroutineChannel.closeChannel()
    }

    @Test
    fun testPipeline() = runBlocking {
        //使用管道传输数据
        val numbers: ReceiveChannel<Int> = coroutineChannel.produce1()
        val squares: ReceiveChannel<Int> = coroutineChannel.produce2(numbers)
        val adds: ReceiveChannel<Int> = coroutineChannel.produce3(squares)
        adds.consumeEach {
            println(it)
        }

        println("Receive Done!")
        //关闭prodece
        adds.cancel()
        squares.cancel()
        numbers.cancel()
    }

    @Test
    fun testChannelCache() {
        coroutineChannel.channelCache()
    }

    @Test
    fun testChannelCache2() {
        coroutineChannel.channelCache2()
    }

    @Test
    fun testActorCreateCoroutine() {
        coroutineChannel.actorCreateCoroutine()
    }

    @Test
    fun testSelectCoroutine() {
        coroutineChannel.select()
    }
}