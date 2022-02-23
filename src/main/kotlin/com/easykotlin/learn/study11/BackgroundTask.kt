package com.easykotlin.learn.study11

/**
 * 后台任务
 */
class BackgroundTask {

    /**
     * 后台任务
     * @param callback 回调
     */
    fun doBackground(callback: ICallback) {
        val thread = Thread {
            try {
                Thread.sleep(5000)
                callback.onDone(true, "Sucess")
            } catch (e: Exception) {
                e.printStackTrace()
                callback.onDone(false, "Failed")
            }
        }
        thread.start()
        thread.join()
    }
}