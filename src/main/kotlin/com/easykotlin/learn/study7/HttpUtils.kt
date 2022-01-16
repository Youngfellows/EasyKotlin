package com.easykotlin.learn.study7

import okhttp3.*
import java.io.IOException

/**
 * OkHttp工具类
 */
object HttpUtils {

    /**
     * 创建OkhttpClient
     */
    val client = OkHttpClient()

    /**
     * 同步请求
     */
    @Throws(Exception::class)
    fun getSync(url: String): String? {
        val request = Request.Builder()
            .url(url)
            .build()

        val response = client.newCall(request).execute()
        if (!response.isSuccessful()) throw IOException("Unexpected code $response")

        val responseHeaders = response.headers()
        for (i in 0..responseHeaders.size() - 1) {
            println(responseHeaders.name(i) + ": " + responseHeaders.value(i))
        }
        return response.body()?.string()
    }

    /**
     * 异步请求
     */
    @Throws(Exception::class)
    fun getAsync(url: String, onSucess: (response: String) -> Unit, onFailure: (error: String) -> Unit) {
        var result: String? = ""

        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException?) {
                e?.printStackTrace()
                //回调
                onFailure(e?.message.toString())
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                println("on response ...")
                if (!response.isSuccessful()) throw IOException("Unexpected code " + response)

                val responseHeaders = response.headers()
                for (i in 0..responseHeaders.size() - 1) {
                    println(responseHeaders.name(i) + ": " + responseHeaders.value(i))
                }
                result = response.body()?.string()
                //println(result)
                //回调
                onSucess(result!!)
            }
        })
    }
}
