package com.easykotlin.learn.study4;

import java.util.ArrayList;
import java.util.List;

/**
 * 协变（covariant）与逆变（contravariant）
 */
public class CovariantDemo {

    /**
     * 在Java中数组是协变的
     */
    public void covariant() {
        //在Java中，因为 Integer 是 Number 的子类型，数组类型 Integer[] 也是 Number[] 的子类型，
        //因此在任何需要 Number[] 值的地方都可以提供一个 Integer[] 值。
        Integer[] integers = new Integer[3];
        integers[0] = 1;
        integers[1] = 2;
        integers[2] = 3;

        //可以正确编译运行
        Number[] numbers = new Number[3];
        numbers = integers;
        for (Number number : numbers) {
            System.out.println(number);
        }

        System.out.println("=============================");

        //而另一方面，泛型不是协变的。也就是说， ListInteger> 不是 ListNumber> 的子类型，
        //试图在要求 ListNumber> 的位置提供 ListInteger> 是一个类型错误。
        //下面的代码，编译器是会直接报错的
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        List<Number> numberList = new ArrayList<>();
        //numberList = integerList;


        /**
         * Animal类型（简记为F, Father）是Dog类型（简记为C, Child）的父类型，我们把这种父子类型关系简记为F <|  C。
         *
         * 而ListAnimal>, ListDog>的类型，我们分别简记为f(F), f(C)。
         *
         * 那么我们可以这么来描述协变和逆变：
         *
         * 当F <| C 时, 如果有f(F) <| f(C),那么f叫做协变（Convariant）；
         * 当F <| C 时, 如果有f(C) <| f(F),那么f叫做逆变（Contravariance）。
         * 如果上面两种关系都不成立则叫做不可变。
         *
         * 协变和逆协变都是类型安全的。
         *
         * Java中泛型是不变的，可有时需要实现逆变与协变，怎么办呢？这时就需要使用我们上面讲的通配符? 。
         *
         * <? extends T>实现了泛型的协变
         *
         * List<? extends Number> list = new ArrayList<>();
         *
         * 这里的? extends Number表示的是Number类或其子类，我们简记为C。
         *
         * 这里C <| Number，这个关系成立：List<C>  <|  List< Number >。即有：
         */

        List<? extends Number> list = new ArrayList<Number>();
        //list.add(new Integer(1));////error

        /**
         *
         因为，ListInteger>可以添加Interger及其子类，ListFloat>可以添加Float及其子类，
         * ListInteger>、ListFloat>都是List<? extends Number>的子类型，
         * 如果能将Float的子类添加到List<? extends Number>中，
         * 那么也能将Integer的子类添加到List<? extends Number>中,
         * 那么这时候List<? extends Number>里面将会持有各种Number子类型的对象
         * （Byte，Integer，Float，Double等等）。Java为了保护其类型一致，禁止向List<? extends Number>添加任意对象，
         * 不过可以添加null。
         */

        // 可以安全的读取数据 out T
        List<? extends Number> list1 = new ArrayList<Integer>();
        List<? extends Number> list2 = new ArrayList<Float>();
        //list1.add(new Integer(1));//error
        //list2.add(new Float(3.14));//error

        //但是这里不能向list1、list2添加除null以外的任意对象。
        list1.add(null);
        list2.add(null);
    }

    /**
     * <? super T>实现了泛型的逆变
     * List<? super Number> list = new ArrayList<>();
     * ? super Number 通配符则表示的类型下界为Number。即这里的父类型F是? super Number,
     * 子类型C是Number。即当F <| C , 有f(C) <| f(F) ， 这就是逆变。
     */
    public void contravariant() {
        //我们不能往List<? super Number >中添加Number的任意父类对象。
        //但是可以向List<? super Number >添加Number及其子类对象。
        List<? super Number> list1 = new ArrayList<Number>();
        List<? super Number> list2 = new ArrayList<Object>();

        list1.add(new Integer(1));
        list1.add(new Float(3));

        list2.add(new Integer(4));
        list2.add(new Double(3.14));
        for (Object o : list1) {
            System.out.println("data type=" + o.getClass().getSimpleName());
            System.out.println("ele=" + o);
        }

        System.out.println("============================");

        for (Object o : list2) {
            System.out.println("data type=" + o.getClass().getSimpleName());
            System.out.println("ele=" + o);
        }
    }
}
