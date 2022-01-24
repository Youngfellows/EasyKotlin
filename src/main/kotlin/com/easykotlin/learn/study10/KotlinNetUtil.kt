package com.easykotlin.learn.study10

import java.io.File
import java.net.URL

/**
 * Kotlin网络工具
 */
object KotlinNetUtil {

    /**
     * 根据 url 获取该 url 的响应
     */
    fun getUrlContent(url: String): String {
        return URL(url).readText(Charsets.UTF_8)
    }

    /**
     * 根据 url 获取该 url 响应比特数组函数
     */
    fun getUrlBytes(url: String): ByteArray {
        return URL(url).readBytes()
    }

    /**
     * 把 url 响应字节数组写入文件
     */
    fun writeUrlBytesTo(url: String, fileName: String) {
        val bytes = URL(url).readBytes()
        File(fileName).writeBytes(bytes)
    }
}