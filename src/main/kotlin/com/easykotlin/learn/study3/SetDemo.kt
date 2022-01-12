package com.easykotlin.learn.study3

import java.util.*
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashSet

/**
 * Set集合
 */
class SetDemo {

    /**
     * 创建Set: Set中的元素是不可重复的（任意两个元素 x, y 都不相等）
     */
    fun setCreate() {
        // 空集
        val emptySet: Set<String> = emptySet<String>()
        println(emptySet)
        println(emptySet::class)
        println(emptySet::class.java)
        val size = emptySet.size
        val isEmpty: Boolean = emptySet.isEmpty()
        val hashCode = emptySet.hashCode()
        println("size=${size},isEmpty=${isEmpty},hashCode=${hashCode}")

        //Kotlin跟Java一样的，判断两个对象的是否重复标准是hashCode()和equals()两个参考值，
        //也就是说只有两个对象的hashCode值一样与equals()为真时，才认为是相同的对象。
        // 所以自定义的类必须要要重写hashCode()和equals()两个函数。

        //Set中的元素是不可重复的（任意两个元素 x, y 都不相等）

        //创建一个不可变的set
        val setCity: Set<String> = setOf<String>("深圳", "北京", "广州", "北京", "大连", "广州")
        println(setCity)

        //List列表中的元素可以重复
        val listFlower: List<String> = mutableListOf<String>("水仙花", "玫瑰花", "菊花", "栀子花", "水仙花", "玫瑰花")
        println(listFlower)

        //创建一个可变Set
        val setHero: MutableSet<String> = mutableSetOf<String>("杨过", "张无忌", "张三丰", "金毛狮王")
        println(setHero)
        setHero.add("小龙女")
        println(setHero)

        //使用Java中的Set类
        //Kotlin中的LinkedHashSet , HashSet, SortedSet, TreeSet 就是直接使用的Java中的对应的集合类
        //对应的创建的方法是
        //hashSetOf
        //linkedSetOf
        //mutableSetOf
        //sortedSetOf
        val setAnimal: HashSet<String> = hashSetOf<String>("小狗", "小猫", "猴子", "小鸡", "小鸭", "小鸟")
        println(setAnimal)

        val setNumber: LinkedHashSet<Int> = linkedSetOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)
        println(setNumber)
        println(setNumber::class)
        println(setNumber::class.java)

        val setKunghu: MutableSet<String> = mutableSetOf<String>("六脉神剑", "乾坤大挪移", "鳞波微步")
        println(setKunghu)
        println(setKunghu::class)
        println(setKunghu::class.java)

        val setComputer: TreeSet<String> = sortedSetOf<String>("惠普", "联想", "戴尔")
        println(setComputer)

        //我们知道在Java中，Set接口有两个主要的实现类HashSet和TreeSet：
        //HashSet : 该类按照哈希算法来存取集合中的对象，存取速度较快。
        //TreeSet : 该类实现了SortedSet接口，能够对集合中的对象进行排序。
        //LinkedHashSet：具有HashSet的查询速度，且内部使用链表维护元素的顺序，在对Set元素进行频繁插入、删除的场景中使用。
        //Kotlin并没有单独去实现一套HashSet、TreeSet和LinkedHashSet。如果我们在实际开发过程中，需要用到这些Set, 就可以直接用上面的方法。
    }

    /**
     * Kotlin中针对Set做了一些加减运算的扩展函数,比如
     * 加减操作 plus minus
     */
    fun setOperator() {
        val setCity1: Set<String> = setOf<String>("深圳", "广州", "大连", "上海")
        val setCity2: Set<String> = setOf<String>("南京", "武汉", "乌鲁木齐", "齐齐哈尔")
        val setCity: Set<String> = setCity1 + setCity2
        println(setCity)

        val setFlower1: Set<String> = setOf<String>("水仙花", "玫瑰花", "薰衣草", "紫罗兰")
        val setFlower2: Set<String> = setOf<String>("玫瑰花", "菊花", "君子兰")
        val setFlower: Set<String> = setFlower1 - setFlower2
        println(setFlower)
    }
}