package com.easykotlin.learn.study12

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ColorRGBTest {

    /**
     * 创建对象
     */
    val colorRGB: ColorRGB = ColorRGB()

    @Test
    fun testCipherColor() {
        val color: Int = -4253158
        colorRGB.cipherColor(color, 128)
    }
}