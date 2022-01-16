package com.easykotlin.learn.study7

/**
 * 嵌套类（Nested Class）
 */
class NestedClassesDemo {

    /**
     * 外部类
     */
    class Outer {
        private val zero: Int = 0
        val one: Int = 1

        /**
         * 嵌套的内部类: 可以访问外部类成员
         */
        inner class Nested {

            fun getTwo(): Int {
                return 2
            }

            /**
             * 访问外部类的成员和属性
             */
            fun accessOuter() {
                //我们在Nested类中，访问不到Outer类中的变量zero，one。
                //如果想要访问到，我们只需要在Nested类前面加上inner关键字修饰，表明这是一个嵌套的内部类。
                //内部类会带有一个对外部类的对象的引用
                println("引用外部类成员:$zero")
                println("引用外部类成员:$one")
            }
        }

        /**
         * 普通的嵌套类，没有持有外部类的引用，所以是无法访问外部类的变量的
         */
        class Nested1 {

            val two: Int = 2

            class Nested2 {

                val three: Int = 3

                fun getFour(): Int {
                    return 4
                }

                fun accessOuter1() {
                    //我们在Nested类中，访问不到Outer类中的变量two。
                    //如果想要访问到，我们只需要在Nested类前面加上inner关键字修饰，表明这是一个嵌套的内部类。
                    //内部类会带有一个对外部类的对象的引用
                    //println("引用外部类成员:$two")
                }
            }
        }
    }
}