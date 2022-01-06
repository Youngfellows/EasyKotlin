package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class InfixFunctionDemoTest {

    @Test
    fun testInfixFunction() {
        val person = Person("jack", 22)
        val nPerson = person.grow(3) //中缀操作符函数调用1
        println(person)
        println(nPerson)

        val mPerson = person grow 4 //中缀操作符函数调用2
        println(mPerson)
    }
}