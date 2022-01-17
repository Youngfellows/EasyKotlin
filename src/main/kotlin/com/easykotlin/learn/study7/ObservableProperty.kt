package com.easykotlin.learn.study7

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Delegates.observable 可观察属性委托
 */
class ObservableProperty {

    /**
     * 可观察属性委托: 排名
     */
    var level: String by Delegates.observable("PO") { kProperty: KProperty<*>, oldValue: String, newValue: String ->
        println("$oldValue -> $newValue")
    }

    /**
     * 可观察属性委托: 价钱
     */
    var price: Double by Delegates.observable(
        0.0,
        onChange = { kProperty: KProperty<*>, oldValue: Double, newValue: Double ->
            println("$oldValue -> $newValue")
        })

    fun observableDemo() {
        //我们把属性委托给Delegates.observable函数，当属性值被重新赋值的时候， 触发其中的回调函数 onChange
        println(level)
        level = "P1"
        level = "P2"
        level = "P3"
        println(level)

        println("===================")
        println(price)
        price = 1.5
        price = 2.5
        price = 3.5
        println(price)
    }
}