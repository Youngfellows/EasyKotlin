package com.easykotlin.learn.study5

/**
 *Dog继承AbsAnimal,实现IRunnable接口
 */
class Dog constructor(name: String) : AbsAnimal(name), IRunnable {

    /**
     * 实现接口方法
     */
    override fun doRun() {
        println("Dog $name Running ...")
    }

    /**
     * 重写父类方法
     */
    override fun doEat() {
        super.doEat()
        println("Dog $name Eat Bone ...")
    }
}