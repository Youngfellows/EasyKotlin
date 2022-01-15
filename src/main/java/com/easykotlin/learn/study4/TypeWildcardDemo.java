package com.easykotlin.learn.study4;

import java.util.List;

/**
 * Java 泛型的通配符有两种形式。我们使用
 * <p>
 * - 子类型上界限定符? extends T 指定类型参数的上限（该类型必须是类型T或者它的子类型）
 * - 超类型下界限定符? super T 指定类型参数的下限（该类型必须是类型T或者它的父类型）
 */

public class TypeWildcardDemo {

    /**
     * 子类型上界限定符? extends T 指定类型参数的上限（该类型必须是类型T或者它的子类型）
     * ? extends Animal -->> 传入参数必须是类型Animal或者Animal的子类型
     * <p>
     * 我们在方法actation(List<? extends Animal> list)中, 这个list可以传入以下类型的参数：
     * List<Animal>
     * List<Dog>
     * List<ShepherdDog>
     * List<Cat>
     *
     * @param list
     */
    public void action(List<? extends Animal> list) {
        for (Animal animal : list) {
            animal.eat();
        }
    }

    /**
     * 超类型下界限定符? super T 指定类型参数的下限（该类型必须是类型T或者它的父类型）
     * ? super T -->>> 传入参数必须是类型ShepherdDog或者ShepherdDog的父类型
     * <p>
     * <p>
     * 关于牧羊犬
     *
     * @param list
     */
    public void aboutShepherdDog(List<? super ShepherdDog> list) {
        System.out.println("About Shepher Dog ...");
        for (Object animal : list) {
            //System.out.println(animal);
            if (animal instanceof Animal) {
                ((Animal) animal).eat();
            }
        }
    }
}
