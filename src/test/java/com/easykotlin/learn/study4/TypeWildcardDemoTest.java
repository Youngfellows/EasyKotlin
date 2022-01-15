package com.easykotlin.learn.study4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class TypeWildcardDemoTest {

    /**
     * 测试泛型上限、下限
     * <p>
     * 我们在方法action(List<? extends Animal> list)中, 这个list可以传入以下类型的参数：
     * List<Animal>
     * List<Dog>
     * List<ShepherdDog>
     * List<Cat>
     */
    @Test
    public void testTypeWildcardExtends() {
        TypeWildcardDemo typeWildcardDemo = new TypeWildcardDemo();

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("普通动物", 2));
        animals.add(new Dog("普通狗", 1));
        animals.add(new ShepherdDog("牧羊犬", 3));
        animals.add(new Cat("普通猫", 2));
        animals.add(new Carfield("加菲猫", 4));

        typeWildcardDemo.action(animals);

        System.out.println("==================================");

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("普通狗1", 3));
        dogs.add(new ShepherdDog("牧羊曲1", 2));
        typeWildcardDemo.action(dogs);

        System.out.println("=================================");
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("普通猫1", 3));
        cats.add(new Carfield("加菲猫1", 5));
        typeWildcardDemo.action(cats);

        System.out.println("=================================");
        List<Carfield> carfields = new ArrayList<>();
        carfields.add(new Carfield("加菲猫2", 7));
        carfields.add(new Carfield("加菲猫3", 8));
        typeWildcardDemo.action(carfields);
    }

    /**
     * 超类型下界限定符? super T 指定类型参数的下限（该类型必须是类型T或者它的父类型）
     * ? super T -->>> 传入参数必须是类型ShepherdDog或者ShepherdDog的父类型
     */
    @Test
    public void testTypeWildcardSuper() {
        TypeWildcardDemo typeWildcardDemo = new TypeWildcardDemo();

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("普通动物", 1));
        animals.add(new Dog("普通狗", 1));
        animals.add(new ShepherdDog("牧羊犬", 3));
        animals.add(new Cat("普通猫", 2));
        animals.add(new Carfield("加菲猫", 4));
        typeWildcardDemo.aboutShepherdDog(animals);

        System.out.println("==========================");

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("普通狗1", 2));
        dogs.add(new ShepherdDog("牧羊犬1", 3));
        typeWildcardDemo.aboutShepherdDog(dogs);

        System.out.println("==========================");

        List<ShepherdDog> shepherdDogs = new ArrayList<>();
        shepherdDogs.add(new ShepherdDog("牧羊犬2", 3));
        typeWildcardDemo.aboutShepherdDog(shepherdDogs);

        System.out.println("=========================");
        //类型不匹配
        //List<Cat> cats = new ArrayList<>();
        //cats.add(new Cat("普通猫2", 3));
        //cats.add(new Carfield("加菲猫2", 3));
        //typeWildcardDemo.aboutShepherdDog(cats);

    }
}
