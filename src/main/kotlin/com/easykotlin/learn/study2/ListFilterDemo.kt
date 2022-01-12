package com.easykotlin.learn.study2

/**
 *过滤操作函数
 */
class ListFilterDemo {

    fun listFilterFunction1() {
        //`take(n: Int): List<T>` 挑出该集合前n个元素的子集合
        val listFlower: MutableList<String> = mutableListOf<String>("荷花", "玫瑰花", "菊花", "山茶花", "梅花", "栀子花", "君子兰", "薰衣草")
        println(listFlower)

        val subListFlower: List<String> = listFlower.take(3)
        println(subListFlower)

        //`takeWhile(predicate: (T) -> Boolean): List<T>` 挑出满足条件的元素的子集合，有bug,必须是第一个条件满足，否则后面的都是空
        val listCity: MutableList<String> =
            mutableListOf<String>("南京", "北京", "天津", "大连", "大理", "大庆", "安庆", "广州", "柳州", "扬州")
        var subListCity: List<String> = listCity.takeWhile { it.contains("庆") }
        println(listCity)
        println(subListCity)


        //`takeLast` 挑出后n个元素的子集合
        subListCity = listCity.takeLast(6)
        println(subListCity)

        //`takeLastWhile(predicate: (T) -> Boolean)` 从最后开始挑出满足条件元素的子集合
        subListCity = listCity.takeLastWhile { it.contains("州") }
        println(subListCity)

        //有bug,必须是第一个条件满足，否则后面的都是空
        subListCity = listCity.takeLastWhile { it.contains("大") }
        println(subListCity)
    }

    fun listFilterFunction2() {
        //`drop(n: Int)` 去除前n个元素返回剩下的元素的子集合
        val listCity: MutableList<String> =
            mutableListOf<String>("南京", "北京", "天津", "大连", "大理", "大庆", "安庆", "广州", "柳州", "扬州")
        var subListCity: List<String> = listCity.drop(3)
        println(listCity)
        println(subListCity)

        //`dropLast(n: Int)` 从最后去除n个元素
        subListCity = listCity.dropLast(3)
        println(subListCity)

        //`dropLastWhile(predicate: (T) -> Boolean)` 从最后满足条件的元素,有bug
        subListCity = listCity.dropLastWhile { it.contains("大") }
        println(subListCity)
    }

    fun listFilterFunction3() {
        //`slice(indices: IntRange)` 取开始下标至结束下标元素子集合
        val listCity: MutableList<String> =
            mutableListOf<String>("南京", "北京", "天津", "大连", "大理", "大庆", "安庆", "广州", "柳州", "扬州")
        var subListCity: List<String> = listCity.slice(2..4)
        println(listCity)
        println(subListCity)

        //`slice(indices: Iterable<Int>) `返回指定下标的元素子集合
        val indices: List<Int> = listOf<Int>(1, 3, 4, 6, 8);
        subListCity = listCity.slice(indices)
        println(subListCity)

        //`filterTo(destination: C, predicate: (T) -> Boolean)` 过滤出满足条件的元素并赋值给destination
        var destListCity: MutableList<String> = mutableListOf<String>()
        listCity.filterTo(destListCity) { it.contains("大") }
        println(destListCity)

        //`filter(predicate: (T) -> Boolean)`过滤出满足条件的元素组成的子集合
        val filterCity:List<String> = listCity.filter { it.contains("州") }
        println(filterCity)
    }
}