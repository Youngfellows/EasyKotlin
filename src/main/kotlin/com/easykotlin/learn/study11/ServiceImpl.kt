package com.easykotlin.learn.study11

/**
 * 服务的具体实现
 */
class ServiceImpl : IService {

    override fun doSomething1(s: String): String {
        println("doSomething1,input is $s")
        return s
    }

    override fun doSomething2(s: String): String {
        println("doSomething2,input is $s")
        return s
    }
}