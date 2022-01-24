package com.easykotlin.learn.study10

import java.util.regex.Matcher

/**
 * Kotlin中使用正则表达式
 */
class KotlinRegex {

    /**
     *  构造 Regex 表达式
     */
    fun createRegex() {
        val regex1: Regex = Regex("[a-z]+")
        val regex2: Regex = Regex("[1-9]+", RegexOption.IGNORE_CASE)
    }

    /**
     * 使用 String 的 toRegex 扩展函数
     */
    fun createRegex2() {
        val toRegex: Regex = "[A-Z]+".toRegex()
    }

    /**
     * 输入字符串全部匹配正则表达式返回 true , 否则返回 false
     */
    fun matchesDemo() {
        val regex: Regex = Regex("[a-z]+")
        var input: String = "ShenZhen"
        var isMatch = regex.matches(input)
        println("isMatch=${isMatch}")

        input = "beijing"
        isMatch = regex.matches(input)
        println("isMatch=${isMatch}")
    }

    /**
     * 输入字符串中至少有一个匹配就返回true，没有一个匹配就返回false
     */
    fun containsMatchInDemo() {
        val regex: Regex = Regex("[0-9]+")
        var input: String = "012Ab&"
        var matchIn = regex.containsMatchIn(input)
        println("matchIn=${matchIn}")

        input = "xxAS&&@@@你好"
        matchIn = regex.containsMatchIn(input)
        println("matchIn=${matchIn}")
    }

    /**
     * 输入字符串全部匹配正则表达式返回 一个MatcherMatchResult对象，否则返回 null
     */
    fun matchEntireDemo() {
        val regex: Regex = Regex("[0-9]+")
        var phoneNo: String = "15998683822"
        var entire = regex.matchEntire(phoneNo)
        //MatcherMatchResult的value熟悉来获得匹配的值
        var value = entire?.value
        println("value:${value}")

        phoneNo = "136-9984-8214"
        entire = regex.matchEntire(phoneNo)
        value = entire?.value
        println("value=${value}")
    }

    /**
     * 把输入字符串中匹配的部分替换成replacement的内容
     */
    fun replaceDemo() {
        val regex: Regex = Regex("[0-9]+")
        var input: String = "x12A4xwx777WxyZ"
        val replacement: String = "深圳"
        val replace = regex.replace(input, replacement)
        println(replace)
    }

    /**
     * 把输入字符串中匹配到的值，用函数 transform映射之后的新值替换
     */
    fun replaceDemo2() {
        val regex: Regex = Regex("[0-9]+")
        var input: String = "x12A4xwx783WxyZ"
        val replace = regex.replace(input) {
            //it.value.plus(it.value)
            (it.value.toInt() + it.value.toInt()).toString()
        }
        println(replace)
    }

    /**
     * 返回输入字符串中第一个匹配的MatcherMatchResult对象
     */
    fun findDemo() {
        val regex: Regex = Regex("[0-9]+")
        val input: String = "Abc123DEf456xyW796swtunp"
        val matchResult: MatchResult? = regex.find(input)
        val value = matchResult?.value
        println(value)
    }

    /**
     * 返回输入字符串中所有匹配的值的MatchResult的序列
     */
    fun findAllDemo() {
        val regex: Regex = Regex("[0-9]+")
        val input: String = "Abc328DEf456xyW796swt653unp"
        val sequence = regex.findAll(input)
        sequence.iterator().forEach {
            val value = it.value
            println(value)
        }
    }

    /**
     * 使用 Java 正则表达式类
     */
    fun usingJavaRegex() {
        val regex: Regex = Regex("[0-9]+")
        val pattern = regex.toPattern()
        val input: String = "xyz123wspdf882&642!sds"
        val matcher: Matcher = pattern.matcher(input)
        while (matcher.find()) {
            val s = matcher.group()
            println(s)
        }
    }
}