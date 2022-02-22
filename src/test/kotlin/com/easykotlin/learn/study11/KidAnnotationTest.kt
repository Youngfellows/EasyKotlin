package com.easykotlin.learn.study11

import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class KidAnnotationTest {

    /**
     * 初始化mock模拟对象
     */
    @MockK
    lateinit var mother: Mother

    /**
     * 延迟初始化
     */
    lateinit var kid: Kid

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        kid = Kid(mother) //注入创建的模拟对象
    }


    @Test
    fun testWantMoney() {
        //调用模拟对象的返回值
        every { mother.giveMoney() } returns 999.888
        every { mother.inform(any()) } just Runs //指定方法运行

        //真实调用
        kid.wantMoney()

        //验证方便被调用

        verify { mother.inform(any()) }

        //验证结果
        println(kid.money)
    }
}