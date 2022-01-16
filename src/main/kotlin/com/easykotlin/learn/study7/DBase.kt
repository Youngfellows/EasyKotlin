package com.easykotlin.learn.study7

/**
 * 数据类得基类: 类和属性都要声明成可以被重写的
 */
open class DBase constructor(open var size: Int) : Any() {
    init {
        this.size = size
    }
}