package com.easykotlin.learn.study1

/**
 * Elvis操作符 ?: 是一个二元运算符，如果第一个操作数为真，则返回第一个操作数，否则将计算并返回其第二个操作数。它是三元条件运算符的变体。
 */
fun main(args: Array<String>) {
    val name = "我喜欢Kotlin"
    val displayName = name ?: ""
    println(displayName)

    var city: String? = null
    var displayCity = city ?: ""
    println("displayCity=${displayCity}")
    city = "shengzheng"
    displayCity = city ?: ""
    println("displayCity=${displayCity}")

    val x = null
    val y = x ?: 0
    println("y=${y}")

    val z = false
    val h = z ?: "0"
    println("h=${h}")

    val l = ""
    val m = l ?: 0
    println("m=${m}")

    val nick = "www.baidu.com"
    val displayNick = nick ?: "-----"
    println(displayNick)
}