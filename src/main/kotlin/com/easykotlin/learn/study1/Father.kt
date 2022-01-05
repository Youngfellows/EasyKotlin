package com.easykotlin.learn.study1

/**
 * 定义父类
 */
open class Father {

    /**
     * 定义属性
     */
    open var firstName = "Chen"
    open var lastName = "Jason"

    /**
     * 定义方法
     */
    fun eat() {
        println("父亲吃米饭")
    }
}