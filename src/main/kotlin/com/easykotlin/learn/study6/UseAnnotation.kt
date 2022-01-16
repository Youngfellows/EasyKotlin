package com.easykotlin.learn.study6

/**
 * 使用注解: 注解可以用在类、函数、参数、变量（成员变量、局部变量）、表达式、类型上等。这个由该注解的元注解@Target定义。
 * 注解在主构造器上，主构造器必须加上关键字 “constructor”
 */
@MagicClass
class UseAnnotation @MagicConstructor constructor(name: String) : Any() {

    /**
     * 定义属性并初始化
     */
    @MagicClass
    public var number: Int = 0

    @MagicConstructor
    constructor(name: String, number: Int) : this(name) {
        this.number = number
    }

    @MagicFunction
    fun doEat(): String {
        return "do eating ..."
    }
}