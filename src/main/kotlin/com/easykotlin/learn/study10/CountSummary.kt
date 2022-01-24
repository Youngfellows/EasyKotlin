package com.easykotlin.learn.study10

import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.collections.ArrayList

/**
 * 单例,静态的,数字统计
 */
object CountSummary {

    /**
     * 统计数字数
     */
    fun countNumber(str: String): Int {
        var count: Int = 0
        //val p: Pattern = Pattern.compile("\\d")//数字正则
        val p: Pattern = Pattern.compile("[0-9]")//数字正则
        val matcher: Matcher = p.matcher(str)
        while (matcher.find()) {
            count++
        }
        return count
    }

    /**
     *  统计字母数
     */
    fun countLetter(str: String): Int {
        var count: Int = 0
        val p: Pattern = Pattern.compile("[a-zA-Z]")
        val matcher = p.matcher(str)
        while (matcher.find()) {
            count++
        }
        return count
    }

    /**
     * 统计英文单词数
     */
    fun countWord(str: String): Int {
        var count: Int = 0
        val p: Pattern = Pattern.compile("\\w")//英文单词
        val matcher = p.matcher(str)
        while (matcher.find()) {
            count++
        }
        return count
    }

    /**
     * 统计空格数
     * @param str
     * *
     * @return
     */
    fun countSpace(str: String): Int {
        var count = 0
        val p = Pattern.compile("\\s")
        val m = p.matcher(str)
        while (m.find()) {
            count++
        }
        return count
    }

    /**
     * 统计汉字数
     * @param str
     * @return
     */
    fun countChineseCharacters(str: String): List<MutableMap.MutableEntry<String, Int>> {
        return countChineseWordFreq(str, 1)
    }


    /**
     * 统计英文词频
     * @wordsNum 表示几个词
     *
     * @return
     */
    fun countEnglishWordFreq(str: String, wordsNum: Int): List<MutableMap.MutableEntry<String, Int>> {
        //val str = getFileContent(filename)
        // \b[\w+]+\b\s
        var englishWordRegex = ""
        for (i in 1..wordsNum) {
            englishWordRegex += "\\b[\\w+]+\\b\\s"
        }
        return doWordCount(englishWordRegex, str)
    }


    /**
     * 统计汉字词频
     * @wordsNum 表示几个字的词
     *
     * @return
     */
    fun countChineseWordFreq(str: String, wordsNum: Int): List<MutableMap.MutableEntry<String, Int>> {
        //val str = getFileContent(filename)
        val wordRegex = "$[\\u4e00-\\u9fa5]{${wordsNum}}"
        return doWordCount(wordRegex, str)
    }

    private fun doWordCount(wordRegex: String, str: String): List<MutableMap.MutableEntry<String, Int>> {
        val p = Pattern.compile(wordRegex)
        val m = p.matcher(str)
        var startIndex = 0
        val map = hashMapOf<String, Int>()
        while (m.find(startIndex)) {
            startIndex = m.start()
            var endIndex = m.end()
            val word = str.substring(startIndex, endIndex)
            if (!map.containsKey(word)) {
                map.put(word, 1)
            } else {
                map[word]?.let { map.put(word, it + 1) }
            }
            startIndex++
        }

        // 根据 key 排序
        val entrySetList = ArrayList(map.entries)
        entrySetList.sortWith(Comparator { e1, e2 ->
            e2.value.compareTo(e1.value)
        })
        //ollections.sort(entrySetList, { e1, e2 ->
        //     e2.value.compareTo(e1.value)
        // })
        return entrySetList
    }

}