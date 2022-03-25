package com.easykotlin.learn.study12

/**
 * 颜色转化
 */
class ColorRGB {

    /**
     * 计算alpha色值
     *
     * @param color 状态栏颜色值
     * @param alpha 状态栏透明度
     */
    public fun cipherColor(color: Int, alpha: Int): Int {
        if (alpha == 0) {
            return color
        }
        val a = 1 - alpha / 255f
        var red = color shr 16 and 0xff
        var green = color shr 8 and 0xff
        var blue = color and 0xff
        println("red:$red")
        println("green:$green")
        println("blue:$blue")

        red = (red * a + 0.5).toInt()
        green = (green * a + 0.5).toInt()
        blue = (blue * a + 0.5).toInt()
        return 0xff shl 24 or (red shl 16) or (green shl 8) or blue
    }

}