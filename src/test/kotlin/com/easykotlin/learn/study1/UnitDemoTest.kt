package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UnitDemoTest {

    /**
     * 创建对象
     */
    val unitDemo: UnitDemo = UnitDemo()

    @Test
    fun testUnitReturn1() {
        val unitResult = unitDemo.unitReturn1()
        println(unitResult)
        println(unitResult::class)
        println(unitResult::class.java)
    }

    @Test
    fun testUnitReturn2() {
        val unitResult = unitDemo.unitReturn2()
        println(unitResult)
        println(unitResult::class)
        println(unitResult::class.java)
    }

    @Test
    fun testUnitReturn3() {
        val unitResult = unitDemo.unitReturn3()
        println(unitResult)
        println(unitResult::class)
        println(unitResult::class.java)
    }
}