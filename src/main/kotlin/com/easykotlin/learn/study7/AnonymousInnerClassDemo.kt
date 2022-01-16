package com.easykotlin.learn.study7

/**
 * 匿名内部类（Annonymous Inner Class）
 * 匿名内部类，就是没有名字的内部类。既然是内部类，那么它自然也是可以访问外部类的变量的。
 * 我们使用对象表达式创建一个匿名内部类实例
 */
class AnonymousInnerClassDemo {
    /**
     * 外部类成员
     */
    var isRunning: Boolean = false

    /**
     * 定义方法:跑
     */
    fun doRun(): Unit {
        println("doRun() ...")
        //使用对象表达式创建一个匿名内部类实例
        Thread(object : Runnable {
            override fun run() {
                println("doRun,isRunnint=${isRunning}")
                isRunning = !isRunning
                println("doRun,isRunnint=${isRunning}")
            }
        }).start()
    }

    /**
     * 如果对象是函数式 Java 接口，即具有单个抽象方法的 Java 接口的实例，例如上面的例子中的Runnable接口
     * 使用lambda表达式创建它
     */
    fun doStop() {
        println("doStop() ...")
        //var isRunning:Boolean = false
        Thread({
            //println("doStop,isRunning=${isRunning}")
            isRunning = !isRunning
            println("doStop,isRunning=${isRunning}")
        }).start()
    }

    fun doWait() {
        println("doWait() ...")
        //var isRunnint:Boolean = false
        val waitRunnable: Runnable = Runnable {
            //println("doWait,isRunning=${isRunning}")
            isRunning = !isRunning
            println("doWait,isRunning=${isRunning}")
        }
        Thread(waitRunnable).start()
    }

    fun doNotify() {
        println("doNotify() ...")
        //var isRunning:Boolean = false

        /**
         * 定义了一个函数类型,其实也是一个接口实现
         */
        val notifyRunnable: () -> Unit = {
            //println("doNotify,isRunning=${isRunning}")
            isRunning = !isRunning
            println("doNotify,isRunning=${isRunning}")
        }
        Thread(notifyRunnable).start()
    }

    fun doStart() {
        println("doStart() ...")
        //val isRunning: Boolean = false
        Thread() {
            //println("doStart,isRunning=${isRunning}")
            isRunning = !isRunning
            println("doStart,isRunning=${isRunning}")
        }.start()
    }

    fun doCreate() {
        println("doCreate() ...")
        Thread {
            isRunning = !isRunning
            println("doCreate,isRunning=${isRunning}")
        }.start()
    }
}