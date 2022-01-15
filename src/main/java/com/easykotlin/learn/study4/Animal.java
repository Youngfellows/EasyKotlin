package com.easykotlin.learn.study4;

/**
 * 普通动物
 */
public class Animal {

    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("Animal Eating ...");
    }
}
