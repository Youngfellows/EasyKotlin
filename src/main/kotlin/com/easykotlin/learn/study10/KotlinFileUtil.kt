package com.easykotlin.learn.study10

import java.io.File

/**
 * Kotlin文件操作工具
 */
object KotlinFileUtil {

    /**
     *  获取文件全部内容字符串
     */
    fun getFileContent(fileName: String): String {
        val file: File = File(fileName)
        return file.readText(Charsets.UTF_8)
    }

    /**
     * 获取文件每一行内容，存入一个 List 中
     */
    fun getFileLines(fileName: String): List<String> {
        val file = File(fileName)
        return file.readLines(Charsets.UTF_8)
    }

    /**
     * 获取文件比特流数组
     */
    fun getFileBytes(fileName: String): ByteArray {
        val file: File = File(fileName)
        return file.readBytes()
    }

    /**
     * 覆盖写文件
     */
    fun writeFile(text: String, destFile: String) {
        val file = File(destFile)
        if (!file.exists()) {
            //创建文件
            file.createNewFile()
        }
        file.writeText(text, Charsets.UTF_8)
    }

    /**
     * 末尾追加写文件
     */
    fun appendFile(text: String, destFile: String) {
        val file: File = File(destFile)
        if (!file.exists()) {
            file.createNewFile()
        }
        file.appendText(text, Charsets.UTF_8)
    }

    /**
     *  首行插入写文件
     */
    fun firstLineAppendFile(text: String, destFile: String) {
        val file: File = File(destFile)
        if (!file.exists()) {
            file.createNewFile()
        }
        //先读取旧文件
        val lines: List<String> = getFileLines(destFile)
        val newLines = ArrayList<String>(lines.size + 1)
        //首行插入
        newLines.add(text)
        //再插入其他的
        lines.forEach() {
            newLines.add(it)
        }

        val nexText = newLines.joinToString(separator = "\n") {
            it
        }
        file.writeText(nexText)
    }

    /**
     * 遍历了指定文件夹下的所有文件
     */
    fun traverseFileTree(fileName: String) {
        val file: File = File(fileName)
        val fileTreeWalk = file.walk()
        fileTreeWalk.iterator().forEach {
            val absoluteFile = it.absoluteFile
            println(absoluteFile)
        }
    }

    /**
     *  遍历当前文件下面所有子目录文件，存入一个 Iterator<File> 中
     */
    fun getFileIterator(fileName: String): Iterator<File> {
        val file = File(fileName)
        val fileTreeWalk = file.walk()
        return fileTreeWalk.iterator()
    }

    /**
     * 遍历当前文件下面所有子目录文件，根据过滤条件过滤，并把结果存入一个 Sequence<File> 中
     */
    fun getFileSequenceBy(fileName: String, p: (File) -> Boolean): Sequence<File> {
        val file: File = File(fileName)
        return file.walk().filter(p)
    }
}