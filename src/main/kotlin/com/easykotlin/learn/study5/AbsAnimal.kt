package com.easykotlin.learn.study5

/**
 * 抽象类动物
 */
abstract class AbsAnimal constructor(name: String) {

    /**
     * 定义属性,并通过构造函数赋值
     */
    var name: String = name

    /**
     * 动物共有素性: 吃
     */
    open fun doEat() {
        println("Animal Eat ...")
    }
}