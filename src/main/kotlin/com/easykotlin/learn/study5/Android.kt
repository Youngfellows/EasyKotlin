package com.easykotlin.learn.study5

/**
 * 子类继承父类,Android可以被继承,必须声明成open
 */
open class Android constructor(system: String, owner: String, country: String) :
    BaseSystem(system, owner, country) {

    /**
     * 获取支持网络
     */
    override fun getNet(): String {
        return "5G"
    }

    /**
     * 基础功能
     */
    open override fun component(): String {
        return super.component()
    }

    /**
     * override重写的函数也是open的，如果希望它不被重写，可以在前面增加final
     */
    final override fun component1(): String {
        //return super.component1()
        return "侧边滑动返回"
    }

}