package com.easykotlin.learn.study11

interface IService {
    /**
     * 方法1
     */
    abstract fun doSomething1(s: String): String

    /**
     * 方法2
     * @return
     */
    abstract fun doSomething2(s: String): String
}