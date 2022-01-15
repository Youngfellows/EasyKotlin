package com.easykotlin.learn.study4;

/**
 * 加菲猫
 */
public class Carfield extends Cat {

    public Carfield(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        //super.eat();
        System.out.println("Carfield Eating ...");
    }
}
