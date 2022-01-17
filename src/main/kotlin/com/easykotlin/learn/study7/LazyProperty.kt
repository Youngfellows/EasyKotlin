package com.easykotlin.learn.study7

/**
 * 懒加载属性委托 lazy
 */
class LazyProperty {

    /**
     * 懒加载属性1
     */
    val lazyProperty1 = lazy {
        println("lzay value 3")
        println("lzay value 2")
        println("lzay value 1")
        "最终返回的值^_^..."
    }


    /**
     *懒加载属性
     */
    fun lazyDemo1() {
        val lazyValue: String by lazyProperty1
        println(lazyValue)
        println(lazyValue)
    }

    /**
     *懒加载属性
     */
    fun lazyDemo2() {
        //默认情况下，对于 lazy 属性的求值是同步的（synchronized）, 下面两种写法是等价的
        val lazyValue: Int by lazy {
            println("lazy value 6")
            println("lazy value 5")
            println("lazy value 4")
            3
        }
        println(lazyValue)
        println(lazyValue)

        val lazyValue2: Double by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            println("lazy value 9")
            println("lazy value 8")
            println("lazy value 7")
            3.1415926
        }
        println(lazyValue2)
        println(lazyValue2)
    }

    fun lazyDemo3() {
        //如果初始化委托多个线程可以同时执行，不需要同步锁，使用LazyThreadSafetyMode.PUBLICATION
        val lazyVale: Pair<String, Any?> by lazy(LazyThreadSafetyMode.PUBLICATION) {
            println("lazy value 3")
            println("lazy value 2")
            println("lazy value 1")
            "name" to "小龙女"
        }
        println(lazyVale)
        println(lazyVale)
    }

    fun lazyDemo4() {
        //如果属性的初始化是单线程的，那么我们使用 LazyThreadSafetyMode.NONE 模式(性能最高)
        val lazyVale: MutableList<String> by lazy(LazyThreadSafetyMode.NONE) {
            println("lazy value 3")
            println("lazy value 2")
            println("lazy value 1")
            mutableListOf<String>("香蕉", "苹果", "草莓")
        }
        println(lazyVale)
        println(lazyVale)
    }
}