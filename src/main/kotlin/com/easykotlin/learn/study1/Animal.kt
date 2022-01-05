package com.easykotlin.learn.study1

/**
 * this关键字:在类的成员中，this 指向的是该类的当前对象
 */
class Animal {
    val name: String = "小狗狗"

    fun whatIsThis(): Animal {
        println(this.name) //引用变量
        this.run() //引用成员函数
        return this //返回此类的引用
    }

    private fun run() {
        println("狗狗在跑")
    }
}