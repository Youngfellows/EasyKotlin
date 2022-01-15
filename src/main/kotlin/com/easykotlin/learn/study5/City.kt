package com.easykotlin.learn.study5

/**
 * 私有主构造函数
 * 继承自Any类，也可以省略不写
 */
//class City private constructor(name: String) : Any() {
class City private constructor(name: String) : Any() {
//class City constructor(name: String) {

    /**
     * 城市名称
     */
    public var name: String = name

    /**
     * 城市面加
     */
    public var area: Double = 0.0

    /**
     * 定义属性: 市长
     * 属性必须要初始化，或者如果不初始化那就得是抽象的abstract属性
     */
    public var mayor: String? = null

    /**
     * 人口
     */
    public var population: Int = 0

    /**
     * 人均收入
     */
    public var salary: Double = 0.0

    /**
     * : this(name)是调用主构造函数,传递参数
     */
    constructor(name: String, area: Double) : this(name) {
        this.area = area
    }

    /**
     * 函数（方法）:获取城市的GDP总和
     */
    fun getGdp(): Double {
        return population * salary
    }

    override fun toString(): String {
        return "City(name='$name', area=$area)"
    }

}