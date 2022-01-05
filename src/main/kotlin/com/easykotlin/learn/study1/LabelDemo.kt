package com.easykotlin.learn.study1

/**
 * 可以用Label标签来控制 `return`、`break` 或 `continue`的跳转（jump）行为
 */
fun main(args: Array<String>) {
    returnDemo1()
    returnDemo2()
    breakDemo1()
    breakDemo2()
    breakDemo3()
}

/**
 * 显示指定lambda 表达式中的return地址是其入口处
 */
fun returnDemo1() {
    println("start " + ::returnDemo1.name)
    val intArray = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    intArray.forEach here@{
        if (it == 3) {
            return@here // 指令跳转到 lambda 表达式标签 here@ 处。继续下一个it=4的遍历循环
        }
        println("it=${it}")
    }
    println("end " + ::returnDemo1.name)
}

/**
 * 我们也可以使用隐式标签更方便。 该标签与接收该 lambda 的函数同名。
 */
fun returnDemo2() {
    println("start " + ::returnDemo2.name)
    val intArray = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    intArray.forEach {
        if (it == 3) {
            return@forEach // 指令跳转到 lambda 表达式标签 here@ 处。继续下一个it=4的遍历循环
        }
        println("it=${it}")
    }
    println("end " + ::returnDemo2.name)
}

/**
 * 通常当我们在循环体中使用break，是跳出最近外层的循环
 */
fun breakDemo1() {
    println("start " + ::breakDemo1.name)
    for (outer in 1..5) {
        println("outer=${outer}")
        for (inner in 1..10) {
            println("inner=${inner}")
            if (inner % 2 == 0) {
                break
            }
        }
    }
    println("end " + ::breakDemo1.name)
}

/**
 *当我们想直接跳转到外层for循环，这个时候我们就可以使用标签了
 */
fun breakDemo2() {
    println("start " + ::breakDemo2.name)
    outer@ for (outer in 1..5) {
        println("outer=${outer}")
        for (inner in 1..10) {
            println("inner=${inner}")
            if (inner % 2 == 0) {
                break@outer//结束外层循环
            }
        }
    }
    println("end " + ::breakDemo2.name)
}

/**
 * 们可以用标签来显式地指出循环体的跳转地址，比如说在`breakDemo_1()`中，我们可以用标签来指明内层循环的跳转地址
 */
fun breakDemo3() {
    println("start " + ::breakDemo3.name)
    for (outer in 1..5) {
        inner@ for (inner in 1..10) {
            println("outer=${outer}")
            println("inner=${inner}")
            if (inner % 2 == 0) {
                break@inner
            }
        }
    }
    println("end " + ::breakDemo3.name)
}
