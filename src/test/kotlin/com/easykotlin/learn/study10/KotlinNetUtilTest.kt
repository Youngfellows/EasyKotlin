package com.easykotlin.learn.study10

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class KotlinNetUtilTest {

    @Test
    fun testGetUrlContent() {
        val url: String = "https://fanyi.baidu.com/"
        val content = KotlinNetUtil.getUrlContent(url)
        println(content)
    }

    @Test
    fun testGetUrlBytes() {
        val url: String = "https://fanyi.baidu.com/"
        val byteArray: ByteArray = KotlinNetUtil.getUrlBytes(url)
        byteArray.forEach {
            //println(it.toString())
            println(it)
        }
    }

    @Test
    fun testWriteUrlBytesTo() {
        val url: String = "http://n.sinaimg.cn/default/4_img/uplaod/3933d981/20170622/2fIE-fyhfxph6601959.jpg"
        val fileName: String = "./file/美女2.jpg"
        KotlinNetUtil.writeUrlBytesTo(url, fileName)
    }
}