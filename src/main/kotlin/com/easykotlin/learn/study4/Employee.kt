package com.easykotlin.learn.study4

/**
 * 雇员
 */
class Employee(name: String, age: Int) {
    val name: String
    val age: Int

    init {
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "Employee(name='$name', age=$age)"
    }
}