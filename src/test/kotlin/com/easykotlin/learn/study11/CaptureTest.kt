package com.easykotlin.learn.study11

import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

/**
 * Capture
 * 用途：要抓取方法的參數值時
 * 種類：slot 用來抓取一個值，mutableListOf 用來抓取一段連續資料(List)
 */
class CaptureTest {

    @RelaxedMockK
    lateinit var mother: Mother

    lateinit var kid: Kid

    @Before
    fun setUp() {
        //初始化设置
        MockKAnnotations.init(this)
        kid = Kid(mother)
    }

    @Test
    fun testCapture() {
        //设置模拟返回值
        every { mother.giveMoney() } returns 777.888
        //抓取 inform() 這個方法傳入的 money 參數
        val slot = slot<Double>()
        every { mother.inform(capture(slot)) } just Runs


        //真实调用
        kid.wantMoney()

        //验证方法是否被调用
        verify { mother.inform(any()) }
        verify { mother.giveMoney() }

        //抓取 inform() 這個方法傳入的 money 參數
        println(slot.captured)

        //调用结果
        println(kid.money)
        //验证结果
        MatcherAssert.assertThat("1",CoreMatchers.`is`("1"))
    }
}