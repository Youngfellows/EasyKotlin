package com.easykotlin.learn.study9

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class OkhttpUtilsTest {

    @Test
    fun testGet() {
        //单例调用网络请求
        val url: String = "https://www.baidu.com/"
        val result: String? = OkhttpUtils.get(url)
        println(result)
    }

    @Test
    fun testAsyncGet() {
        //单例调用网络请求
        val url: String = "https://www.baidu.com/"
        val result: String? = OkhttpUtils.asyncGet(url)
        println(result)
    }

    @Test
    fun testAsyncGet2() {
        //单例调用网络请求
        val url: String = "https://www.baidu.com/"
        OkhttpUtils.asyncGet2(url) {
            println(it)
        }
    }

}