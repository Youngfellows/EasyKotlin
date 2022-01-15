package com.easykotlin.learn.study5

import javafx.scene.text.FontWeight

/**
 * 具体实现类
 */
class Teacher(name: String, age: Int, override var weight: Double) : AbsPerson(name, age) {

    /**
     * 重写抽象属性,必须初始化
     */
    override var address: String? = "默认地址"
    /* get() = "默认地址"
     set(value) {}*/

    /**
     * 重写抽象属性,必须初始化
     */
    override var salay: Double = 0.0
    /*  get() = 0.0
      set(value) {}*/

    /**
     * 重写抽象属性,
     * 如果我们定义了一个自定义的 getter,setter，那么每次给属性赋值时都会调用它
     */
    override var partner: String?
        get() = "每次获取都调用,没有伙伴"
        set(value) {
            println("set value=${value}")
        }

    /**
     * 当一个属性需要一个幕后字段时，Kotlin 会自动提供。
     * 这个幕后字段可以使用field标识符在访问器中引用：
     */
    override var sex: String = "男" // 注意：这个初始器直接为幕后字段赋值,
        get() = field
        set(value) {
            field = value
            println("set vale=${field}")
        }

    /**
     * 需要改变一个访问器的可见性或者对其注解，但是不需要改变默认的实现， 你可以定义访问器而不定义其实现:
     */
    var hobby: String? = "打乒乓球"
        private set

    /**
     * 重写抽象方法
     */
    override fun doEat() {
        println("老师${name}在办公室坐着吃 ...")
    }

    /**
     * 重写抽象方法
     */
    override fun doWalk() {
        println("老师${name}在学校操场慢跑 ...")
    }

    /**
     * 重写父类的doSleep
     */
    override fun doSleep() {
        //super.doSleep()
        println("老师${name},在椅子上躺着睡 ...")
    }
}