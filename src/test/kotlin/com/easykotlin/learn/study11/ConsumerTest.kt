package com.easykotlin.learn.study11

import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class ConsumerTest {

    /**
     * 创建一个模拟对象
     */
    @MockK(relaxUnitFun = true)
    lateinit var task: BackgroundTask

    lateinit var consumer: Consumer

    lateinit var spyConsumer: Consumer

    /**
     * 观察回调结果
     */
    val callbackSlot = slot<ICallback>()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        consumer = Consumer(task)

        //返回Consumer的一个spyk对象
        spyConsumer = spyk(consumer, recordPrivateCalls = true)
    }

    @Test
    fun testSucess() {
        //抓取回调结果,并定制回调结果
        every { task.doBackground(capture(callbackSlot)) } answers {
            //定制回调结果
            callbackSlot.captured.onDone(true, "Sucessfull ...")
        }

        //执行调用
        spyConsumer.doBackgroundTask()

        //验证调用顺序
        verifyOrder {
            spyConsumer["printStarting"]()
            spyConsumer["printSuccess"]()
        }
    }

    @Test
    fun testFailure() {
        //抓取回调结果,并定制回调结果
        every { task.doBackground(capture(callbackSlot)) } answers {
            //定制回调结果
            callbackSlot.captured.onDone(false, "Failure ...")
        }

        //执行调用
        spyConsumer.doBackgroundTask()

        //验证调用顺序
        verifyOrder {
            spyConsumer["printStarting"]()
            spyConsumer["printFailed"]()
        }
    }
}