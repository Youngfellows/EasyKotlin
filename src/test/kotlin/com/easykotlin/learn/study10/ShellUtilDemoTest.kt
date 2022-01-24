package com.easykotlin.learn.study10

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ShellUtilDemoTest {

    @Test
    fun testKotlinShell() {
        val result: String = "adb devices".execute().text()
        println(result)
    }
}