package com.easykotlin.learn.study9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Java访问kotlin
 */
@RunWith(JUnit4.class)
public class JavaUsingKotlinDemo {

    @Test
    public void testProperty() {
        Department department = new Department(1);
        department.setId(2);
        department.setName("IOT事业部");
        department.setOpen(true);
        department.setBig("No");
        System.out.println(department.toString());
        System.out.println(department.NO);

        //调用kotlin中的静态属性,通过Companion来访问
        String staticName = Department.Companion.getStaticName();
        int staticAge = Department.staticAge;
        System.out.println(staticName);
        System.out.println(staticAge);

        //在java中调用kotlin中的静态方法
        double price = Department.Companion.getPrice();//ok
        double length = Department.Companion.getLength(2.14, 7.05);//ok
        double length1 = Department.getLength(2.14, 7.77);//ok
        //Department.getPrice();//error
        System.out.println(price);
        System.out.println(length);
        System.out.println(length1);
    }


    @Test
    public void testPackageFunction() {
        //测试kotlin包级别函数和属性
        KotlinExampleKt.f1();
        KotlinExampleKt.f2();
        String address = KotlinExampleKt.getAddress();
        System.out.println(address);
        String swap = KotlinExampleKt.swap(address, 1, 3);
        System.out.println(swap);
    }

    @Test
    public void testProgrammingBook() {
        ProgrammingBook book = new ProgrammingBook();
        //book.setName("C语言");
        System.out.println(book.getName());
        book.setAuthor("Tony");
        System.out.println(book.getAuthor());
        System.out.println(book.findName());
        System.out.println(book.findAuthor());

        //生成默认参数重载
        book.getCategory(3, "好书");
        //book.getCategory(4);//error
        book.about();
        book.about(5);
        book.about(3, 7);

        try {
            //补获取异常
            book.throwException1();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //补获取异常
            book.throwException2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done ...");
    }

}
