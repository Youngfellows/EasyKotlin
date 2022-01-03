package com.easykotlin.learn.study1

import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {
    println("hello,kotlin ...")
    val dateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date: Date = Date()
    val dateTime: String = dateFormat.format(date)
    println("dateTime=${dateTime}")
}