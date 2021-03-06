package com.easykotlin.learn.study9

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class KotlinUsingJavaTest {

    /**
     * 创建对象
     */
    val using: KotlinUsingJava = KotlinUsingJava()

    @Test
    fun testKotlinUsingJavaCollect() {
        using.kotlinUsingJavaCollect()
    }

    /**
     *Kotlin调用Java中的Getter 和 Setter
     */
    @Test
    fun testCallJavaGetterSetter() {
        val product: Product = Product()
        product.id = 10086
        product.category = "金融财务类"
        product.setName("财务系统")//
        //product.name = "财务系统"
        product.gmtCreate = Date()
        product.setGmtModified(Date())

        //将对象转化为JSON字符串
        val json: String = JSONUtils.toJsonString(product)
        println(json)

        //将json转化为对象
        val product1: Product = JSONUtils.parseObject(json, Product::class.java)
        product1.name = "资金系统"
        println("name:${product1.name}")
    }

    @Test
    fun testKotlinUsingJavaVoidCall() {
        val television: Television = Television("TCL", 24, "黑市")
        //println(television)

        //如果一个 Java 方法返回 void，那么从 Kotlin 调用时中返回 Unit。
        val result: Unit = television.introduce(3, "beijing") //kotlin.Unit
        println(result)
    }

    /**
     * 空安全和平台类型
     */
    @Test
    fun testKotlinUsingJavaNullSafe() {
        val television: Television = Television()
        television.name = null
        //television.name = "创维P50 Pro"

        val name: String? = television?.name ?: null
        //println("name:${name}")
        val substring: String? = name?.substring(1)
        println("sub:${substring}")
    }

    /**
     * 使用可变参数
     */
    @Test
    fun testKotlinUsingJavaVarArgs() {
        var array: Array<Any?> = arrayOf<Any?>(1, 2, 3)
        //传递可变参数给java
        var result: String = VarArgs.appendElement(*array)
        println(result)

        //传递可变参数给java
        array = arrayOf<Any?>("apple", 1, 3, 4, 'A', 3.1415926)
        result = VarArgs.appendElement(*array)
        println(result)
    }

    /**
     * 使用反射
     */
    @Test
    fun testReflect() {
        val television: Television = Television()
        val tClass: Class<out Television> = television::class.java
        val canonicalName: String = tClass.canonicalName //返回类名
        println(canonicalName)
        //遍历属性
        tClass.declaredFields.forEach {
            println(it)
        }

        //遍历方法
        tClass.declaredMethods.forEach {
            //println(it.name)
            println(it)
            //遍历参数
            it.parameters.forEach {
                println(it)
            }
        }
    }
}