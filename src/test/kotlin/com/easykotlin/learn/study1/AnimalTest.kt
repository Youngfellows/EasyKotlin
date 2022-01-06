package com.easykotlin.learn.study1

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AnimalTest {

    @Test
    fun testWhatIsThis() {
        val animal: Animal = Animal()
        animal.whatIsThis()
    }
}