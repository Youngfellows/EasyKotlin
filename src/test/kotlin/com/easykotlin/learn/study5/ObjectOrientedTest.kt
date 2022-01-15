package com.easykotlin.learn.study5

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * 面向对象编程
 */
@RunWith(JUnit4::class)
class ObjectOrientedTest {

    @Test
    fun testAnimalCreate() {
        //声明类
        val animal: Animal = Animal("普通动物")
        println(animal)

        val animal1: Animal = Animal("普通动物1", 3)
        println(animal1)
    }

    @Test
    fun testPrivateCreate() {
//        val citySZ: City = City("深圳")
//        println(citySZ)

        val citySZ: City = City("深圳", 77.0)
        println(citySZ)

        val cityBJ: City = City("北京", 960.0)
        cityBJ.mayor = "令狐冲"
        cityBJ.population = 33
        cityBJ.salary = 123.4
        val gdp: Double = cityBJ.getGdp()
        println("${cityBJ.name},${cityBJ.mayor},${gdp}")
        println(cityBJ)
    }

    @Test
    fun testAbsObject() {
        val teacher: Teacher = Teacher("风轻扬", 78, 136.0)
        println("name=${teacher.name},age=${teacher.age}")
        println("address=${teacher.address},salary=${teacher.salay},weight=${teacher.weight}")
        //设置属性
        teacher.address = "华山"
        teacher.salay = 25000.0
        println("address=${teacher.address},salary=${teacher.salay}")

        //调用方法
        teacher.doEat()//被重写
        teacher.doWalk()//被重写
        teacher.doSleep()//被重写

        teacher.doSwim()//没有被重写

        //如果我们定义了一个自定义的 getter,setter，那么每次给属性赋值时都会调用它
        teacher.partner = "李莫愁"
        println("partner=${teacher.partner}")

        println("sex=${teacher.sex}")
        teacher.sex = "女"
        println("sex=${teacher.sex}")

        println("hobby=${teacher.hobby}")
        //不能设置属性
        //teacher.hobby = "打篮球"
    }
}