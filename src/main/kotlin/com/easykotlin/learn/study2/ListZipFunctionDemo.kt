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

}