package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class IsDemoTest {

    val isDemo: IsDemo = IsDemo()

    @Test
    fun testStrLen() {
        val web = "www.tencent.com"
        var len: Int = isDemo.strLen(web)
        println("len=${len}")

        len = isDemo.strLen(134)
        println("len=${len}")

        len = isDemo.strLen('a')
        println("len=${len}")

        len = isDemo.strLen(true)
        println("len=${len}")
    }

    @Test
    fun testStrLen2() {
        val web = "www.tencent.com"
        var len: Int = isDemo.strLen2(web)
        println("len=${len}")

        len = isDemo.strLen2(134)
        println("len=${len}")

        len = isDemo.strLen2('a')
        println("len=${len}")

        len = isDemo.strLen2(true)
        println("len=${len}")
    }
}