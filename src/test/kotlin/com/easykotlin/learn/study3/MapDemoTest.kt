package com.easykotlin.learn.study3

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MapDemoTest {

    /**
     * 创建对象
     */
    private val mapDemo: MapDemo = MapDemo()

    @Test
    fun testCreateEmptyMap() {
        mapDemo.createEmptyMap()
    }

    @Test
    fun testCreateMap() {
        mapDemo.createMap()
    }

    @Test
    fun testCreateMap2() {
        mapDemo.createMap2()
    }
}