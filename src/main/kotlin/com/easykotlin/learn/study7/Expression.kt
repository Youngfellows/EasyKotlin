package com.easykotlin.learn.study7

/**
 * 密封类: 表达式
 */
sealed class Expression {
    //sealed类是枚举类的扩展：枚举类型的值集合也是受限的，但每个枚举常量只存在一个实例，
    //而密封类的一个子类可以有可包含状态的多个实例。
    //要声明一个密封类，需要在类名前面添加 sealed 修饰符。
    //密封类的所有子类都必须与密封类在同一个文件中声明（在 Kotlin 1.1 之前， 该规则更加严格：子类必须嵌套在密封类声明的内部）
    //使用密封类的主要场景是在使用 when 表达式的时候，能够验证语句覆盖了所有情况，而无需再添加一个 else 子句

    /**
     * 密封类子类: 单位
     */
    class Unit : Expression() {

    }

    /**
     * 密封类子类: 常量
     */
    data class Const(val number: Double) : Expression() {

    }

    /**
     * 密封类子类: 求和
     */
    data class Sum(val e1: Expression, val e2: Expression) : Expression() {

    }

    /**
     * 密封类子类: 相乘
     */
    data class Multiply(val e1: Expression, val e2: Expression) : Expression() {

    }

    /**
     * 密封类子类: 单例对象NaN
     */
    object NaN : Expression() {

    }
}