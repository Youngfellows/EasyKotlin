package com.easykotlin.learn.study2

import com.easykotlin.learn.study1.sum
import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * List集合类的基本运算函数
 */
class ListFunctionDemo {

    fun listFunction1() {
        //`any()`判断集合至少有一个元素,如果该集合至少有一个元素，返回`true`，否则返回`false`。
        val listFlower: List<String> = listOf<String>("水仙花", "栀子花", "玫瑰花", "荷花", "莲花", "君子兰")
        var any: Boolean = listFlower.any()
        println(any)

        var listCity: MutableList<String> = mutableListOf<String>();
        any = listCity.any()
        println(any)

        //集合中至少有一个元素匹配谓词函数参数`predicate: (T) -> Boolean`，返回true，否则返回false
        any = listFlower.any { it.contains("梅花") }
        println(any)

        any = listFlower.any() { it.contains("玫瑰") }
        println(any)
    }

    fun listFunction2() {
        //all(predicate: (T) -> Boolean) 判断集合中的元素是否都满足条件
        //当且仅当该集合中所有元素都满足条件时，返回true；否则都返回false
        val listFlower: MutableList<String> = mutableListOf<String>("水仙花", "栀子花", "玫瑰花", "荷花", "莲花", "兰花")
        var isAll: Boolean = listFlower.all { it.contains("花") }
        println(listFlower)
        println("isAll=${isAll}")

        listFlower.add("君子兰")
        println(listFlower)
        isAll = listFlower.all { it.contains("花") }
        println("isAll=${isAll}")
    }

    fun listFunction3() {
        //如果该集合没有任何元素，返回true，否则返回false。
        val listCity: MutableList<String> = mutableListOf<String>()
        var isNone: Boolean = listCity.none()
        println(listCity)
        println("isNone=${isNone}")

        listCity.add("天津")
        println(listCity)
        isNone = listCity.none()
        println("isNone=${isNone}")

        listCity.add("望京")
        listCity.add("北京")
        listCity.add("成都")
        println(listCity)

        //none(predicate: (T) -> Boolean)判断集合中所有元素都不满足条件
        //当且仅当集合中所有元素都不满足条件时返回true，否则返回false
        isNone = listCity.none { it.contains("京") }
        println("isNone=${isNone}")

        isNone = listCity.none { it.contains("州") }
        println("isNone=${isNone}")
    }

    fun listFunction4() {
        //count() 计算集合中元素的个数
        val listAnimal: List<String> = listOf<String>("鸭子", "小狗", "小猫", "小猪")
        var count: Int = listAnimal.count()
        println(listAnimal)
        println("count=${count}")

        //count(predicate: (T) -> Boolean) 计算集合中满足条件的元素的个数
        val listCity: MutableList<String> =
            mutableListOf<String>("武汉", "北京", "南京", "广州", "梧州", "钦州", "柳州", "扬州", "大庆", "大连", "大理")
        println(listCity)
        count = listCity.count { it.contains("京") }
        println("count=${count}")

        count = listCity.count { it.contains("州") }
        println("count=${count}")

        count = listCity.count { it.contains("津") }
        println("count=${count}")
    }

    fun listFunction5() {
        //reduce从第一项到最后一项进行累计运算
        val listLove: List<String> = listOf<String>("我们", "都爱", "摸鱼")
        println(listLove)
        val reduce: String = listLove.reduce() { total, next ->
            println("total=${total},next=${next}")
            total + next
        }
        println(reduce)

        //reduceRight从最后一项到第一项进行累计运算
        val reduceRight: String = listLove.reduceRight() { pre, total ->
            println("total=${total},pre=${pre}")
            pre + total
        }
        println(reduceRight)

        //fold(initial: R, operation: (acc: R, T) -> R): R 带初始值的reduce
        val fold: String = listLove.fold("在深圳的") { total, next ->
            total + next
        }
        println(fold)

        val foldRight: String = listLove.foldRight("在天津的时候") { pre, total ->
            pre + total
        }
        println(foldRight)
    }

    fun listFunction6() {
        //max 、min 查询最大、最小的元素，空集则返回null
        val listFruit: List<String> = listOf<String>("apple", "mango", "banana", "orange", "cherry")
        var max: String? = listFruit.max()
        println(max)

        val min: String? = listFruit.min()
        println(min)

        // maxBy(selector: (T) -> R): T?
        // minBy(selector: (T) -> R): T?
        // 获取函数映射结果的最大值、最小值对应的那个元素的值，如果没有则返回null
        val maxBy: String? = listFruit.maxBy { it.startsWith("man") }
        println(maxBy)

        var minBy: String? = listFruit.minBy {
            it.endsWith("e")
        }
        println("minBy=${minBy}")
        val a: Boolean = true
        val b: Boolean = false
        val result: Boolean = a > b
        println("true>false:${result}")

        minBy = listFruit.minBy { it.contains("an") }
        println("minBy=${minBy}")

        //sumBy(selector: (T) -> Int): Int 获取函数映射值的总和
        //可以看出，这个sumBy函数算子，累加器sum初始值为0，返回值是Int。
        //它的入参selector是一个函数类型(T) -> Int，也就是说这个selector也是返回Int类型的函数。
        var sumBy: Int = listFruit.sumBy {
            val indexOf = listFruit.indexOf(it)
            indexOf * indexOf
        }
        println(sumBy)

        val listNumber: List<Int> = listOf<Int>(1, 2, 3, 4, 5)
        sumBy = listNumber.sumBy { it }
        println(sumBy)

        sumBy = listNumber.sumBy { it * it + 12 }
        println(sumBy)
    }
}