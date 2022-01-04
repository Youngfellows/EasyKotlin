package com.easykotlin.learn.study1

/**
 * Return返回
 */
fun main(args: Array<String>) {
    val x = 10
    val y = 3
    var z = sum(x, y)
    println("sum=${sum(x, y)}")
    println("z=${z}")
    println("max=${maxv(x, y)}")
    println("sum1=${sum1(x, y)}")
    println("maxf=${maxf(x, y)}")

    println("================")
    val sumf = fun(a: Int, b: Int) = a + b
    println(sumf(1, 1))

    //加了{},函数的返回值是函数类型
    val sumv = fun(a: Int, b: Int) = { a + b }
    //println(sumv)
    println(sumv(1, 1))//返回函数类型
    println(sumv(1, 1).invoke())//调用函数返回值类型

    println("=====================")
    test1Return()
    println("=====================")
    test2Return()
}

/**
 * 求和
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * 求最多值
 */
fun maxv(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

/**
 * 可以直接使用`=`符号来直接返回一个函数的值
 */
fun sum1(a: Int, b: Int) = a + b

/**
 * 可以直接使用`=`符号来直接返回一个函数的值
 */
fun maxf(a: Int, b: Int) = if (a > b) a else b


/**
 * kotlin 中 `return` 语句会从最近的函数或匿名函数中返回，但是在Lambda表达式中遇到return，则直接返回最近的外层函数。
 */
fun test1Return() {
    println("start " + ::test1Return.name)
    val intArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    intArray.forEach {
        if (it == 3) {
            return //有点类似循环体中的`break`行为
        }
        println(it)
    }
    println("end " + ::test1Return.name)
}

/**
 * kotlin 中 `return` 语句会从最近的函数或匿名函数中返回，但是在Lambda表达式中遇到return，则直接返回最近的外层函数。
 */
fun test2Return() {
    println("start " + ::test2Return.name)
    val intArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    intArray.forEach(fun(a: Int) {
        if (a == 3) {
            return//有点类似循环体中的`continue`行为,匿名函数替代 lambda 表达式。 匿名函数内部的 return 语句将从该匿名函数自身返回
        }
        println("a=${a}")
    })
    println("end " + ::test2Return.name)
}

