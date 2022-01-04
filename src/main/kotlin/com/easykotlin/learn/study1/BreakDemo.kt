package com.easykotlin.learn.study1

/**
 * break结束循环
 */
fun main(args: Array<String>) {
    breakTest()
}

/**
 * break结束循环
 */
fun breakTest() {
    //遇到偶数,结束循环
    for (num in 1..10) {
        println("num=${num}")
        if (num % 2 == 0) {
            break
        }
    }
}
