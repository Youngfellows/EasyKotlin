package com.easykotlin.learn.study7

/**
 * 数据类: 书本
 * var name: 书名
 * var page: 页数
 * val price: 价钱
 */
final data class Book(
    var bookName: String,
    var page: Int,
    val price: Double,
    val author: String,
    override var size: Int
) : DBase(size), IBaseA,
    IBaseB {

    /**
     * 重写接口方法
     */
    override fun getWeight(): Double {
        return 1.5
    }

    /**
     * 重写接口方法
     */
    override fun getYear(): Int? {
        return 2022
    }

    /**
     * 数据类有以下的限制要求
     * 1.主构造函数需要至少有一个参数
     * 2.主构造函数的所有参数需要标记为 val 或 var；
     * 3.跟普通类一样，数据类也可以有次级构造函数
     * 4.数据类不能是抽象、开放、密封或者内部的
     * 5.数据类只能是final的
     * 6.在1.1之前数据类只能实现接口。自 1.1 起，数据类可以扩展其他类
     */

    var public: String? = null

    /**
     * 次级构造函数
     */
    constructor(bookName: String, page: Int, price: Double, author: String, public: String, size: Int) :
            this(bookName, page, price, author, size) {
        this.public = public
    }

    /**
     * 获取描述
     */
    fun getDes(): String {
        return toString()
    }

    override fun toString(): String {
        return "Book(bookName='$bookName', page=$page, price=$price, author='$author', public=$public)"
    }

}