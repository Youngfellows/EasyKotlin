package com.easykotlin.learn.study1

import java.util.*

/**
 * 声明变量和值
 */
class VariableVSValue {

    /**
     * 声明可变变量
     */
    fun declareVar() {
        var a = 1
        a = 2
        println("a=${a}")
        println(a::class)
        println(a::class.java)

        var x = 5 //自动推断出"Int"类型
        x += 1
        println("x=${x}")
    }

    /**
     * 声明不可变变量
     */
    fun declareVal() {
        val b = "c"
        //b = "d" //不可变变量不能从新赋值
        println("b=${b}")
        println(b::class)
        println(b::class.java)

        val c: Int = 1 //立即赋值
        val d = 2 //自动推断出‘Int’类型
        val e: Int //如果没有赋值，类型不能省略
        e = 3
        println("c=${c},d=${d},e=${e}")
    }

    /**
     * 省略变量类型
     */
    fun typeInference() {
        //字符串
        var str = "shenzhen"
        println("str=${str}")
        val isStr = str is String
        println("str is String: $isStr")
        println(str::class)
        println(str::class.java)

        //日期对象
        val date = Date()
        println("date:${date}")
        val isDate = date is Date
        println("date is Date:$isDate")
        println(date::class)
        println(date::class.java)

        //布尔类型
        val bool = true
        println("bool=${bool}")
        println(bool::class)
        println(bool::class.java)

        //数组
        val array = arrayOf(1, 2, 3, 4)
        val isArray = array is Array
        println("isArray type:${isArray::class.java}")
        println(array)
        println(array::class)
        println(array::class.java)
    }

    /**
     * 变量类型转换
     */
    fun Int2Long() {
        val x: Int = 10
        //val y: Long = x//类型不匹配
        val y: Long = x.toLong()
        println("x type:${x::class.java}")
        println("y type:${y::class.java}")
        println("y=${y}")
    }

    /**
     * 使用is运算符进行类型检查
     */
    fun getLength(obj: Any): Int? {
        var length = 0
        if (obj is String) {
            //obj在该分支自动转化为String
            println(obj::class)
            length = obj.length
        }
        println("length=${length}")
        //离开类型检测后,obj仍然为Any类型
        println(obj::class)
        return 0
    }
}