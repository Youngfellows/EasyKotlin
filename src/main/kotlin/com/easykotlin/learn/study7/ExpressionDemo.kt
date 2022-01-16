package com.easykotlin.learn.study7

/**
 * 测试密封类
 */
class ExpressionDemo {

    /**
     * 使用密封类做条件判断
     */
    fun eval(expr: Expression): Double {
        val result: Double = when (expr) {
            is Expression.Unit -> 1.0
            is Expression.Const -> expr.number
            is Expression.Sum -> eval(expr.e1) + eval(expr.e2)
            is Expression.Multiply -> eval(expr.e1) * eval(expr.e2)
            Expression.NaN -> Double.NaN
        }
        return result
    }
}