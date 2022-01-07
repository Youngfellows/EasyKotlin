package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AsDemoTest {

    @Test
    fun testAs() {
        //测试类型转化
        val father = Father()
        val son = Son("郭靖")

        println(son is Son)//true 自己
        println(son is Father)//子类 is 父类 = true
        println(father is Son)//父类 is 子类 = false
        println(father is Father)//true 自己

        //子类转化为父类
        val tf = son as Father
        println(tf)

        //父类不能转化为子类
        val tg = father as Son
        println(tg)
    }
}