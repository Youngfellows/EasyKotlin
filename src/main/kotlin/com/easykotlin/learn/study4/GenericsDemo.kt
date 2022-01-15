package com.easykotlin.learn.study4

/**
 * 在 Java 泛型里，有通配符这种东西，我们要
 * 用? extends T指定类型参数的上限，
 * 用 ? super T指定类型参数的下限。
 * 而Kotlin 抛弃了这个东西，引用了生产者和消费者的概念。也就是我们前面讲到的PECS。
 * 生产者就是我们去读取数据的对象，消费者则是我们要写入数据的对象。
 */
class GenericsDemo {
    //我们用代码示例简单讲解一下
    /* public static <T> void copy(List<? super T> dest, List<? extends T> src) {
         ...
         ListIterator<? super T> di = dest.listIterator();   // in T, 写入dest数据
         ListIterator<? extends T> si = src.listIterator();   // out T， 读取src数据
         ...
     }
        List<? super T> dest是消费数据的对象，这些数据会写入到该对象中，这些数据该对象被“吃掉”了（Kotlin中叫in T）。
        List<? extends T> src是生产提供数据的对象。这些数据哪里来的呢？就是通过src读取获得的（Kotlin中叫out T）。
    */

    //在Kotlin中，我们把那些只能保证读取数据时类型安全的对象叫做生产者，用 out T标记；
    //把那些只能保证写入数据安全时类型安全的对象叫做消费者，用 in T标记。
    //如果你觉得太晦涩难懂，就这么记吧：
    //out T 等价于 ? extends T
    //in T  等价于 ? super T
    //此外, 还有 * 等价于?

    fun demo(str: Source<String>): Source<Any> {
        val obj: Source<Any> = str//合法的类型协变
        return obj
    }
}

interface Source<out T> {
    fun <T> next(): T
}

