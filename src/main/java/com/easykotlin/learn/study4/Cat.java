package com.easykotlin.learn.study4;

/**
 * 猫
 */
public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        //super.eat();
        System.out.println("Cat Eating ...");
    }

}
