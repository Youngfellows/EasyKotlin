package com.easykotlin.learn.study11

import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.Test

/**
 * 1. 指定方法被呼叫的次數可以在前面加上 exactly
 * 2. 想要驗證方法被呼叫的順序性可以使用 verifySequence 跟 verifyOrder
 */
class VerifyAdvTest {

    @RelaxedMockK
    lateinit var mother: Mother

    lateinit var kid: Kid

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        kid = Kid(mother)
    }

    @Test
    fun testWantMoney() {
        //设置模拟方法的返回值
        every { mother.giveMoney() } returns 456.321

        //真实调用
        kid.wantMoney()
        kid.wantMoney()

        //验证方法被调用2次
        verify(exactly = 2) { mother.inform(any()) }

        //验证方法的执行顺序

        println(kid.money)
    }


    @Test
    fun testWantMoney2() {
        //设置模拟方法的返回值
        every { mother.giveMoney() } returns 456.3333

        //真实调用
        kid.wantMoney()

        //验证方法被调用2次
        verify(exactly = 1) { mother.inform(any()) }

        //验证方法各执行了1次
        verify {
            mother.inform(any())
            mother.giveMoney()
        }

        println(kid.money)
    }


    @Test
    fun testWantMoney3() {
        //设置模拟方法的返回值
        every { mother.giveMoney() } returns 456.3333

        //真实调用
        kid.wantMoney()

        //验证方法被调用2次
        verify(exactly = 1) { mother.inform(any()) }

        //验证方法各执行顺序,verifySequence 規定 inform() 的下一個執行的方法一定要是 giveMoney()，否則測試失敗。
        verifySequence {
            mother.inform(any())
            mother.giveMoney()
        }

        println(kid.money)
    }

    @Test
    fun testWantMoney4() {
        //设置模拟方法的返回值
        every { mother.giveMoney() } returns 456.4444

        //真实调用
        kid.wantMoney()

        //验证方法被调用2次
        verify(exactly = 1) { mother.inform(any()) }

        //验证方法各执行顺序,verifyOrder 條件比較寬鬆，inform() 只要在 giveMoney() 之前執行即可
        verifyOrder {
            mother.inform(any())
            mother.giveMoney()
        }

        println(kid.money)
    }
}