package com.easykotlin.learn.study1

import java.io.Serializable

data class Error(val code: Int, val label: String) : Serializable {
    override fun toString(): String = "$code | $label"
}