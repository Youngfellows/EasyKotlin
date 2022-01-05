package com.easykotlin.learn.study1

import java.lang.Exception
import java.lang.IllegalArgumentException

/**
 *在 Kotlin 中 throw 是表达式，它的类型是特殊类型 Nothing。 该类型没有值。跟C、Java中的`void` 意思一样。
 */
fun main(args: Array<String>) {
    println(Nothing::class)
    fail("你妹呀")

    //如果把一个throw表达式的值赋值给一个变量，需要显式声明类型为`Nothing`
    val ex1 = throw Exception("你好呀")
    val ex: Nothing = throw Exception("大傻逼")
}

/**
 * 我们在代码中，用 Nothing 来标记无返回的函数
 */
fun fail(msg: String): Nothing {
    throw IllegalArgumentException(msg)
}