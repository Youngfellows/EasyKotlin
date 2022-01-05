package com.easykotlin.learn.study1

/**
 * 在扩展函数或者带接收者的函数字面值中， this 表示在点左侧传递的 接收者参数
 */
fun main(args: Array<String>) {
    val a: Int = 3
    var result = a.myAdd(4)
    println("result=${result}")
    result = a.mySub(2)
    println("result=${result}")
}

/**
 * Int的扩展函数
 */
fun Int.myAdd(x: Int): Int {
    return this + x
}

/**
 * Int的扩展函数
 */
fun Int.mySub(x: Int): Int = this - x
