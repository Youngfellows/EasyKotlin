package com.easykotlin.learn.study4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RawArrayListTest {

    @Test
    public void testRawArrayList() {
        RawArrayList rawArrayList = new RawArrayList(5);
        rawArrayList.add(0, 3.1415926);
        rawArrayList.add(1, "深圳");
        rawArrayList.add(2, 'A');
        rawArrayList.add(3, 8888);
        rawArrayList.add(4, new Animal("小动物", 3));

        //获取元素,使用的时候各自作强制类型转换
        Double e1 = (Double) rawArrayList.get(0);
        System.out.println("ele=" + e1);

        String e2 = (String) rawArrayList.get(1);
        System.out.println("ele=" + e2);

        char e3 = (char) rawArrayList.get(2);
        System.out.println("ele=" + e3);

        int e4 = (int) rawArrayList.get(3);
        System.out.println("ele=" + e4);

        Animal e5 = (Animal) rawArrayList.get(4);
        System.out.println("ele=" + e5);
    }
}
