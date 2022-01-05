package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SonTest {

    @Test
    fun testSon() {
        val son: Son = Son("xiaoming")
        son.love()
    }
}