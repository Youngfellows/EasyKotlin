package com.easykotlin.learn.study1

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class VariableVSValueTest {

    /**
     * 声明对象
     */
    val variableVSValue: VariableVSValue = VariableVSValue()

    @Test
    fun testDeclareVar() {
        //调用方法
        variableVSValue.declareVar()
    }

    @Test
    fun testDeclareVal() {
        //调用方法
        variableVSValue.declareVal()
    }

    @Test
    fun testTypeInference() {
        //省略变量类型
        variableVSValue.typeInference()
    }

    @Test
    fun testInt2Long() {
        //变量类型转换
        variableVSValue.Int2Long()
    }

    @Test
    fun testGetLength() {
        // 使用is运算符进行类型检查
        val obj = "www.baidu.com"
        val length = variableVSValue.getLength(obj)
        //Assert.assertTrue(length == 13)

        val obj2: Any = Any()
        variableVSValue.getLength(obj2)
    }

}