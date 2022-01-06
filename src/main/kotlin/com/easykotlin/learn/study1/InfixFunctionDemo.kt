package com.easykotlin.learn.study1

/**
 * 数据类
 */
data class Person(val name: String, val age: Int)

/**
 *用infix函数自定义中缀操作符,定义年龄增长
 */
infix fun Person.grow(years: Int): Person {
    return Person(name, age + years)
}