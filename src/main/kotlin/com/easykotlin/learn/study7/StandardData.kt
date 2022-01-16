package com.easykotlin.learn.study7

/**
 * 标准数据类使用
 */
class StandardData {

    /**
     * 使用标准数据类Pair
     */
    fun usePairData() {
        val hero: MutableList<Pair<String, Any?>> = mutableListOf<Pair<String, Any?>>()
        hero.add(Pair("name", "杨过"))
        hero.add(Pair("wife", "小龙女"))
        hero.add("kunghu" to "玄铁剑法")
        hero.add("age" to 18)
        println(hero)

        val iterator: MutableIterator<Pair<String, Any?>> = hero.iterator()
        while (iterator.hasNext()) {
            val next: Pair<String, Any?> = iterator.next()
            val key: String = next.first
            val value: Any? = next.second
            println("${key}:${value}")
        }
    }
}