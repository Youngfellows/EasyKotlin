package com.easykotlin.learn.study10

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class KotlinRegexTest {
    /**
     * 创建对象
     */
    val kotlinRegex: KotlinRegex = KotlinRegex()

    @Test
    fun testMatchesDemo() {
        kotlinRegex.matchesDemo()
    }

    @Test
    fun testContainsMatchInDemo() {
        kotlinRegex.containsMatchInDemo()
    }

    @Test
    fun testMatchEntireDemo() {
        kotlinRegex.matchEntireDemo()
    }

    @Test
    fun testReplaceDemo() {
        kotlinRegex.replaceDemo()
    }

    @Test
    fun testReplaceDemo2() {
        kotlinRegex.replaceDemo2()
    }

    @Test
    fun testFindDemo() {
        kotlinRegex.findDemo()
    }

    @Test
    fun testFindAll() {
        kotlinRegex.findAllDemo()
    }

    @Test
    fun testUsingJavaRegex() {
        kotlinRegex.usingJavaRegex()
    }

    @Test
    fun testCountSummary() {
        //网络请求
        val url: String = "https://www.qq.com/"
        val content = KotlinNetUtil.getUrlContent(url)

        //保存到文件
        val fileName: String = "./file/腾讯新闻.txt"
        KotlinFileUtil.writeFile(content, fileName)

        //读取文件内容
        val newsContent: String = KotlinFileUtil.getFileContent(fileName)

        //统计
        val summary = countSummary(newsContent)
        summary.entries.forEach() {
            val key = it.key
            val value = it.value
            println("${key}:${value}")
        }
    }

    /**
     * 统计
     */
    fun countSummary(content: String): Map<String, Any?> {
        val countNumber = CountSummary.countNumber(content)
        val countLetter = CountSummary.countLetter(content)
        val countWord = CountSummary.countWord(content)
        val countSpace = CountSummary.countSpace(content)
        val countChineseCharacters = CountSummary.countChineseCharacters(content)
        val countEnglishWordFreq = CountSummary.countEnglishWordFreq(content, 3)

        var map = hashMapOf<String, Any?>()
        map.put("countNumber", countNumber)
        map.put("countLetter", countLetter)
        map.put("countWord", countWord)
        map.put("countSpace", countSpace)
        map.put("countChineseCharacters", countChineseCharacters)
        map.put("countEnglishWordFreq", countEnglishWordFreq)
        return map
    }
}