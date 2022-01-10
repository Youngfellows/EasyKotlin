package com.easykotlin.learn.study2

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
}