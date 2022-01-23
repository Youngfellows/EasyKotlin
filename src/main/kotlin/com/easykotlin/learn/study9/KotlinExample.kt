package com.easykotlin.learn.study9

/**
 * Kotlin包级函数和属性
 */

fun f1() {
    println("running in f1")
}

fun f2() {
    println("running in f1")
}

/**
 * 包级属性
 */
val address: String = "深圳南山区"

/**
 * 扩展函数,交换字符串的位置字符
 */
fun String.swap(index1: Int, index2: Int): String? {
    val toCharArray: CharArray = this.toCharArray()
    val temp: Char = toCharArray[index1]
    toCharArray[index1] = toCharArray[index2]
    toCharArray[index2] = temp

    var result: String = ""
    toCharArray.forEach {
        result += it
    }
    return result
}