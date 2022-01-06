package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class OuterTest {

    @Test
    fun testMyFun() {
        val outer: Outer = Outer()
        outer.Inner().myFun()
    }
}