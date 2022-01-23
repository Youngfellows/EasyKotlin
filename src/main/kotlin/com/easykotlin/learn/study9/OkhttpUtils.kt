package com.easykotlin.learn.study9

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.util.concurrent.TimeUnit

/**
 * kotlin中调用java
 * 单例
 */
object OkhttpUtils {

    /**
     * 获取okhttp的网络请求
     */
    fun get(url: String): String? {
        println("Start ...")
        var result: String? = ""
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.HOURS)
            .readTimeout(1, TimeUnit.HOURS)
            .writeTimeout(1, TimeUnit.HOURS)
            .build()

        val request: Request = Request.Builder()
            .url(url)
            .build()

        //发起同步网络请求
        val call: Call = okHttpClient.newCall(request)
        try {
            val response: Response = call.execute()
            result = response?.body()?.string()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        //println("result=${result}")
        return result
    }


    /**
     * 使用协程发起异步网络请求
     */
    fun asyncGet(url: String) = runBlocking {
        println("Start ...")
        var result: String? = ""
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.HOURS)
            .readTimeout(1, TimeUnit.HOURS)
            .writeTimeout(1, TimeUnit.HOURS)
            .build()

        val request: Request = Request.Builder()
            .url(url)
            .build()

        //发起同步网络请求
        val call: Call = okHttpClient.newCall(request)
        try {
            val response: Response = call.execute()
            result = response?.body()?.string()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        //println("result=${result}")
        result
    }


    /**
     * 使用协程发起异步网络请求
     */
    fun asyncGet2(url: String, onResponse: (result: String) -> Unit) = runBlocking {
        val job: Job = GlobalScope.launch {
            println("Start Async Get ...")
            var result: String? = ""
            val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.HOURS)
                .readTimeout(1, TimeUnit.HOURS)
                .writeTimeout(1, TimeUnit.HOURS)
                .build()

            val request: Request = Request.Builder()
                .url(url)
                .build()

            //发起同步网络请求
            val call: Call = okHttpClient.newCall(request)
            try {
                val response: Response = call.execute()
                result = response?.body()?.string()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            //回调请求结果
            onResponse.invoke(result!!)
        }
        //等待协程执行
        job.join()
        println("Now, Sucess ...")
    }

}