package com.easykotlin.learn.study11

/**
 * 消费者
 */
class Consumer(val task: BackgroundTask) : IPrinter {

    /**
     * 调用后台线程执行任务
     */
    fun doBackgroundTask() {
        printStarting()
        task.doBackground(object : ICallback {
            override fun onDone(isSucess: Boolean, message: String) {
                when (isSucess) {
                    true -> {
                        println(message)
                        printSuccess()
                    }
                    else -> {
                        println(message)
                        printFailed()
                    }
                }
            }
        })
    }

    override fun printStarting() {
        println("Starting")
    }

    override fun printSuccess() {
        println("Successful")
    }

    override fun printFailed() {
        println("Failed")
    }

}