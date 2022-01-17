package com.easykotlin.learn.study7

/**
 * 世界经济论坛
 */
class WorldEconomicForum constructor(name: String) : IForum {

    /**
     * 属性:论坛名称
     */
    public val name: String = name

    /**
     * 属性:论坛举办城市
     */
    public var city: String? = null

    /**
     *次级构造函数
     */
    constructor(name: String, city: String) : this(name) {
        this.city = city
    }

    /**
     * 致辞
     */
    override fun oration(): String {
        return "在${city}举行的${name},国家主席发表了热情洋溢的致辞..."
    }

    /**
     * 嘉宾分享
     */
    override fun share(): String {
        return "特邀嘉宾都各种分享了各自的关于世界经济的看法,大家一起预测未来经济的走势..."
    }

    /**
     * 会议成果
     */
    override fun outcome(): String {
        return "会议形成了关于如何复苏世界经济的一些列重要成果..."
    }
}