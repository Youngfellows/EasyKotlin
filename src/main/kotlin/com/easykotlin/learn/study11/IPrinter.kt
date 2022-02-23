package com.easykotlin.learn.study11

interface IPrinter {
    /**
     * 开始打印
     */
    fun printStarting()

    /**
     * 打印成功
     */
    fun printSuccess()

    /**
     * 打印失败
     */
    fun printFailed()
}