package com.easykotlin.learn.study2

import kotlin.math.sin

/**
 *  List元素操作函数
 */
class ListOperatorDemo {

    /**
     * add remove set clear
     */
    fun listOperator1() {
        val listCity: MutableList<String> = mutableListOf<String>("武汉", "大连", "沈阳", "哈尔滨", "北京")
        println(listCity)

        //向集合中添加一个元素
        listCity.add("深圳")
        println(listCity)

        //在下标为2的位置添加元素
        listCity.add(2, "广州")
        println(listCity)

        //删除元素'沈阳'
        listCity.remove("沈阳")
        println(listCity)

        //删除下标为1的元素
        listCity.removeAt(1)
        println(listCity)

        //添加子集合
        val listNewCity: List<String> = listOf<String>("齐齐哈尔", "乌鲁木齐", "呼和浩特")
        listCity.addAll(listNewCity)
        println(listCity)

        //删除子集合
        val listDelCity: List<String> = listOf<String>("北京", "大连", "乌鲁木齐")
        listCity.removeAll(listDelCity)
        println(listCity)

        //更新设置下标1的元素值为'南昌',更新设置下标2的元素值为'贵阳',
        listCity.set(1, "南昌")
        listCity[2] = "贵阳"
        println(listCity)

        //把可变集合转为不可变集合
        val listCityImmutable = listCity.toList()
        println(listCityImmutable)

        //清空集合
        listCity.clear()
        println(listCity)
    }

    fun listOperator2() {
        //取两个集合交集
        val listCity1: MutableList<String> = mutableListOf<String>("北京", "深圳", "广州", "上海", "南京", "武汉", "成都")
        val listCity2: MutableList<String> = mutableListOf<String>("广州", "上海", "贵阳", "大连", "天津", "北京", "深圳", "昆明")
        val retainAll = listCity1.retainAll(listCity2)
        println(retainAll)
        println(listCity1)
        println(listCity2)
    }

    fun listOperator3() {
        //判断集合中是否有指定元素，有就返回true，否则返回false
        val listCity: MutableList<String> = mutableListOf<String>("北京", "深圳", "广州", "上海", "南京", "武汉", "成都")
        var contains = listCity.contains("南京")
        println(contains)
        contains = listCity.contains("大连")
        println(contains)

        //查找下标对应的元素，如果下标越界会抛IndexOutOfBoundsException
        val listFlower: List<String> = listOf<String>("水仙花", "玫瑰花", "文竹", "栀子花", "芦荟", "发财树")
        var flower: String? = listFlower.elementAt(2)
        println(listFlower)
        println(flower)
        try {
            flower = listFlower.elementAt(30)
            println(flower)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        //查找下标对应元素，如果越界会根据方法返回默认值
        flower = listFlower.elementAtOrElse(10) { "大红花" }
        println(flower)
        //查找下标对应元素，如果越界就返回null
        flower = listFlower.elementAtOrNull(11)
        println(flower)
    }

    fun listOperator4() {
        //返回集合第1个元素，如果是空集，抛出异常NoSuchElementException。
        val listFlower: MutableList<String> = mutableListOf<String>("水仙花", "玫瑰花", "文竹", "栀子花", "芦荟", "发财树")
        var firstFlower: String? = listFlower.first()
        println(listFlower)
        println(firstFlower)

        //返回符合条件的第一个元素，没有则抛异常NoSuchElementException
        try {
            firstFlower = listFlower.first { it.contains("菊") }
            println(firstFlower)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        //返回符合条件的第一个元素，没有就返回null
        firstFlower = listFlower.firstOrNull { it.contains("百合") }
        println(firstFlower)


        //返回指定下标的元素，没有就返回-1
        var index: Int? = listFlower.indexOf("文竹")
        println("index=${index}")

        index = listFlower.indexOf("菊花")
        println("index=${index}")

        //返回第一个符合条件的元素下标，没有就返回-1
        index = listFlower.indexOfFirst { it.contains("栀子") }
        println("index=${index}")

        index = listFlower.indexOfFirst { it.contains("木兰") }
        println("index=${index}")

        //返回集合最后一个元素，空集则抛出异常NoSuchElementException。
        var flower: String? = listFlower.last()
        println(flower)

        //返回符合条件的最后一个元素，没有就抛NoSuchElementException
        flower = listFlower.last { it.contains("花") }
        println(flower)

        try {
            flower = listFlower.last { it.contains("梅") }
            println(flower)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        //对应的针对越界处理的`lastOrNull `函数：返回符合条件的最后一个元素，没有则返回null :
        flower = listFlower.lastOrNull()
        println(flower)

        try {
            flower = listFlower.lastOrNull { it.contains("梅") }
            println(flower)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun listOperator5() {
        //该集合如果只有1个元素，则返回该元素。否则，抛异常。
        var listCity: MutableList<String>? = mutableListOf<String>("深圳", "广州", "北京")
        try {
            val single = listCity?.single()
            println(single)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        var listFlower: MutableList<String> = mutableListOf<String>("山茶花");
        try {
            val flower = listFlower.single()
            println(flower)
        } catch (e: Exception) {
            e.printStackTrace()
        }


        //返回符合条件的单个元素，如有没有符合的抛异常NoSuchElementException，或超过一个的抛异常IllegalArgumentException。
        val listNewFlower = mutableListOf<String>("玫瑰花", "水仙花", "栀子花", "菊花")
        listFlower.addAll(listNewFlower)
        println(listFlower)

        try {
            var flower: String = listFlower.single { it.contains("梅花") }
            println(flower)
        } catch (e: Exception) {
            e.printStackTrace()
        }


        try {
            var flower: String = listFlower.single { it.contains("栀子") }
            println(flower)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}