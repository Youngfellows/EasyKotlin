package com.easykotlin.learn.study11

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

/**
 * 用 Annotation 的方式宣告，要改用 @RelaxedMockK
 * 用途：该类所有的方法都不需要指定
 */
class Relaxed2Test {

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
        //设置模拟返回值
        every { mother.giveMoney() } returns 456.798

        //真实调用
        kid.wantMoney()

        //验证方法是否被调用了
        verify { mother.inform(any()) }

        //验证结果
        println(kid.money)
    }
}