package com.easykotlin.learn.study9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class VarArgsDemo {

    /**
     * 测试可变参数
     */
    @Test
    public void testVarArgs() {
        String result = VarArgs.appendElement("apple", "banana", "orange");
        System.out.println(result);

        result = VarArgs.appendElement(1, 2, 3, "小龙女");
        System.out.println(result);

        result = VarArgs.appendElement(33, 22, 11, 985);
        System.out.println(result);
    }
}
