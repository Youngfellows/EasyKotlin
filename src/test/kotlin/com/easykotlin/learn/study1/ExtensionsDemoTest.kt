package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ExtensionsDemoTest {

    @Test
    fun testExtensions() {
        val extensionsDemo = ExtensionsDemo()
        extensionsDemo.useExtensions()//使用扩展函数和扩展属性
        extensionsDemo.Inner().useExtensions()
    }
}