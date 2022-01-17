package com.easykotlin.learn.study7

/**
 * 属性委托给Map映射
 */
class Hero(val map: Map<String, Any?>) {

    /**
     * 定义属性: 名字
     */
    val name: String by map

    /**
     * 定义属性: 年龄
     */
    val age: Int by map

    /**
     * 定义属性: 存款
     */
    val money: Double by map

    /**
     * 定义属性: 妻子
     */
    val wife: String by map

    override fun toString(): String {
        return "Hero(name=$name,age=$age,money=$money,wife=$wife)"
    }
}