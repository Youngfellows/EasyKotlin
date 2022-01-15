package com.easykotlin.learn.study5


/**
 * 基类: 操作系统
 */
open abstract class BaseSystem(system: String, owner: String) {
    /**
     * 系统名称
     */
    var system: String = system

    /**
     * 系统拥有者
     */
    var owner: String = owner

    /**
     * 国家
     */
    var country: String? = null

    constructor(system: String, owner: String, country: String?) : this(system, owner) {
        this.country = country
    }

    /**
     * 功能
     */
    open fun component(): String {
        return "打电话+发邮件+上网+看视频"
    }

    /**
     * 功能
     */
    open fun component1(): String {
        return "特殊功能"
    }

    /**
     * 抽象方法: 支持网络
     */
    abstract fun getNet(): String
}