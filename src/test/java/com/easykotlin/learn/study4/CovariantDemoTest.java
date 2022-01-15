package com.easykotlin.learn.study4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CovariantDemoTest {

    /**
     * 创建对象
     */
    private CovariantDemo covariantDemo = new CovariantDemo();

    @Test
    public void testCovariant() {
        covariantDemo.covariant();
    }

    @Test
    public void testContravariant() {
        covariantDemo.contravariant();
    }
}
