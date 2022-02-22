package com.easykotlin.learn.study11

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

/**
 * Relaxed
 * 用途：该类所有的方法都不需要指定
 */
class Relaxed1Test {

    @Test
    fun testWantMoney() {
        //创建模拟对象
        val mother = mockk<Mother>(relaxed = true)
        val kid: Kid = Kid(mother)

        //调用模拟对象的返回值
        every { mother.giveMoney() } returns 123.456

        //真实调用
        kid.wantMoney()

        //验证方法是否被调用
        verify { mother.inform(any()) }

        println(kid.money)
    }
}