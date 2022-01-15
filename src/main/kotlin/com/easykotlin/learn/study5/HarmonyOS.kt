package com.easykotlin.learn.study5

/**
 * 鸿蒙系统
 */
class HarmonyOS constructor(system: String, owner: String, country: String) : Android(system, owner, country) {

    /**
     * 支持网络类型
     */
    open override fun getNet(): String {
        return super.getNet() + "+6G"
    }

    /**
     * 特性
     */
    open override fun component(): String {
        return super.component() + "+万物互连"
    }
}