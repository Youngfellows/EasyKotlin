package com.easykotlin.learn.study2

import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * List集合类的基本运算函数
 */
class ListFunctionDemo {

    fun listFunction1() {
        //`any()`判断集合至少有一个元素,如果该集合至少有一个元素，返回`true`，否则返回`false`。
        val listFlower: List<String> = listOf<String>("水仙花", "栀子花", "玫瑰花", "荷花", "莲花", "君子兰")
        var any: Boolean = listFlower.any()
        println(any)

        var listCity: MutableList<String> = mutableListOf<String>();
        any = listCity.any()
        println(any)

        //集合中至少有一个元素匹配谓词函数参数`predicate: (T) -> Boolean`，返回true，否则返回false
        any = listFlower.any { it.contains("梅花") }
        println(any)

        any = listFlower.any() { it.contains("玫瑰") }
        println(any)
    }
}