package com.easykotlin.learn.study3

/**
 * Map操作符函数
 */
class MapOperatorDemo {

    fun mapOperator1() {
        //`containsKey(key: K): Boolean`
        //是否包含该key
        val map: Map<Any?, Any?> = mapOf<Any?, Any?>(1 to "价钱", "name" to "小黄车", 'c' to 'A')
        val containsKeyName: Boolean = map.containsKey("name")
        val containsKeyC = map.containsKey(1)
        val containsKeyCity = map.containsKey("city")
        println("containsKeyName=${containsKeyName}")
        println("containsKeyC=${containsKeyC}")
        println("containsKeyCity=${containsKeyCity}")

        //`containsValue(value: V): Boolean`
        //是否包含该value。
        val containsValue1 = map.containsValue("小黄车")
        val containsValue33 = map.containsValue(33)
        println("containsValue1=${containsValue1}")
        println("containsValue33=${containsValue33}")
    }

    /**
     * 遍历map映射
     */
    fun mapOperator2() {
        //`component1()` `component2()`
        //`Map.Entry<K, V>`的操作符函数，分别用来直接访问key和value。
        val mapHero: MutableMap<Any?, Any?> =
            mutableMapOf<Any?, Any?>(Pair("name", "杨过"), Pair('C', 'A'), Pair(1, "第一名"), Pair("kunghu", "玄铁剑法"))

        val entries: MutableSet<MutableMap.MutableEntry<Any?, Any?>> = mapHero.entries
        entries.forEach() {
            val key: Any? = it.component1()
            val value: Any? = it.component2()
            println("${key}=${value}")
        }
    }

    /**
     * 遍历map映射
     */
    fun mapOperator3() {
        val mapHero: MutableMap<Any?, Any?> =
            mutableMapOf<Any?, Any?>(Pair("name", "杨过"), Pair('C', 'A'), Pair(1, "第一名"), Pair("kunghu", "玄铁剑法"))
        val iterator = mapHero.iterator()
        while (iterator.hasNext()) {
            var entry = iterator.next()
            var key: Any? = entry.key
            var value: Any? = entry.value
            //key = entry.component1()
            //value = entry.component2()
            println("${key}=${value}")
        }
    }

    /**
     * 遍历map映射
     */
    fun mapOperator4() {
        //`Map.Entry<K, V>.toPair(): Pair<K, V>`
        //把Map的Entry转换为Pair。
        val mapHero: MutableMap<Any?, Any?> =
            mutableMapOf<Any?, Any?>(Pair("name", "杨过"), Pair('C', 'A'), Pair(1, "第一名"), Pair("kunghu", "玄铁剑法"))
        mapHero.entries.forEach() {
            //println(it)
            //println(it::class)
            //println(it::class.java)
            val pair: Pair<Any?, Any?> = it.toPair()
            println(pair)
            val key: Any? = pair.first
            val value: Any? = pair.second
            println("${key}=${value}")
        }
    }

