package com.easykotlin.learn.study5

/**
 * 鸭子能跑,能飞,也能游
 */
class Duck constructor(name: String) : AbsAnimal(name), IRunnable, ISwimable, IFlyable {

    /**
     * 重写父类方法
     */
    override fun doEat() {
        super.doEat()
        println("${name} Eating ...")
    }

    /**
     * 实现接口
     */
    override fun doRun() {
        println("${name} Runing ...")
    }

    /**
     * 实现接口
     */
    override fun doSwim() {
        println("${name} Swiming ...")
    }

    /**
     * 实现接口
     */
    override fun doFly() {
        println("${name} Flying ...")
    }
}