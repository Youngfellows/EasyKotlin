package com.easykotlin.learn.study4

/**
 * 泛型类:书店
 */
class BookStore<T>(t: T) {

    /**
     * 定义属性
     */
    var date: T = t
}