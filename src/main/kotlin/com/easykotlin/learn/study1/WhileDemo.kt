package com.easykotlin.learn.study1

/**
 * while循环
 */
fun main(args: Array<String>) {
    var x = 10
    while (x > 0) {
        println("x=${x}")
        x--
    }

    println("====================")

    var y = 10
    do {
        y += 1
        println("y=${y}")
    } while (y <= 20)
}