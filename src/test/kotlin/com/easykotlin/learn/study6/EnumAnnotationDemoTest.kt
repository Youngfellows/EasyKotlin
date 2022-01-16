package com.easykotlin.learn.study6

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class EnumAnnotationDemoTest {

    @Test
    fun testEnumDirection() {
        var direction: Direction = Direction.WEST
        println("direction:$direction")
        direction = Direction.NORTH
        println("direction:$direction")

        //获取枚举常量的名称和位置
        val name = direction.name
        val ordinal = direction.ordinal
        println("$ordinal,$name")
    }

    @Test
    fun testEnumColor() {
        var color: Color = Color.RED
        var name: String = color.name
        var ordinal: Int = color.ordinal
        println("$color,ordinal=$ordinal,name=$name")

        color = Color.GREEN
        name = color.name
        ordinal = color.ordinal
        println("$color,ordinal=$ordinal,name=$name")

        println("============================")

        //遍历函数enumValues<Color>()列出了Color枚举类的所有枚举值
        val enumValues: Array<Color> = enumValues<Color>()
        val iterator: Iterator<Color> = enumValues.iterator()
        while (iterator.hasNext()) {
            val color: Color = iterator.next()
            println(color)
        }

        //将Arry数组转化为String字符串
        val joinToString = enumValues.joinToString { "${it.name} : ${it.ordinal}" }
        println(joinToString)
    }

    @Test
    fun testAnnotation() {
        val useAnnotation: UseAnnotation = UseAnnotation("使用注解", 33)
        println("number=${useAnnotation.number}")
        println(useAnnotation.doEat())
    }
}