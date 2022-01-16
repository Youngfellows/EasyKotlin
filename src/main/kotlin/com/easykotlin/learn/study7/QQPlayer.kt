package com.easykotlin.learn.study7

/**
 *伴生对象
 */
//class QQPlayer private constructor() : Any() {
class QQPlayer {

    /**
     * 属性
     */
    val kernel: String = "QQ_Kernel"

    /**
     * 属性
     */
    fun onCreate() {
        println("onCreate ...")
    }

    /**
     * 伴生对象,一个类的伴生对象默认引用名是Companion
     */
    //companion object {
    companion object INSTANCE {
        /**
         *创建Application
         */
        fun create(): QQPlayer = QQPlayer()

        val kernel_: String = QQPlayer().kernel

        fun getArea(): Double = 1000.0
    }
}