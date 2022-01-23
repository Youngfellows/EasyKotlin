package com.easykotlin.learn.study9

/**
 * kotlin使用java
 */
class KotlinUsingJava {

    /**
     * kotli中使用java的集合
     */
    fun kotlinUsingJavaCollect() {
        //kotlin中的list列表集合
        val listOfKotli: List<String> = listOf<String>("香蕉", "苹果", "火龙果", "樱桃")

        //java中的list列表集合
        val listOfJava = ArrayList<String>()
        println(listOfJava)

        //添加元素
        for (element: String in listOfKotli) {
            listOfJava.add(element)
        }
        println(listOfJava)

        //获取并更新元素
        //for (i in 0..listOfKotli.size - 1) {
        for (i in listOfKotli.indices) {
            listOfJava[i] = "${listOfKotli[i]}${i}"
        }
        println(listOfJava)
    }
}