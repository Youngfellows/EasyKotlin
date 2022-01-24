package com.easykotlin.learn.study10

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * 扩展 String 的 execute() 函数
 */
fun String.execute(): Process {
    val runtime = Runtime.getRuntime()
    return runtime.exec(this)
}

/**
 * 给 Process 类扩展一个 text函数，输出shell命令执行结果
 */
fun Process.text(): String {
    var output: String = ""
    //输出 Shell 执行的结果
    val inputStream: InputStream = this.inputStream
    val isr: InputStreamReader = InputStreamReader(inputStream)
    val reader: BufferedReader = BufferedReader(isr)
    var line: String? = ""
    line = reader.readLine()
    while (line != null) {
        output += line + "\n"
        try {
            line = reader.readLine()
        } catch (e: Exception) {
            line = null
        }
    }
    return output
}