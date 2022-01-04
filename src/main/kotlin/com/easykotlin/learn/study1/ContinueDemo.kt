package com.easykotlin.learn.study1

/**
 * continue结束本次循环
 */
fun main(args: Array<String>) {
    //打印所有的奇数
    for (num in 1..10) {
        if (num % 2 == 0) {
            continue
        }
        println("num=${num}")
    }
}