package com.easykotlin.learn.study9

import kotlin.math.abs

/**
 * 部门
 */
class Department constructor() : Any() {
    /**
     * 部门ID
     */
    var id: Long = -1

    /**
     *
     */
    var name: String = "应用开发部"

    /**
     * 是否打开
     */
    var isOpen: Boolean = false

    /**
     * 是否大部门
     */
    var isBig: String = "Yes"

    //使用 @JvmField 注解对Kotlin中的属性字段标注，表示这是一个实例字段（Instance Fields），
    //Kotlin编译器在处理的时候，将不会给这个字段生成getters/setters方法。
    @JvmField
    var NO: Int = 1234

    //静态字段,静态方法
    //Kotlin中在命名对象或伴生对象中声明的属性:
    companion object {
        var staticName: String = "熊猫"

        @JvmField
        var staticAge: Int = 22

        fun getPrice(): Double = 3.154

        @JvmStatic
        fun getLength(a: Double, b: Double): Double {
            return abs(b - a)
        }
    }

    constructor(id: Long) : this() {
        this.id = id
    }

    override fun toString(): String {
        return "Department(id=$id, name='$name', isOpen=$isOpen, isBig='$isBig')"
    }

}