package com.easykotlin.learn.study7

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SingleInstanceDemoTest {

    @Test
    fun testObject1() {
        //引用object常量,object对象只能通过对象名字来访问
        val username: String = AdminUser.username
        val password: String = AdminUser.password
        val timestamp: String? = AdminUser.getTimestamp()
        println("username=${username}")
        println("password=${password}")
        println("timestamp=${timestamp}")
    }

    @Test
    fun testObject2() {
        //只能通过类的名称来直接访问object，不能使用对象实例引用
        DataProcessor.process()
        val userHome: String = DataProcessor.FileUtils.userHome
        val fileName: String = "xxx.txt"
        val content: String? = DataProcessor.FileUtils.getFileContent(fileName)
        println("userHome:${userHome}")
        println("content:${content}")
    }

    @Test
    fun testOkHttp() {
        val url: String = "https://www.baidu.com/"
        //同步请求
        val result: String? = HttpUtils.getSync(url)
        println("result=$result")

        println("================================================================")

        //异步请求
        HttpUtils.getAsync(url, onSucess = {
            println("on sucess ...")
            println(it)
        }, onFailure = {
            println("on failure ...")
            println(it)
        })
    }

    @Test
    fun testRectangle() {
        val topleft: Point = Point(0.0, 0.0)
        val topright: Point = Point(2.0, 0.0)
        val bottomleft: Point = Point(0.0, 2.0)
        val bottomright: Point = Point(2.0, 2.0)
        val rectangle = Rectangle("矩形", topleft, topright, bottomleft, bottomright)

        val distance: Double = rectangle.distance(topright)
        println("distance:${distance}")

        rectangle.getFeatures()
        //rectangle.getBorder().size//无法访问到
        rectangle.compare()

    }
}