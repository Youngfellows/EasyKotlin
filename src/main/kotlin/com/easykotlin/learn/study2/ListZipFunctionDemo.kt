package com.easykotlin.learn.study2

/**
 * List 生产操作符
 */
class ListZipFunctionDemo {

    fun listZipFunction() {
        //zip(other: Iterable<R>): List<Pair<T, R>>
        //两个集合按照下标配对，组合成的每个Pair作为新的List集合中的元素，并返回。
        //如果两个集合长度不一样，取短的长度。

        val listHero: List<String> = listOf<String>("杨过", "乔峰", "令狐冲", "段誉")
        val listKungfu: List<String> = listOf<String>("玄铁剑法", "降龙十八掌", "独孤九剑", "六脉神剑")
        val listHeroKunghu: List<Pair<String, String>> = listHero.zip(listKungfu)
        println(listHero)
        println(listKungfu)
        println(listHeroKunghu)

        val iterator: Iterator<Pair<String, String>> = listHeroKunghu.iterator()
        while (iterator.hasNext()) {
            val hero: Pair<String, String> = iterator.next()
            val name: String = hero.first
            val kunghu: String = hero.second
            println("name=${name},kunghu=${kunghu}")
        }
    }

    fun listUnZipFunction() {
        //unzip(): Pair<List<T>, List<R>>
        //首先这个函数作用在元素是Pair的集合类上。依次取各个Pair元素的first, second值，分别放到ListT>、ListR>中，
        //然后返回一个first为ListT>，second为ListR>的大的Pair。
        val listHeroKunghu: MutableList<Pair<String, String>> = mutableListOf<Pair<String, String>>(
            Pair("杨过", "玄铁剑法"),
            Pair("乔峰", "降龙十八掌"),
            Pair("令狐冲", "独孤九剑"),
            Pair("段誉", "六脉神剑")
        )
        val hero: Pair<List<String>, List<String>> = listHeroKunghu.unzip()
        val heroName: List<String> = hero.first
        val heroKunghu: List<String> = hero.second
        println(heroName)
        println(heroKunghu)

        println("=================")
        heroName.forEach { name ->
            println(name)
        }
        println("=================")
        for (kunghu: String in heroKunghu) {
            println(kunghu)
        }
    }

    fun listPartitionFunction() {
        //partition(predicate: (T) -> Boolean): Pair<List<T>, List<T>>
        //根据判断条件是否成立，将集合拆分成两个子集合组成的 Pair。
        //我们可以直接看函数的定义来更加清晰的理解这个函数的功能：
        val listNumber: List<Int> = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
        var partition: Pair<List<Int>, List<Int>> = listNumber.partition { it > 7 }
        println(partition)
        var firstNumber: List<Int> = partition.first
        var secondNumber: List<Int> = partition.second
        println("===================")
        firstNumber.forEachIndexed() { index, element ->
            println("index=${index},ele=${element}")
        }
        println("===================")
        for (number: Int in secondNumber) {
            println(number)
        }

        partition = listNumber.partition { it % 2 == 0 }
        println(partition)
        firstNumber = partition.first
        secondNumber = partition.second
        println("===================")
        firstNumber.forEachIndexed() { index, element ->
            println("index=${index},ele=${element}")
        }
        println("===================")
        for (number: Int in secondNumber) {
            println(number)
        }
    }

    fun listPlusFunction() {
        //plus(elements: Iterable<T>): List<T>
        //合并两个List。这是一个操作符函数。可以用”+”替代 。
        val listCity1: List<String> = listOf<String>("广州", "深圳", "珠海")
        val listCity2: List<String> = listOf<String>("大连", "锦州", "沈阳")
        var listCity: List<String> = listCity1 + listCity2
        //var listCity: List<String> = listCity1.plus(listCity2)
        println(listCity)

        //plusElement(element: T): List<T>
        //在集合中添加一个元素。
        listCity = listCity.plusElement("武汉")
        println(listCity)

        listCity = listCity + "乌鲁木齐"
        println(listCity)

        println("====================")
        listCity.forEach { println(it) }
    }
}