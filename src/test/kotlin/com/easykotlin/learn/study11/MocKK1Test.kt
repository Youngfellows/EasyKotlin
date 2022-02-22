package com.easykotlin.learn.study11

import io.mockk.*
import org.junit.Test
import java.lang.RuntimeException

class MocKK1Test {

    @Test
    fun testCreateMockk() {
        //mock类T并返回该类的mock对象
        //返回ServiceImpl一个mock对象
        val serviceImpl = mockk<ServiceImpl>()

        //mock指定方法
        every { serviceImpl.doSomething1(any()) } returns "doSomething1"
        every { serviceImpl.doSomething2(any()) } returns "shang hai"

        //调用被mock的方法
        serviceImpl.doSomething1("hello")

        //该方法未mock,会报错
        serviceImpl.doSomething2("beijing")

        //验证方法是否被调用了
        verify { serviceImpl.doSomething1(any()) }
        verify { serviceImpl.doSomething2(any()) }

        //验证调用结果
        println(serviceImpl.doSomething1("dalian"))
        println(serviceImpl.doSomething2("ni hao"))
    }

    /**
     * mockkObject()
     * 将指定对象转为可mock状态
     * 与mockk<>()的区别是返回的mock对象，允许mock行为跟真实行为并存，如果不主动mock，则执行真实行为
     */
    @Test
    fun testMockkObject() {
        val serviceImpl = ServiceImpl()
        mockkObject(serviceImpl)

        //mock指定方法
        every { serviceImpl.doSomething1(any()) } returns "mock"

        //调用被mock的方法doSomething1
        serviceImpl.doSomething1("sheng zheng")

        //调用真实方法
        serviceImpl.doSomething2("real method")

        //验证方法是否被调用
        verify { serviceImpl.doSomething1(any()) }
        verify { serviceImpl.doSomething2(any()) }

        //获取mock调用结果
        println(serviceImpl.doSomething1("sheng zheng"))

        //获取真实调用结果
        println(serviceImpl.doSomething2("real method"))
    }

    /**
     * spyk() & spyk(T obj)
     * 返回T的spyk对象或者obj的spyk对象
     * 与mockk<>()的区别是，spyk<>()返回的对象是允许真实行为跟mock行为共存的，其表现跟mockkObject()相似
     */
    @Test
    fun testSpyk1() {
        //返回ServiceImpl的一个spyk对象
        val spyK: ServiceImpl = spyk<ServiceImpl>()

        //指定mock方法
        every { spyK.doSomething1(any()) } returns "xiao jie jie"

        //调用mock方法
        spyK.doSomething1("ni hao ya")

        //调用真实方法
        spyK.doSomething2("da jia hao")

        //验证方法是否被调用
        verify { spyK.doSomething1(any()) }
        verify { spyK.doSomething2(any()) }

        //验证调用结果
        println(spyK.doSomething1("ni hao ya"))
        println(spyK.doSomething2("da jia hao"))
    }

    /**
     * every{…} …
     * 定义mock行为
     *
     * returns
     * 作用是定制mock行为的结果
     */
    @Test
    fun testSpyk2() {
        val serviceImpl = ServiceImpl()
        //返回ServiceImpl对象被spyk后的对象,原对象不会改变
        val spyk = spyk(serviceImpl)
        //serviceImpl不是可mock状态,会报错
        //every { serviceImpl.doSomething1(any()) } returns "ni mei"

        //mock方法
        every { spyk.doSomething2(any()) } returns "girl"

        //调用被mock的方法
        spyk.doSomething2("hai nan")

        //调用真实的方法
        serviceImpl.doSomething1("real method call")

        //验证方法是否被调用
        verify { spyk.doSomething2(any()) }
        //verify { serviceImpl.doSomething1(any()) }

        //获取调用结果
        println(serviceImpl.doSomething1("real method call"))
        println(spyk.doSomething2("hai nan"))
    }

    /**
     * 有时候我们可能需要在mock行为里做一些运算而不仅仅只是定制一个结果，这个时候就需要answers
     */
    @Test
    fun testAnswers1() {
        //返回ServiceImpl的一个spyk对象
        val spyk: ServiceImpl = spyk<ServiceImpl>()
        val input: String = "2222"

        //定制mock行为
        every { spyk.doSomething2(any()) } answers {
            println("定制mock行为")
            //拿到真实的函数信息
            val originalMethod = invocation.originalCall
            //调用真实行为并拿到响应结果
            val originalResult = callOriginal()
            //调用真实行为并拿到响应结果
            val originalResult1 = originalMethod.invoke()
            println(originalResult)
            println(originalResult1)
            "mock result"
        }

        //调用会执行answers里的代码
        val result = spyk.doSomething2(input)

        //验证方法是否被调用
        verify { spyk.doSomething2(any()) }

        //获取调用结果
        println(result)
    }

