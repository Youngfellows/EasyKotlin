package com.easykotlin.learn.study1

/**
 * 运算符重载
 */
class OperatorDemo {

}

/**
 * 数据类
 */
data class Point(val x: Int, val y: Int)

/**
 * 重载操作符的函数需要用 operator 修饰符标记。中缀操作符的函数使用infix修饰符标记
 */
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

/**
 * 重载操作符的函数需要用 operator 修饰符标记。中缀操作符的函数使用infix修饰符标记
 */
operator fun Point.unaryPlus() = Point(x, y)


/**
 * 自定义重载的 + 运算符
 */
data class Counter(val index: Int)

/**
 * 自定义重载的 + 运算符
 */
operator fun Counter.plus(increment: Int): Counter {
    return Counter(index + increment)
}
