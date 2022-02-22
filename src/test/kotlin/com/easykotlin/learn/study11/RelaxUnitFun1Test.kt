package com.easykotlin.learn.study11

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

/**
 * RelaxUnitFun
 * 用途：不需指定無回傳值的方法，有回傳值的方法仍須指定
 *
 * 第一种是在 Annotation 後面加上 relaxUnitFun = true
 */
class RelaxUnitFun1Test {

    @MockK(relaxUnitFun = true)
    lateinit var mother: Mother

    lateinit var kid: Kid

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        kid = Kid(mother)
    }

    /**
     * 有回传值的方法仍須指定
     */
    @Test
    fun testWantMoney() {
        //设置模拟调用返回值
        every { mother.giveMoney() } returns 999.888

        //真实调用
        kid.wantMoney()

        //验证方法是否被调用了
        verify { mother.inform(any()) }

        //验证调用结果
        println(kid.money)
    }

    /**
     * 不需指定无回传值的方法
     */
    @Test
    fun testNoReturn() {
        mother.inform(222.333)
        verify { mother.inform(any()) }
    }
}