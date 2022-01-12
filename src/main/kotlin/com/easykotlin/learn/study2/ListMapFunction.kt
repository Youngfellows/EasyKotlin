package com.easykotlin.learn.study2

/**
 * List映射操作符
 */
class ListMapFunction {

    fun listMapFunction1() {
        //`map(transform: (T) -> R): List<R>`
        //将集合中的元素通过转换函数`transform`映射后的结果，存到一个集合中返回。
        val listNumber: MutableList<Int> = mutableListOf<Int>(1, 2, 3, 4, 5, 6)
        val listCity: List<String> = listNumber.map { "北京${it}" }
        println(listNumber)
        println(listCity)

        //`mapIndexed(transform: (kotlin.Int, T) -> R)`
        //转换函数`transform`中带有下标参数。也就是说我们可以同时使用下标和元素的值来进行转换。 其中，第一个参数是Int类型的下标。
        val listFlower: MutableList<String> = mutableListOf<String>("水仙花", "玫瑰花", "栀子花", "牵牛花", "薰衣草")
        println(listFlower)
        val listPrice: List<Int> = listFlower.mapIndexed() { index, element ->
            index * index + 10
        }
        println(listPrice)

        //`mapNotNull(transform: (T) -> R?)`
        //遍历集合每个元素，得到通过函数算子transform映射之后的值，剔除掉这些值中的null，返回一个无null元素的集合。
        val listAddress: MutableList<String?> = mutableListOf<String?>("深圳", "广州", null, "武汉", "大连", "天津", null, "北京")
        val listNewAddress: List<String> = listAddress.mapNotNull { it?.let { "城市:${it}" } }
        println(listAddress)
        println(listNewAddress)
    }

    fun listMapFunction2() {
        //`flatMap(transform: (T) -> Iterable<R>): List<R>`
        //在原始集合的每个元素上调用`transform`转换函数，得到的映射结果组成的单个列表。
        //为了更简单的理解这个函数，我们跟`map(transform: (T) -> R): List<R>`对比下。
        val listFlower: MutableList<String> = mutableListOf<String>("水仙花", "玫瑰花", "栀子花", "牵牛花", "薰衣草")
        val listNewFlower: List<List<String>> = listFlower.map { it -> listOf<String>("1${it}", "2${it}", "3${it}") }
        println(listFlower)
        println(listNewFlower)

        val listNew2Flower: List<String> = listFlower.flatMap { it -> listOf<String>("1${it}", "2${it}", "3${it}") }
        println(listNew2Flower)
    }
}