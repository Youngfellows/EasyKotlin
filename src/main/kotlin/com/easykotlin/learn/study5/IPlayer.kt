package com.easykotlin.learn.study5

import com.easykotlin.learn.study5.PlayMode as PlayMode

/**
 * 接口定义
 * Kotlin 的接口与 Java 8 的接口类似。
 * 与抽象类相比，他们都可以包含抽象的方法以及方法的实现
 */
interface IPlayer {

    /**
     * 在接口中声明的属性，可以是抽象的，或者是提供访问器的实现。不能被初始化
     * 抽象属性: 播放器内核
     */
    val kernel: String? //抽象的

    /**
     * 接口属性: 访问器实现
     */
    val owner: String get() = "bilibili"//访问器实现

    /**
     * 抽象属性: 设置播放模式
     */
    //var mode: PlayMode

    /**
     * 抽象方法: 创建
     */
    abstract fun onCreate()

    /**
     * 抽象方法: 开始播放
     */
    abstract fun onStart()

    /**
     * 抽象方法: 停止播放
     */
    abstract fun onStop()

    /**
     * 抽象方法: 下一首
     */
    abstract fun onNext()

    /**
     *抽象方法: 上一首
     */
    abstract fun onPrevious()

    /**
     * 抽象方法: 销毁播放器
     */
    abstract fun onDestroy()

    /**
     * 方法实现: 设置播放模式
     */
    open fun setMode(mode: PlayMode) {
        println("set play mode ${mode}...")
    }
}