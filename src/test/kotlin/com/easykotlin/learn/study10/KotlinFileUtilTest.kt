package com.easykotlin.learn.study10

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class KotlinFileUtilTest {

    /**
     *文件
     */
    val fileName: String = "./file/唐诗三百首.txt"

    @Test
    fun testGetFileContent() {
        val content = KotlinFileUtil.getFileContent(fileName)
        println(content)
    }

    @Test
    fun testGetFileLines() {
        val lines: List<String> = KotlinFileUtil.getFileLines(fileName)
        lines.forEach() {
            println(it)
        }
        println("文件行数:${lines.size}")
    }

    @Test
    fun testGetFileBytes() {
        val fileName: String = "./file/test.data"
        val fileBytes: ByteArray = KotlinFileUtil.getFileBytes(fileName)
        fileBytes.forEach {
            println(it)
        }
    }

    @Test
    fun testWriteFile() {
        val text: String = KotlinFileUtil.getFileContent(fileName)
        val destFileName: String = "./file/唐诗.txt"
        KotlinFileUtil.writeFile(text, destFileName)
    }

    @Test
    fun testAppendFile() {
        val text: String = KotlinFileUtil.getFileContent(fileName)
        val destFileName: String = "./file/新唐诗.txt"
        KotlinFileUtil.appendFile(text, destFileName)
    }

    @Test
    fun testFirstLineAppendFile() {
        val text: String = KotlinFileUtil.getFileContent(fileName)
        val destFileName: String = "./file/旧唐诗.txt"
        KotlinFileUtil.firstLineAppendFile(text, destFileName)
    }

    @Test
    fun testTraverseFileTree() {
        KotlinFileUtil.traverseFileTree("./file")
    }

    @Test
    fun testGetFileIterator() {
        val iterator = KotlinFileUtil.getFileIterator("./file")
        iterator.forEach {
            //println("==============================================")
            val absolutePath = it.absolutePath
            println(absolutePath)
            //val content = KotlinFileUtil.getFileContent(absolutePath)
            //println(content)
        }
    }

    @Test
    fun testGetFileSequenceBy() {
        val sequence1 = KotlinFileUtil.getFileSequenceBy(".") {
            it.isDirectory//只过滤文件夹
        }
        sequence1.forEach {
            println("sequence1,${it.absoluteFile}")
        }

        val sequence2 = KotlinFileUtil.getFileSequenceBy(".") {
            it.isFile //只过滤文件夹
        }
        sequence2.forEach {
            println("sequence2,${it.absoluteFile}")
        }

        val sequence3 = KotlinFileUtil.getFileSequenceBy(".") {
            it.extension == "kt"
        }
        sequence3.forEach {
            println("sequence3,${it.absoluteFile}")
        }

        val sequence4 = KotlinFileUtil.getFileSequenceBy(".") {
            it.extension == "java"
        }
        sequence4.forEach {
            println("sequence4,${it.absoluteFile}")
        }
    }

}