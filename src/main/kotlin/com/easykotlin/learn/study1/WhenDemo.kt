package com.easykotlin.learn.study1

/**
 * when表达式
 */
fun main(args: Array<String>) {
    cases(1)
    cases("hello")
    cases(100)
    cases(true)
    cases(Any())

    switch(1)
    switch(123)
    switch(-1)
    switch(99)


    range(1)
    range(4)
    range(22)
}

/**
 * when条件判断
 */
fun cases(obj: Any) {
    when (obj) {
        1 -> println("第一项")
        "hello" -> println("这是字符串hello")
        is Long -> println("${obj}是Long类型数据")
        !is String -> println("${obj}不是String类型数据")
        else -> println("elses类似于java中的default")
    }
}

/**
 * 多个分支条件放在一起，用逗号分隔
 */
fun switch(x: Int) {
    val s = "123"
    when (x) {
        -1, 0 -> println("x == -1 or x == 0")
        1 -> println("x == 1")
        2 -> println("x == 2")
        8 -> println("x == 8")
        parseInt(s) -> println("x is 123")
        else -> {
            // 注意这个块
            println("x is neither 1 nor 2")
        }
    }
}

/**
 * 可以用任意表达式（而不只是常量）作为分支条件
 */
fun parseInt(obj: Any): Int {
    var result: Int = 0
    when (obj) {
        is String -> result = obj.toInt()
    }
    return result
}

/**
 * 检测一个值在 in 或者不在 !in 一个区间或者集合中
 */
fun range(x: Int) {
    val validNumbers = arrayOf(1, 2, 3)
    when (x) {
        //in 1..10 -> println("x is in the range")
        in validNumbers -> println("x is validNumbers")
        !in 10..20 -> println("x is outside the range")
        else -> println("none of the above")
    }
}