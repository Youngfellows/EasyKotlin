package com.easykotlin.learn.study9

import java.lang.Exception

/**
 * 编程书籍
 */
class ProgrammingBook {

    private var isbn: String = "978-7-111-44250-9"

    protected var author: String = "李白"

    public var name: String = "Kotlin进阶教程"

    internal var pages: Int = 348

    private fun findISBN(): String {
        return this.isbn + 11
    }

    protected fun findAuthor(): String {
        return this.author + "XX"
    }

    public fun findName(): String {
        findPages()
        return this.name + "YYY"
    }

    /**
     * internal修饰的只能内部调用
     */
    internal fun findPages(): Int = this.pages

    /**
     * 没有重载
     */
    protected fun getCategory(a: Int, des: String) {
        println("${a},${des}")
    }

    /**
     * 生成默认参数值函数的重载
     */
    @JvmOverloads
    protected fun about(price: Double = 3.14, b: Int = 8) {
        println("$price,$b")
    }

    /**
     * 抛出异常
     */
    protected fun throwException1() {
        throw Exception("I am an exception in kotlin")
    }

    /**
     * 抛出异常
     */
    @Throws(Exception::class)
    protected fun throwException2() {
        throw Exception("I am an exception in kotlin 2")
    }
}