package com.easykotlin.learn.study7

/**
 * 位置
 */
//class Point() : Any() {
class Point {
    /**
     * x坐标
     */
    var x: Double = 0.0

    /**
     * y坐标
     */
    var y: Double = 0.0

    /**
     * 构造函数
     */
    constructor(x: Double, y: Double) {
        this.x = x
        this.y = y
    }
}