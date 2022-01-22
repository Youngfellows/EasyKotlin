package com.easykotlin.learn.study8

/**
 * 电子商务接口
 */
interface IEbusiness {

    /**
     * 商品详情
     */
    fun getDetail(): String

    /**
     * 获取评论
     */
    fun getComments(): String

    /**
     * 获取推荐
     */
    fun getRecommend(): String
}