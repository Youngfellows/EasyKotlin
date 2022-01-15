package com.easykotlin.learn.study5

/**
 * 声明类:
 * 主构造函数是类头的一部分，直接放在类名后面
 * 如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字。
 * 如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面：
 *
 * Animal继承自Any类
 */
class Animal constructor(name: String) : Any() {
    //class Animal (var name: String) {
    private var name: String
    private var age: Int = 0

    init {
        this.name = name
        println("init,name=${this.name}")
    }

    /**
     *  constructor 声明次构造函数，次构造函数不能有声明 val 或 var
     */
    constructor(name: String, age: Int) : this(name) {
        println("次级构造函数,age=${this.age}")
        this.age = age
    }

    override fun toString(): String {
        return "Animal(name='$name', age=$age)"
    }

}