    /**
     * 遍历map映射
     */
    fun mapOperator5() {
        //`iterator(): Iterator<Map.Entry<K, V>>`
        //这个函数返回的是 `entries.iterator()`。这样我们就可以像下面这样使用for循环来遍历Map：
        val mapHero = mutableMapOf<String, Any?>("name" to "杨过", "age" to 18, "city" to "襄阳", "kunghu" to "玄铁剑法")
        val iterator: MutableIterator<MutableMap.MutableEntry<String, Any?>> = mapHero.iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            val key: String = entry.key
            val value: Any? = entry.value
            println("${key}=${value}")
        }
    }

    fun mapOperator6() {
        //`getValue(key: K): V`
        //当Map中不存在这个key，调用get函数，如果不想返回null，直接抛出异常，可调用此方法。
        val mapHero: MutableMap<Any?, Any?> =
            mutableMapOf<Any?, Any?>(Pair("name", "杨过"), Pair('C', 'A'), Pair(1, "第一名"), Pair("kunghu", "玄铁剑法"))
        try {
            val nameValue = mapHero.getValue("name")
            val ageValue = mapHero.getValue("age")
            val nullValue = mapHero.getValue(3)
            println("nameValue=${nameValue}")
            println("ageValue=${ageValue}")
            println("nullValue=${nullValue}")
        } catch (e: Exception) {
            e.printStackTrace()
        }

        //`getOrElse(key: K, defaultValue: () -> V): V`
        //通过key获取值，当没有值可以设置默认值。
        var kunghu = mapHero.getOrElse("gonghu") {
            "乾坤大挪移"
        }
        println("kunghu=${kunghu}")

        kunghu = mapHero.getOrElse("kunghu") {
            "化骨绵掌"
        }
        println("kunghu=${kunghu}")

        //`getOrPut(key: K, defaultValue: () -> V): V`
        //如果不存在这个key，就添加这个key到Map中，对应的value是defaultValue。
        val age: Any? = mapHero.getOrPut("age") {
            33
        }
        println("age=${age}")
        println(mapHero)
    }

    fun mapOperator7() {
        //`mapKeys(transform: (Map.Entry<K, V>) -> R): Map<R, V>`
        //把Map的Key设置为通过转换函数transform映射之后的值。
        val map: MutableMap<Int, Any?> = mutableMapOf<Int, Any?>(1 to "a", 2 to "b", 3 to "c", -1 to "z")
        println(map)
        map.mapKeys { it.key + 10 }
        println(map)
    }

    fun mapOperator8() {
        //`mapValues(transform: (Map.Entry<K, V>) -> R): Map<K, R>`
        //对应的这个函数是把Map的value设置为通过转换函数transform转换之后的新值。
        val mapHero: MutableMap<Any?, Any?> =
            mutableMapOf<Any?, Any?>(Pair("name", "杨过"), Pair('C', 'A'), Pair(1, "第一名"), Pair("kunghu", "玄铁剑法"))
        val mapNewHero = mapHero.mapValues { "$" + it.value + "@" }
        println(mapHero)
        println(mapNewHero)
    }

    fun mapOperator9() {
        //`filterKeys(predicate: (K) -> Boolean): Map<K, V>`
        //返回过滤出满足key判断条件的元素组成的新Map。
        val mapRanking: Map<Int, String> =
            mapOf<Int, String>(1 to "第一名", 2 to "第二名", 3 to "第三名", 4 to "第四名", 5 to "第五名")
        var filterRanking: Map<Int, String> = mapRanking.filterKeys { it > 3 }
        println(mapRanking)
        println(filterRanking)

        filterRanking = mapRanking.filterKeys { it <= 3 }
        println(filterRanking)

        //`filterValues(predicate: (V) -> Boolean): Map<K, V>`
        //返回过滤出满足value判断条件的元素组成的新Map。
        val mapHero: MutableMap<Any?, Any?> = mutableMapOf<Any?, Any?>(
            Pair("name", "杨过"), Pair('C', 'A'), Pair(1, "第一名"), Pair("kunghu", "玄铁剑法"), Pair("age", 22)
        )
        var filterHero: Map<Any?, Any?> = mapHero.filterValues { it !is Number }
        println(mapHero)
        println(filterHero)

        filterHero = filterHero.filterKeys { it !is Number }
        println(filterHero)
    }

    fun mapOperator10() {
        //`filter(predicate: (Map.Entry<K, V>) -> Boolean): Map<K, V>`
        //返回过滤出满足Entry判断条件的元素组成的新Map。
        val mapHero: MutableMap<Any?, Any?> = mutableMapOf<Any?, Any?>(
            Pair("name", "杨过"),
            Pair('C', 'A'),
            Pair(1, "第一名"),
            Pair("kunghu", "玄铁剑法"),
            Pair("age", 22),
            Pair("wife", "小龙女"),
            Pair("car", "神雕大侠"),
            Pair("money", 9999.999)
        )

        val filterHero: Map<Any?, Any?> = mapHero.filter {
            val key = it.key
            val value = it.value
            //(key !is Number) || (key !is Char) || (value !is Number)
            //(key !is Number) || (key !is Char)
            (key is String) && (value !is Number)
        }
        println(mapHero)
        println(filterHero)
    }

    fun mapOperator11() {
        //`Iterable<Pair<K, V>>.toMap(destination: M): M`
        //把持有Pair的Iterable集合转换为Map。
        val listHero: MutableList<Pair<Any?, Any?>> = mutableListOf<Pair<Any?, Any?>>(
            Pair("name", "杨过"),
            Pair('C', 'A'),
            Pair(1, "第一名"),
            Pair("kunghu", "玄铁剑法"),
            Pair("age", 22),
            Pair("wife", "小龙女"),
            Pair("car", "神雕大侠"),
            Pair("money", 9999.999)
        )
        println(listHero)

        val heroMap: Map<Any?, Any?> = listHero.toMap()
        println(heroMap)
    }
}

/**
 * 重载函数
 */
private operator fun Any?.plus(s: String): Any {
    return this.toString() + s
}
