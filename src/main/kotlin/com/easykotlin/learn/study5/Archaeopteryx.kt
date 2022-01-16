package com.easykotlin.learn.study5

/**
 * 始祖鸟, 能飞也能跑
 */
class Archaeopteryx(name: String) : AbsAnimal(name), IRunnable, IFlyable {

    /**
     * 实现接口
     */
    override fun doRun() {
        println("$name Running ...")
    }

    /**
     * 实现接口
     */
    override fun doFly() {
        println("$name Flying ...")
    }

    override fun doEat() {
        super.doEat()
        println("$name Eating ...")
    }
}