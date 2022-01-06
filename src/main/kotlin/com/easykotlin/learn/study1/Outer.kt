package com.easykotlin.learn.study1

/**
 * 如果 this 没有限定符，它指的是最内层的包含它的作用域。如果我们想要引用其他作用域中的 this，可以使用 this@label 标签。
 */
class Outer {
    val oh = "哦耶"

    /**
     * 内部类
     */
    inner class Inner {

        /**
         * 内部类函数
         */
        fun myFun() {
            val outer = this@Outer
            val inner = this@Inner
            val pthis = this
            val oh_ = this@Outer.oh
            println("outer=${outer}")
            println("inner=${inner}")
            println("pthis=${pthis}")
            println(oh_)

            /**
             * 如果 this 没有限定符，它指的是最内层的包含它的作用域。
             */
            val myFunc = hello@ fun String.(): String {
                return "d1${this}"
            }
            println("abc".myFunc())

            val myFunc1 = { s: String ->
                println("da${this}")
            }
            myFunc1
        }


    }
}