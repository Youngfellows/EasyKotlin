package com.easykotlin.learn.study11

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TestRange {

    @Test
    fun testRangeAnimal() {
        val intRange = 0 until 30
        val animals: List<Animal> = intRange.map {
            Animal(name = "test$it", age = it)
        }
        for (animal in animals) {
            println(animal.toString())
        }
    }

    data class Animal(val name: String, val age: Int) {
        override fun toString(): String {
            return "name=$name,age=$age"
        }
    }
}