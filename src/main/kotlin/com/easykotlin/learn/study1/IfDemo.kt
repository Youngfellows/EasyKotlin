package com.easykotlin.learn.study1

//if表达式
fun main(args: Array<String>) {
    var a = 3;
    var b: Int = 4;
    var max: Int

    max = max(a, b)
    println("max=${max}")

    a = 5
    b = 2
    max = max1(a, b)
    println("max=${max}")

    a = 1
    b = 6
    max = max2(a, b)
    println("max=${max}")

    a = 7
    b = 3
    max = max3(a, b)
    println("max=${max}")
}

/**
 * kotlin中,if作为一个表达式，它会返回一个值
 */
fun max(a: Int, b: Int): Int {
    val max = if (a > b) a else b
    return max
}

/**
 * kotlin中,if作为一个表达式，它会返回一个值
 */
fun max1(a: Int, b: Int): Int {
    return if (a > b) a else b
}

/**
 * 传统用法
 */
fun max2(a: Int, b: Int): Int {
    var max: Int = 0;
    if (a > b) {
        max = a;
    } else {
        max = b
    }
    return max
}

/**
 * if分支可以是代码块，最后的表达式作为改块的值
 */
fun max3(a: Int, b: Int): Int {
    val max = if (a > b) {
        println("a > b")
        a
    } else {
        println("a < b")
        b
    }
    return max
}
