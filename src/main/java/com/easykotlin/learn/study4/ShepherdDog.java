package com.easykotlin.learn.study4;

/**
 * 牧羊犬
 */
public class ShepherdDog extends Dog {

    public ShepherdDog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        //super.eat();
        System.out.println("Shepher Dog Eating ...");
    }
}
