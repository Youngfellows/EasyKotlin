package com.easykotlin.learn.study1

/**
 * for循环语句
 */
fun main(args: Array<String>) {
    val citys = arrayOf("成都", "深圳", "广州", "大连")
    testFor1(citys)
    testFor2(citys)
    testFor3(citys)
}

/**
 * for循环遍历
 */
fun testFor1(args: Array<String>) {
    println("size=${args.size}")
    for (item in args) {
        println(item)
    }
}

/**
 * 索引遍历
 */
fun testFor2(args: Array<String>) {
    println("===============================")
    for (index in args.indices) {
        val city = args.get(index)
        println("${index},${city}")
    }
}

/**
 * 索引遍历
 */
fun testFor3(args: Array<String>) {
    println("=========================")
    for ((index, city) in args.withIndex()) {
        println("${index},${city}")
    }
}