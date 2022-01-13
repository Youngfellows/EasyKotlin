package com.easykotlin.learn.study3

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

/**
 * Map映射
 */
class MapDemo {

    /**
     * 创建map
     */
    fun createEmptyMap() {
        //创建一个只读空Map
        var emptyMap: Map<String, String> = mapOf<String, String>()
        var size: Int = emptyMap.size
        var isEmpty: Boolean = emptyMap.isEmpty()
        println(emptyMap)
        println(emptyMap::class)
        println(emptyMap::class.java)
        println("size=${size},isEmpty=${isEmpty}")

        //用另外一个函数创建空Map
        emptyMap = emptyMap<String, String>()
        size = emptyMap.size
        isEmpty = emptyMap.isEmpty()

        println(emptyMap)
        println(emptyMap::class)
        println(emptyMap::class.java)
        println("size=${size},isEmpty=${isEmpty}")
    }

    fun createMap() {
        //用二元组Pair创建一个只读Map
        val heroYangGuo: Map<String, String> = mapOf("name" to "杨过", "kunghu" to "玄铁剑法", "age" to "33")
        println(heroYangGuo)

        var iterator: Iterator<Map.Entry<String, String>> = heroYangGuo.iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            val key = entry.key
            val value = entry.value
            println("key=${key},value=${value}")
        }

        //创建一个空的可变的Map
        val mapHero = mutableMapOf<String, Any?>()
        var isEmpty: Boolean = mapHero.isEmpty()
        var size: Int = mapHero.size
        println("isEmpty=${isEmpty},size=${size}")
        mapHero["name"] = "令狐冲"
        mapHero["kunghu"] = "独孤九剑"
        mapHero["city"] = "华山派"
        mapHero["girlFriend"] = "东方不败"
        println(mapHero)
        isEmpty = mapHero.isEmpty()
        size = mapHero.size
        println("isEmpty=${isEmpty},size=${size}")

        var it: Iterator<Map.Entry<String, Any?>> = mapHero.iterator()
        while (it.hasNext()) {
            val entry = it.next()
            val key = entry.key
            val value = entry.value
            println("key=${key},value=${value}")
        }

        println("=======================================")

        //创建一个可变的Map
        //如果Map中有重复的key键，后面的会直接覆盖掉前面的
        val mapStudent = mutableMapOf<String, Any?>(
            "name" to "郭靖", "age" to 23, "city" to "襄阳", "kunghu" to "蛤蟆功", "girlFriend" to "黄蓉", "age" to "38"
        )
        it = mapStudent.iterator()
        while (it.hasNext()) {
            val entry: MutableMap.MutableEntry<String, Any?> = it.next()
            val key = entry.key
            val value = entry.value
            println("key=${key},value=${value}")
        }
    }

    fun createMap2() {
        //`hashMapOf(): HashMap<K, V>`
        //创建HashMap对象。Kotlin直接使用的是Java的HashMap。
        val mapHero: HashMap<String, Any?> =
            hashMapOf<String, Any?>("name" to "小龙女", "age" to 22, "kunghu" to "玉女剑法", "boyFriend" to "杨过")
        var size = mapHero.size
        var isEmpty = mapHero.isEmpty()
        if (!isEmpty) {
            val iterator: MutableIterator<MutableMap.MutableEntry<String, Any?>> = mapHero.iterator()
            while (iterator.hasNext()) {
                val entry = iterator.next()
                val key = entry.key
                val value = entry.value
                println("key=${key},value=${value}")
            }
        }

        println("=========================================")

        //`linkedMapOf(vararg pairs: Pair<K, V>): LinkedHashMap<K, V>`
        //创建带二元组Pair元素的LinkedHashMap对象。直接使用的是Java中的LinkedHashMap。
        val mapBick: LinkedHashMap<String, Any?> =
            linkedMapOf<String, Any?>("branch" to "摩拜", "city" to "深圳", "charge" to 1.98)

        size = mapBick.size
        isEmpty = mapBick.isEmpty()
        if (!isEmpty) {
            val iterator: MutableIterator<MutableMap.MutableEntry<String, Any?>> = mapBick.iterator()
            while (iterator.hasNext()) {
                val entry = iterator.next()
                val key = entry.key
                val value = entry.value
                println("key=${key},value=${value}")
            }
        }

        println("==========================================")

        //`linkedMapOf(): LinkedHashMap<K, V>`
        //创建空对象LinkedHashMap。直接使用的是Java中的LinkedHashMap。
        val mapFlower: LinkedHashMap<String, Any?> = linkedMapOf<String, Any?>()
        mapFlower["name"] = "玫瑰花"
        mapFlower["store"] = "荷兰花卉小镇"
        mapHero["price"] = 99.99
        size = mapFlower.size
        isEmpty = mapFlower.isEmpty()
        if (!isEmpty) {
            val iterator: MutableIterator<MutableMap.MutableEntry<String, Any?>> = mapFlower.iterator()
            while (iterator.hasNext()) {
                val entry = iterator.next()
                val key = entry.key
                val value = entry.value
                println("key=${key},value=${value}")
            }
        }

        println("============================================")
        //`sortedMapOf(vararg pairs: Pair<K, V>): SortedMap<K, V>`
        //创建一个根据Key升序排序好的TreeMap。对应的是使用Java中的SortedMap。
        val mapSchool: SortedMap<String, Any?> = sortedMapOf<String, Any?>(
            Pair("school", "深圳市第一中学"), Pair("address", "福田区香蜜湖"), Pair("teacher", 400), Pair("student", 3000)
        )
        println(mapSchool)
        size = mapSchool.size
        isEmpty = mapSchool.isEmpty()
        if (!isEmpty) {
            val iterator: MutableIterator<MutableMap.MutableEntry<String, Any?>> = mapSchool.iterator()
            while (iterator.hasNext()) {
                val entry = iterator.next()
                val key = entry.key
                val value = entry.value
                println("key=${key},value=${value}")
            }
        }
    }
}