    @Test
    fun testAnswers2() {
        //返回ServiceImpl的一个spyk对象
        val spyk: ServiceImpl = spyk<ServiceImpl>()
        val input: String = "3333"

        //定制mock行为
        every { spyk.doSomething2(any()) } propertyType String::class answers {
            //拿到第一个输入参数
            val firstArg = firstArg<String>()
            println("输入:$firstArg")
            println("这里是mock后的行为")
            "mock响应$firstArg"
        }

        //调用会执行answers里的代码
        val result = spyk.doSomething2(input)

        //验证方法是否被调用
        verify { spyk.doSomething2(any()) }

        //获取调用结果
        println(result)
    }

    /**
     * andthen
     * 这个一般可以结合junit的@RepeatTest或者@ParameterizedTest+@ValueSource/@EnumSource一起使用
     */
    @Test
    fun testAndthen() {
        //返回ServiceImpl的一个spyk对象
        val spyk: ServiceImpl = spyk<ServiceImpl>()
        val input: String = "3333"

        //定制mock行为
        every { spyk.doSomething2(any()) } propertyType String::class answers {
            //拿到第一个输入参数
            val firstArg = firstArg<String>()
            println("第1次执行,输入:$firstArg")
            "第1次执行mock响应$firstArg"
        } andThen {
            //拿到输入参数
            val firstArg = firstArg<String>()
            println("第2次执行,输入:$firstArg")
            "第2次执行mock响应$firstArg"
        }

        //调用会执行answers里的代码
        var result = spyk.doSomething2(input)
        var result2 = spyk.doSomething2(input + input)

        //次数不会重制,会定位到最后一个mock行为
        val result3 = spyk.doSomething2(input)

        //验证方法是否被调用
        verify { spyk.doSomething2(any()) }

        //获取调用结果
        println(result)
        println(result2)
        println(result3)
    }

    @Test
    fun testAndthenThrow() {
        //返回ServiceImpl的一个spyk对象
        val spyk: ServiceImpl = spyk<ServiceImpl>()
        val input1: String = "111"
        val input2: String = "222"

        //定制mock行为
        every { spyk.doSomething2(any()) } propertyType String::class answers {
            //拿到第一个输入参数
            val firstArg = firstArg<String>()
            println("第1次执行,输入:$firstArg")
            "第1次执行mock响应$firstArg"
        } andThen {
            //拿到输入参数
            val firstArg = firstArg<String>()
            println("第2次执行,输入:$firstArg")
            "第2次执行mock响应$firstArg"
        } andThenThrows (RuntimeException())

        //调用会执行answers里的代码
        var result = spyk.doSomething2(input1)
        var result2 = spyk.doSomething2(input1 + input2)

        //验证方法是否被调用
        verify { spyk.doSomething2(any()) }
        //获取调用结果
        println(result)
        println(result2)

        //第三次调用抛出异常
        val result3 = spyk.doSomething2(input1)
        println(result3)
    }

    /**
     * AndThenAnswer
     * 可以添加Answer接口的实例
     */
    @Test
    fun testAndThenAnswer() {
        //返回ServiceImpl的一个spyk对象
        val spyk: ServiceImpl = spyk<ServiceImpl>()
        val input1: String = "111"
        val input2: String = "222"

        //定制mock行为
        every { spyk.doSomething2(any()) } propertyType String::class answers {
            //拿到第一个输入参数
            val firstArg = firstArg<String>()
            println("第1次执行,输入:$firstArg")
            "第1次执行mock响应$firstArg"
        } andThen {
            //拿到输入参数
            val firstArg = firstArg<String>()
            println("第2次执行,输入:$firstArg")
            "第2次执行mock响应$firstArg"
        } andThenThrows (RuntimeException())

        //调用会执行answers里的代码
        var result = spyk.doSomething2(input1)
        var result2 = spyk.doSomething2(input1 + input2)

        //验证方法是否被调用
        verify { spyk.doSomething2(any()) }
        //获取调用结果
        println(result)
        println(result2)

        //第三次调用抛出异常
        val result3 = spyk.doSomething2(input1)
        println(result3)
    }

}