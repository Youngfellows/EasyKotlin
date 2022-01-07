package com.easykotlin.learn.study1

/**
 *Unit同java中的Void类型相似
 */
class UnitDemo {

    /**
     * 什么都不写,返回Unit
     */
    fun unitReturn1() {

    }

    /**
     * 显示的返回Unit
     */
    fun unitReturn2() {
        println("" + ::unitReturn2.name)
        return Unit
    }

    /**
     * 函数声明时,返回Unit类型
     */
    fun unitReturn3(): Unit {

    }
}