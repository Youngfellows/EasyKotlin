package com.easykotlin.learn.study2


/**
 * list(列表）
 */
class ListDemo {

    /**
     * 创建不可变List
     */
    fun listDemo1() {
        //listOf()来构建一个没有元素的空的List
        val emptyList = listOf<String>() //这里的变量的类型不能省略，否则会报错：
        println(emptyList)
        println(emptyList::class)
        println(emptyList::class.java)

        //创建一个只有1个元素的List
        val cityList = listOf<String>("北京")
        println(cityList)
        println(cityList::class)
        println(cityList::class.java)

        //创建一个有多个元素的List
        val furitList = listOf<String>("苹果", "香蕉", "橘子", "葡萄", "火龙果")
        println(furitList)
        println(furitList::class)
        println(furitList::class.java)


        //使用arrayListOf函数来创建一个Java中的ArrayList对象实例
        val heroList = arrayListOf<String>("杨过", "郭靖", "乔峰", "西门吹雪")
        println(heroList)
        println(heroList::class)
        println(heroList::class.java)
    }

    /**
     * 创建可变集合MutableList
     */
    fun listDemo2() {
        //构建一个没有元素的空的List
        val emptyList = mutableListOf<String>()
        println(emptyList)
        println(emptyList::class)
        println(emptyList::class.java)

        //创建一个有多个元素的List
        val heroList = mutableListOf<String>("杨过")
        println(heroList)
        println(heroList::class)
        println(heroList::class.java)

        //创建一个有多个元素的List
        val cityList = mutableListOf<String>("天津", "深圳", "武汉", "大连", "上海")
        println(cityList)
        println(cityList::class)
        println(cityList::class.java)

        //使用arrayListOf函数来创建一个Java中的ArrayList对象实例
        val heroList2 = ArrayList<String>()
        heroList2.add("杨过")
        heroList2.add("郭靖")
        heroList2.add("乔峰")
        heroList2.add("西门吹雪")
        println(heroList2)
        println(heroList2::class)
        println(heroList2::class.java)
    }

    /**
     * 遍历List元素:使用Iterator迭代器
     */
    fun listDemo3() {
        val listCity = listOf<String>("北京", "天津", "南宁", "武汉", "广州")
        println(listCity)

        val iterator = listCity.iterator()
        while (iterator.hasNext()) {
            val city: String = iterator.next()
            println(city)
        }
    }

    /**
     * 遍历List元素:使用forEach遍历List元素
     */
    fun listDemo4() {
        val listFlower: MutableList<String> = mutableListOf<String>("玫瑰", "君子兰", "文竹", "芦荟", "发财树", "栀子花")
        println(listFlower)
        listFlower.forEach() { it ->
            val flower = it
            println(flower)
        }
    }

    /**
     * 遍历List元素:使用for遍历List元素
     */
    fun listDemo5() {
        val listFlower: MutableList<String> = mutableListOf<String>("玫瑰", "君子兰", "文竹", "芦荟", "发财树", "栀子花")
        println(listFlower)
        for (flower: String in listFlower) {
            println(flower)
        }
    }


    /**
     * 遍历List元素:使用for遍历List元素
     */
    fun listDemo6() {
        val listFlower: MutableList<String> = mutableListOf<String>("玫瑰", "君子兰", "文竹", "芦荟", "发财树", "栀子花")
        println(listFlower)
        val size = listFlower.size
        for (index in 0 until size) {
            val flower: String = listFlower[index]
            println(flower)
        }
    }

    /**
     * 遍历List元素:使用forEach遍历List元素
     */
    fun listDemo7() {
        val listFlower: MutableList<String> = mutableListOf<String>("玫瑰", "君子兰", "文竹", "芦荟", "发财树", "栀子花")
        println(listFlower)
        listFlower.forEachIndexed() { index, flower ->
            println("${index}=${flower}")
        }
    }

    /**
     * 遍历List元素:使用while遍历List元素
     */
    fun listDemo8() {
        val listFlower: MutableList<String> = mutableListOf<String>("玫瑰", "君子兰", "文竹", "芦荟", "发财树", "栀子花")
        println(listFlower)
        val size: Int? = listFlower.size
        var index: Int = 0
        while (index < size!!) {
            println(listFlower.get(index))
            index++
        }
    }
}