package com.easykotlin.learn.study1

class WhenAdvDemo {

    /**
     * 测试when表达式
     * @param state
     */
    fun testLogin(state: LoginDestination?) {
        when (state) {
            is LoginDestination.BrandDestination -> {
                println("跳转到品牌页...")
                when (state?.error?.code) {
                    SdkConst.ERROR_CODE_1 -> {
                        println(" SdkConst.ERROR_CODE_1,error=${state.error}")
                    }
                    SdkConst.ERROR_CODE_2 -> {
                        println(" SdkConst.ERROR_CODE_2,error=${state.error}")
                    }
                    SdkConst.ERROR_CODE_3 -> {
                        println(" SdkConst.ERROR_CODE_3,error=${state.error}")
                    }
                    else -> {
                        println("Other,error=${state.error}")
                    }
                }
            }
            is LoginDestination.HomeDestination -> {
                println("跳转到home主页")
            }
        }
    }
}