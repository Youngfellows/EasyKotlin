package com.easykotlin.learn.study7

/**
 * 接口:论坛
 */
interface IForum {

    /**
     * 致辞
     */
    fun oration(): String

    /**
     * 嘉宾分享发言
     */
    fun share(): String

    /**
     * 会议成功
     */
    fun outcome(): String
}