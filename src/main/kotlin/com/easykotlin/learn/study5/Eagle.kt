package com.easykotlin.learn.study5

/**
 * Eagle继承AbsAnimal,实现IFlayable方法
 */
class Eagle constructor(name: String) : AbsAnimal(name), IFlyable {

    /**
     * 实现接口方法
     */
    override fun doFly() {
       println("$name Fly ...")
    }

    override fun doEat() {
        super.doEat()
        println("$name Eat Insect ...")
    }
}