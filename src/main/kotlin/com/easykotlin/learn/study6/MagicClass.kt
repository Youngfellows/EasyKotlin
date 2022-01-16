package com.easykotlin.learn.study6

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.FIELD,
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.TYPE,
    AnnotationTarget.TYPEALIAS,
    AnnotationTarget.TYPE_PARAMETER,
    AnnotationTarget.VALUE_PARAMETER
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
@Repeatable
annotation class MagicClass {
    /**
     * 声明注解
     *
     * 通过向注解类添加元注解(meta-annotation)的方法来指定其他属性：
     *  - @Target ：指定这个注解可被用于哪些元素(类, 函数, 属性, 表达式, 等等.);
     *  - @Retention ：指定这个注解的信息是否被保存到编译后的 class 文件中, 以及在运行时是否可以通过反
     *  射访问到它；
     *  - @Repeatable：允许在单个元素上多次使用同一个注解；
     *  - @MustBeDocumented ： 表示这个注解是公开 API 的一部分, 在自动产生的 API 文档的类或者函数签名中, 应该包含这个注解的信息。
     */

}