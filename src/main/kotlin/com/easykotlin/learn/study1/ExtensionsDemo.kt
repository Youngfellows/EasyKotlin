package com.easykotlin.learn.study1

/**
 * 函数扩展和属性扩展(Extensions)
 **/

/**
 * 扩展属性: 获取数组的最后元素索引
 */
val <T> List<T>.lastInde: Int
    get() = size - 1

/**
 * 扩展属性: 获取数组中间元素的索引
 */
val <T> List<T>.middleIndex: Int get() = size / 2

/**
 * 扩展函数: 交互数组中的元素
 */
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * 扩展函数: 交互数组中的元素,使用泛型
 */
fun <T> MutableList<T>.mSwap(index1: Int, index2: Int) {
    val tempt = this[index1]
    this[index1] = this[index2]
    this[index2] = tempt
}

/**
 * 扩展函数: 判断字符串是否不为空
 */
fun String.notEmpty(): Boolean {
    return !this.isEmpty()
}

/**
 * 测试扩展函数和扩展属性
 */
class ExtensionsDemo {

    /**
     * 使用扩展
     */
    fun useExtensions() {
        val address = "北京故宫博物院"
        val notEmpty = address.notEmpty()
        println("notEmpty=${notEmpty}")

        val mList1 = mutableListOf<Int>(1, 2, 3, 4, 5, 6)
        println("before swap")
        println(mList1)
        mList1.swap(2, 3)
        println("after swap")
        println(mList1)

        val mList2 = mutableListOf<Int>(1, 2, 3, 4, 5, 6)
        println("before swap")
        println(mList2)
        mList2.mSwap(2, 3)
        println("after swap")
        println(mList2)

        val mList3 = mutableListOf<String>("北京", "武汉", "西安", "南京", "成都")
        println("before swap")
        println(mList3)
        mList3.mSwap(1, 4)
        println("after swap")
        println(mList3)
    }

    /**
     * 内部类
     */
    inner class Inner {
        fun useExtensions() {
            val fruits = mutableListOf<String>("苹果", "香蕉", "葡萄", "西瓜", "猕猴桃")
            val lastIndex = fruits.lastInde
            val middleIndex = fruits.middleIndex
            println("middleIndex:${middleIndex},lastIndex:${lastIndex}")
        }
    }
}