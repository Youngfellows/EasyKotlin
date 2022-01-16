package com.easykotlin.learn.study7

import java.text.SimpleDateFormat
import java.util.*

/**
 * Kotlin中没有静态属性和方法，但是也提供了实现类似于单例的功能，我们可以使用关键字object声明一个object对象
 * 定义静态的方法和常量
 */
object AdminUser {
    /**
     * 静态属性
     */
    val username: String = "admin"

    /**
     * 静态属性
     */
    val password: String = "password01"

    /**
     * 静态方法
     */
    fun getTimestamp(): String? {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val formatDate: String? = simpleDateFormat.format(Date())
        return formatDate
    }
}