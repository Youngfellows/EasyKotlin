package com.easykotlin.learn.study11

/**
 * 接口回调
 */
interface ICallback {
    /**
     * @param isSucess 是否成功
     * @param message 消息
     */
    fun onDone(isSucess: Boolean, message: String)
}