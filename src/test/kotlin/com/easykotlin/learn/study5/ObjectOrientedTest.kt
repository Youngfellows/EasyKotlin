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

    @Test
    fun testIJKPlayer() {
        val ijkPlayer: IJKPlayer = IJKPlayer()
        val kernel: String? = ijkPlayer.kernel
        //val mode: PlayMode = ijkPlayer.mode
        //println("kernel=$kernel,mode=$mode")
        //ijkPlayer.kernel = "QQPlayer" //不能设置
        //ijkPlayer.mode = PlayMode.SINGLE_PLAY_MODE
        println("kernel=$kernel,owner=${ijkPlayer.owner}")
        ijkPlayer.onCreate()
        ijkPlayer.onStart()
        ijkPlayer.onNext()
        ijkPlayer.onPrevious()
        ijkPlayer.setMode(PlayMode.SINGLE_PLAY_MODE)
        ijkPlayer.onStop()
        ijkPlayer.onDestroy()
    }

    @Test
    fun testAndroidSystem() {
        val android: Android = Android("AndroiSystem", "Google", "CHINA")
        val component: String = android.component()
        val net: String = android.getNet()
        val component1: String = android.component1()
        println(component)
        println(component1)
        println("支持的网络:$net")
    }

    @Test
    fun testHarmonyOS() {
        val harmonyOS: HarmonyOS = HarmonyOS("HarmonyOS", "HUAWEI", "CHINA")
        val system: String = harmonyOS.system
        val owner: String = harmonyOS.owner
        val country: String? = harmonyOS.country
        val component: String = harmonyOS.component()
        val component1: String = harmonyOS.component1()
        val net: String = harmonyOS.getNet()

        println("$system,$owner,$country")
        println(component)
        println(component1)
        println(net)
    }
}