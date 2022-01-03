package com.easykotlin.learn

import java.util.*

/**
 * 包级别函数
 */
fun now() {
    println("Now Date is: ${Date()}")
}

/**
 * 包级对象
 */
class Car {
    fun drive() {
        println("Drive the Car ...")
    }
}