package com.easykotlin.learn.study7

import kotlin.reflect.KProperty

/**
 * 提供被委托的属性值
 */
class BookContent {
    /**
     * 内容
     */
    private var content: String? = null

    /**
     * 获取被委托的属性
     */
    operator fun getValue(delegatePropertiesBook: DelegatePropertiesBook, property: KProperty<*>): String {
        println("getValue: $delegatePropertiesBook property ${property.name}")
        return content + ""
    }

    /**
     * 设置被委托的属性
     */
    operator fun setValue(delegatePropertiesBook: DelegatePropertiesBook, property: KProperty<*>, s: String) {
        println("setValue: $delegatePropertiesBook property ${property.name}")
        this.content = s
    }
}