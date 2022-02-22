package com.easykotlin.learn.study11

import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class KidTest {

    @Test
    fun testWantMoney() {
        //创建模拟对象
        val mother: Mother = mockk<Mother>()
        val kid: Kid = Kid(mother)

        //模拟对象调用返回值
        every { mother.giveMoney() } returns 666.88

        //调用
        kid.wantMoney()

        //断言结果是否正确
        //assertEquals();
        println(kid.money)
    }
}