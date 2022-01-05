package com.easykotlin.learn.study1

/**
 * 定义子类: super关键字持有指向其父类的引用
 */
class Son : Father {
    /**
     * 覆写子类的属性
     */
    override var firstName: String = super.firstName
    override var lastName: String = "Jack"

    constructor(lastName: String) {
        this.lastName = lastName
    }

    fun love() {
        super.eat()//调用父类的方法
        println("${super.firstName} ${super.lastName} Love ${this.firstName} ${this.lastName}")
    }
}