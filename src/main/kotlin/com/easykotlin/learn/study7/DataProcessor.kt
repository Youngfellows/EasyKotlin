package com.easykotlin.learn.study7

import java.io.File

/**
 *  嵌套（Nested）object对象,其实就是一个单例
 *  只能通过类的名称来直接访问object，不能使用对象实例引用
 */
object DataProcessor {
    /**
     * 静态函数
     */
    fun process() {
        println("Process Data ...")
    }

    /**
     * 嵌套（Nested）object对象
     */
    object FileUtils {

        /**
         * 静态常量
         */
        val userHome = "C:\\Users\\AIJACK\\Desktop\\png\\test"

        /**
         * 静态函数
         */
        fun getFileContent(file: String): String? {
            var contemt: String? = null
            val f: File = File(file)
            f.forEachLine { contemt = contemt + it + "\n" }
            return contemt
        }
    }
}