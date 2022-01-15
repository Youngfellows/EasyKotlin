package com.easykotlin.learn.study4;

/**
 * 狗
 */
public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        //super.eat();
        System.out.println("Dog Eating ...");
    }
}
