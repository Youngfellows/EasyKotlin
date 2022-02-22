package com.easykotlin.learn.study11

/**
 * 小孩
 * @property mother 妈妈
 */
class Kid(private val mother: Mother) {

    /**
     * 钱
     */
    var money: Double = 22.33
        private set

    /**
     * 要钱
     */
    fun wantMoney() {
        mother.inform(money)//通知
        money += mother.giveMoney()//给钱
    }
}