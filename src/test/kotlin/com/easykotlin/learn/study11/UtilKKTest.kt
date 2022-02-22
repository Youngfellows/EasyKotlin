package com.easykotlin.learn.study11

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Test

class UtilKKTest {

    /**
     * 测试静态方法
     */
    @Test
    fun testStatic() {
        //创建对象
        val utilKK = UtilKK()

        //mock静态类
        mockkStatic(UtilKotlin::class)

        //更新静态类的返回值
        every { UtilKotlin.ok() } returns "this value is kotlin method for ok ..."

        //方法调用
        utilKK.ok()

        //验证方法是否被调用了
        verify { UtilKotlin.ok() }

        //获取调用结果
        println(UtilKotlin.ok())
    }

    @Test
    fun testObject() {
        //创建对象
        val utilKK = UtilKKObject()

        //mock静态类
        //mockkObject(UtilObjectKotlin)
        //或者
        mockkObject(UtilObjectKotlin.Companion)

        //设置mock对象的返回值
        every { UtilObjectKotlin.ok() } returns "this value is objec kotlin for ok() ..."

        //调用方法
        utilKK.ok()

        //验证方法是否被调用了
        verify { UtilObjectKotlin.ok() }

        //验证调用结果
        println(UtilObjectKotlin.ok())
    }

    @Test
    fun testSingleton() {
        //创建对象
        val utilKK = SingletomUtil()

        //mock静态类
        mockkObject(SingletonObject)

        //设置mock对象的返回值
        every { SingletonObject.ok() } returns "this value is singleton kotlin for ok() ..."

        //调用方法
        utilKK.ok()

        //验证方法是否被调用了
        verify { SingletonObject.ok() }

        //验证调用结果
        println(SingletonObject.ok())
    }
}