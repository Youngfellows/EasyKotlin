package com.easykotlin.learn.study5

import com.easykotlin.learn.study5.PlayMode as PlayMode

/**
 * IJKPlayer播放器
 */
class IJKPlayer : IPlayer {

    /**
     * 重写属性
     */
    override var kernel: String? = "NO Player" //初始化
        get() = "IJKPlayer"//每次调用都返回它
        private set//不能调用setter函数设置kernel

    /**
     * 重写属性
     */
    //var mode: PlayMode = PlayMode.LIST_PLAY_MODE

    /**
     * 实现方法: onCreate
     */
    override fun onCreate() {
        println("onCreate:: $kernel")
    }

    override fun onStart() {
        println("onStart:: $kernel")
    }

    override fun onStop() {
        println("onStop:: $kernel")
    }

    override fun onNext() {
        println("onNext:: $kernel")
    }

    override fun onPrevious() {
        println("onPrevious:: $kernel")
    }

    override fun onDestroy() {
        println("onDestroy:: $kernel")
    }

    override fun setMode(mode: PlayMode) {
        println("setMode:: $mode")
        super.setMode(mode)
    }
}