package com.easykotlin.learn.study1

/**
 * 常量
 */
sealed class LoginDestination {
    class BrandDestination(val brand: String?, val error: Error?) : LoginDestination()
    class HomeDestination(val bundle: String?) : LoginDestination()
}
