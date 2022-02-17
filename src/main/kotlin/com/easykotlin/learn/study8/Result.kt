package com.easykotlin.learn.study8

import java.lang.Exception

/**
 * 回调接口
 * @param T 泛型参数
 */
interface Result<T> {
    /**
     * 成功
     * @param t 泛型参数
     */
    fun onSucess(t: T)

    /**
     * 异常
     * @param e 异常
     */
    fun onFailed(e: Exception);
}