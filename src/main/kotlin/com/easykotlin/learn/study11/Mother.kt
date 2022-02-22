package com.easykotlin.learn.study11

/**
 * 妈妈
 */
class Mother {

    /**
     * 给钱
     * @return
     */
    fun giveMoney(): Double {
        return 15.5
    }

    /**
     * 通知妈妈
     * @param money 现在的钱
     */
    fun inform(money: Double = 0.0) {
        println("妈妈我现在有${money}元,我要向你拿钱...")
    }
}