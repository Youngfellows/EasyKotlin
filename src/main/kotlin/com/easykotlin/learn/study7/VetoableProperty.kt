package com.easykotlin.learn.study7

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Delegates.vetoable 可否决属性委托
 */
class VetoableProperty {

    /**
     * 当我们把属性委托给这个函数时，我们可以通过onChange函数的返回值是否为true， 来选择属性的值是否需要改变。
     */

    /**
     * grade属性可以改变
     */
    var grade: String by Delegates.vetoable("P0")
    { kProperty: KProperty<*>, oldValue: String, newValue: String ->
        println("${oldValue} -> ${newValue}")
        true
    }

    /**
     * price属性不可以改变
     */
    var price: Double by Delegates.vetoable(
        3.1415926,
        onChange = { kProperty: KProperty<*>, oldValue: Double, newValue: Double ->
            println("${oldValue} -> ${newValue}")
            false
        })

    /**
     * Delegates.notNull 非空属性委托，name属性不能设置为null
     */
    var name: String by Delegates.notNull<String>()

    fun vetoableDemo() {
        println(grade)
        grade = "P1"
        grade = "P2"
        grade = "P3"
        println(grade)

        println("===================")
        println(price)
        price = 1.23
        price = 6.99
        price = 99.88
        println(price)
    }

    fun notNullDemo() {
        name = "小仙女"
        println(name)

        //name属性不能设置为null
        //name = null
    }
}