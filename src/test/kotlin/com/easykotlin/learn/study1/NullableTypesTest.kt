package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NullableTypesTest {

    val nullableTypes: NullableTypes = NullableTypes()

    @Test
    fun testNullable1Demo() {
        val name = "深圳"
        val nick = "鹏城"
        val size = nullableTypes.testNullable1(name, nick)
        println("size=${size}")
    }


    @Test
    fun testNullable2Demo() {
        var name = "深圳"
        var nick: String? = "鹏城"
        var size = nullableTypes.testNullable2(name, nick)
        println("size=${size}")

        name = "北京"
        nick = null
        size = nullableTypes.testNullable2(name, nick)
        println("size=${size}")
    }


    @Test
    fun testNullable3Demo() {
        var name = "深圳"
        var nick: String? = "鹏城"
        var size = nullableTypes.testNullable3(name, nick)
        println("size=${size}")

        name = "北京"
        nick = null
        size = nullableTypes.testNullable3(name, nick)
        println("size=${size}")
    }
}