package com.easykotlin.learn.study7

/**
 * 属性委托
 */
class DelegatePropertiesBook {
    /**
     * 在 var content: String by BookContent()中， by 后面的表达式的BookContent()就是该属性委托的对象。
     * content属性对应的 get()（和 set()）会被委托给BookContent()的
     * operator fun getValue()和 operator fun setValue() 函数，
     * 这两个函数是必须的，而且得是操作符函数。
     */
    var content: String by BookContent()
}