package com.easykotlin.learn.study2

/**
 * List分组操作符
 */
class ListGroupFunctionDemo {

    fun listGroupFunction1() {
        //`groupBy(keySelector: (T) -> K): Map<K, List<T>>`
        //将集合中的元素按照条件选择器`keySelector`（是一个函数）分组，并返回Map。
        val listFruit: MutableList<String> =
            mutableListOf<String>("apple", "banana", "pear", "Common fig", "orange", "Cherry", "Cranberry")
        println(listFruit)

        val groupBy: Map<Int, List<String>> = listFruit.groupBy { it.length }
        println(groupBy)

        //`groupBy(keySelector: (T) -> K, valueTransform: (T) -> V)`
        //分组函数还有一个是`groupBy(keySelector: (T) -> K, valueTransform: (T) -> V)`，根据条件选择器keySelector和转换函数valueTransform分组。
        val listCouse = mutableListOf<Pair<String, String>>(
            "杨过" to "C语言",
            "郭靖" to "C++",
            "黄蓉" to "HTML",
            "小龙女" to "JS",
            "西门吹雪" to "JAVA",
            "乔峰" to "JAVA",
            "段誉" to "C#",
            "林冲" to "C++",
            "慕容复" to "C语音",
            "烈风" to "JS"
        )
        println(listCouse)

        val groupByCouse: Map<String, List<String>> = listCouse.groupBy({
            it.second
        }, {
            it.first
        })
        println(groupByCouse)

        //遍历map
        val iterator = groupByCouse.iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            val course = entry.key
            val students: List<String> = entry.value
            println("course=${course},students=${students}")
        }

        //#### `groupingBy(crossinline keySelector: (T) -> K): Grouping<T, K>`
        //另外，我们还可以使用`groupingBy(crossinline keySelector: (T) -> K): Grouping<T, K>`函数来创建一个`Grouping`，然后调用计数函数`eachCount`统计分组
        val words = "one two three four five six seven eight nine ten".split(" ")
        val groupingBy: Map<Char, Int> = words.groupingBy { it.first() }.eachCount()
        println(groupingBy)
    }
}