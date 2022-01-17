package com.easykotlin.learn.study7

/**
 * 类的委托(Class Delegation)
 */
class ProxyForum(val forum: IForum) : IForum by forum {

    //委托代理类 ProxyForum 继承接口 IForum，并将其所有共有的方法委托给一个指定的对象forum
    //ProxyForum 的超类型IForum中的 by forum 表示 forum 将会在 ProxyForum 中内部存储

    /**
     * 代理类调用被委托类的属性和oration方法
     */
    override fun oration(): String {
        return forum.oration()
    }

    /**
     * 代理类调用被委托类的属性和share方法
     */
    override fun share(): String {
        return forum.share()
    }

    /**
     * 代理类调用被委托类的属性和outcome方法
     */
    override fun outcome(): String {
        return forum.outcome()
    }
}