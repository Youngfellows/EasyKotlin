package com.easykotlin.learn.study4

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GenericsTypeDemoTest {

    /**
     * 测试泛型
     */
    @Test
    fun testGenericsType() {
        val bookStoreSz: BookStore<Book> = BookStore<Book>(Book("深圳书城"));
        val book: Book = bookStoreSz.date
        val bookName: String? = book.name
        println("bookName=${bookName}")

        val bookStore: BookStore<Employee> = BookStore<Employee>(Employee("小龙女", 33))
        val employee: Employee = bookStore.date
        val age: Int = employee.age
        val name: String = employee.name
        println("name=${name},age=${age}")
    }
}