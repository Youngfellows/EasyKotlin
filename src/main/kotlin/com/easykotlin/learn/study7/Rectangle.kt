package com.easykotlin.learn.study7

import java.util.*

/**
 * 矩形
 */
class Rectangle constructor(name: String) : AbsShape(name), IShape {

    /**
     * 左上边
     */
    var topleft: Point? = null

    /**
     * 右上边
     */
    var topright: Point? = null

    /**
     * 左下边
     */
    var bottomleft: Point? = null

    /**
     * 右下边
     */
    var bottomright: Point? = null

    /**
     * 构造,初始化矩形坐标
     */
    constructor(name: String, topleft: Point, topright: Point, bottomleft: Point, bottomright: Point) : this(name) {
        this.topleft = topleft
        this.topright = topright
        this.bottomleft = bottomleft
        this.bottomright = bottomright
    }

    /**
     * 求周长
     */
    override fun circumference(): Double {
        //匿名object

        return 0.0
    }

    /**
     * 求面积
     */
    override fun area(): Double {
        println("矩形:$name,面积:")
        return 0.0
    }

    /**
     * 求距离
     */
    fun distance(point: Point): Double {
        //需要的仅仅是一个简单的对象，我们这个时候就可以使用下面的匿名object的方式
        val dot = object {
            val x = 0//圆点x坐标
            val y = 0//圆点y坐标
        }
        return Math.sqrt((point.x - dot.x) * (point.x - dot.x) + (point.y - dot.y) * (point.y - dot.y))
    }

    /**
     * 匿名对象只可以用在本地和私有作用域中声明的类型
     * 私有函数，返回的是匿名object类型
     */
    private fun getColor() = object {
        val color: String = "红色"//颜色
    }

    /**
     * 公有函数，返回的类型是 Any
     */
    public fun getBorder() = object {

        /**
         * 边框大小
         */
        val size: Double = 1.5//无法访问到
    }

    /**
     * 获取属性
     */
    fun getFeatures(): Unit {
        val color = getColor() //私有函数，返回的是匿名object类型
        val red: String = color.color
        println("color=$red")

        val border: Any = getBorder() //公有函数，返回的类型是 Any
        //border.size //error
    }

    /**
     * 跟 Java 匿名内部类类似，object对象表达式中的代码可以访问来自包含它的作用域的变量
     * （与 Java 不同的是，这不限于 final 变量）
     */
    fun compare() {
        val numbers: MutableList<Int> = mutableListOf<Int>(3, 2, 1, 4, 5, 9, 5, 7, 6, 8, 0, 11, 10)
        var count: Int = 0
        Collections.sort(numbers, object : Comparator<Int> {
            override fun compare(o1: Int, o2: Int): Int {
                count++
                println("count:${count}")
                println(numbers)
                return o1.compareTo(o2)
            }
        })
        println("=============================")
        println(numbers)
    }
}