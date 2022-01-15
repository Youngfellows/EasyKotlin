package com.easykotlin.learn.study5

/**
 * 抽象类
 */
//abstract class AbsPerson constructor(name: String, age: Int) : Any() {
abstract class AbsPerson(name: String, age: Int) : Any() {
    /**
     * 初始化方法1
     */
//    var name: String = name
//    var age: Int = age

    /**
     * 初始化访问2
     */
    var name: String? = null
    var age: Int = 0

    /**
     * 抽象的属性
     * 1. 抽象属相在抽象类中不能被初始化
     * 2. 如果在子类中没有主构造函数，要对抽象属性手动初始化。如果子类中有主构造函数，抽象属性可以在主构造函数中声明。
     *
     * 属性: 地址
     */
    abstract var address: String?

    /**
     * 抽象的属性，不需要赋初始值
     * 属性:工资
     */
    abstract var salay: Double

    /**
     * 抽象属性: 体重
     */
    abstract var weight: Double

    /**
     * 抽象属性: 伙伴
     */
    abstract var partner: String?

    /**
     * 抽象属性: 性别
     */
    abstract var sex: String

    init {
        println("init,${this}")
        this.name = name;
        this.age = age
    }

    /**
     * 抽象方法: 吃
     */
    abstract fun doEat()

    /**
     * 抽象方法: 跑
     */
    abstract fun doWalk()

    /**
     * 具体函数: 数默认是final的。也就是说，我们不能重写这个doSwim函数
     */
    fun doSwim() {
        println("I am swim ...")
    }

    /**
     * 如果一个函数想要设计成能被重写，例如fun doSleep(),我们给它加上open关键字即可。
     */
    open fun doSleep() {
        println("I am sleep ...")
    }
}