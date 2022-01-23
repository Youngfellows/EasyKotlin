package com.easykotlin.learn.study9;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OkhttpUtilsDemo {

    @Test
    public void testGet() {
        //java中调用kotlin代码
        //调用kotlin的单例对象
        String url = "https://www.baidu.com/";
        String result = OkhttpUtils.INSTANCE.get(url);
        System.out.println(result);
    }

    @Test
    public void testAsyncGet() {
        //java中调用kotlin代码
        //调用kotlin的单例对象
        String url = "https://www.baidu.com/";
        String result = OkhttpUtils.INSTANCE.INSTANCE.asyncGet(url);
        System.out.println(result);
    }


    @Test
    public void testAsyncGet2() {
        //java中调用kotlin代码
        //调用kotlin的单例对象
        String url = "https://www.baidu.com/";
        OkhttpUtils.INSTANCE.asyncGet2(url, new Function1<String, Unit>() {
            @Override
            public Unit invoke(String s) {
                System.out.println(s);
                return null;
            }
        });
    }

}
