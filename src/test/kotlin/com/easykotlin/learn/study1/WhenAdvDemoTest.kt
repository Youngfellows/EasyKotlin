package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WhenAdvDemoTest {

    /**
     * 创建对象
     */
    val whenAdvDemo: WhenAdvDemo = WhenAdvDemo()

    @Test
    fun testWhen() {
        var error: Error? = Error(SdkConst.ERROR_CODE_1, "错误码1")
        var destination: LoginDestination = LoginDestination.BrandDestination("奔驰", error)
        whenAdvDemo.testLogin(destination)

        error = Error(SdkConst.ERROR_CODE_2, "错误码2")
        destination = LoginDestination.BrandDestination("宝马", error)
        whenAdvDemo.testLogin(destination)

        error = Error(SdkConst.ERROR_CODE_3, "错误码3")
        destination = LoginDestination.BrandDestination("吉利", error)
        whenAdvDemo.testLogin(destination)

        error = null
        destination = LoginDestination.BrandDestination("小鹏", error)
        whenAdvDemo.testLogin(destination)

        destination = LoginDestination.HomeDestination("长安")
        whenAdvDemo.testLogin(destination)
    }

    @Test
    fun testNull() {
        var animal: Animal? = Animal()
        var name: String? = null
        name = animal?.name
        println("name=$name")
        when (animal?.name) {
            "小狗狗" -> {
                println("小狗狗")
            }
            else -> {
                println("其他狗")
            }
        }

        animal = null
        name = animal?.name
        println("name=$name")
        when (animal?.name) {
            "小狗狗" -> {
                println("小狗狗")
            }
            else -> {
                println("其他狗")
            }
        }
    }
}