package com.easykotlin.learn.study7

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SingleInstanceDemoTest {

    @Test
    fun testObject1() {
        //引用object常量,object对象只能通过对象名字来访问
        val username: String = AdminUser.username
        val password: String = AdminUser.password
        val timestamp: String? = AdminUser.getTimestamp()
        println("username=${username}")
        println("password=${password}")
        println("timestamp=${timestamp}")
    }

    @Test
    fun testObject2() {
        //只能通过类的名称来直接访问object，不能使用对象实例引用
        DataProcessor.process()
        val userHome: String = DataProcessor.FileUtils.userHome
        val fileName: String = "xxx.txt"
        val content: String? = DataProcessor.FileUtils.getFileContent(fileName)
        println("userHome:${userHome}")
        println("content:${content}")
    }

    @Test
    fun testOkHttp() {
        val url: String = "https://www.baidu.com/"
        //同步请求
        val result: String? = HttpUtils.getSync(url)
        println("result=$result")

        println("================================================================")

        //异步请求
        HttpUtils.getAsync(url, onSucess = {
            println("on sucess ...")
            println(it)
        }, onFailure = {
            println("on failure ...")
            println(it)
        })
    }

    @Test
    fun testRectangle() {
        val topleft: Point = Point(0.0, 0.0)
        val topright: Point = Point(2.0, 0.0)
        val bottomleft: Point = Point(0.0, 2.0)
        val bottomright: Point = Point(2.0, 2.0)
        val rectangle = Rectangle("矩形", topleft, topright, bottomleft, bottomright)

        val distance: Double = rectangle.distance(topright)
        println("distance:${distance}")

        rectangle.getFeatures()
        //rectangle.getBorder().size//无法访问到
        rectangle.compare()
    }

    @Test
    fun testCompanionObject() {
        //创建伴生对象
        val httpUtils: CompanionObject.HttpUtils = CompanionObject.HttpUtils
        val connect: Boolean = httpUtils.connect(120.0)
        println("connect:${connect}")

        //私有构造不能new,通过伴生对象,单例来创建私有对象
        //一个类的伴生对象默认引用名是Companion
        val qqPlayer: QQPlayer = QQPlayer.create()
        qqPlayer.onCreate()
        println(qqPlayer.kernel)

        //我们可以直接像在Java静态类中使用静态方法一样使用一个类的伴生对象的函数，属性(但是在运行时，它们依旧是实体的实例成员)
        //Companion可以省略不写
        /*val qqPlayer: QQPlayer = QQPlayer.INSTANCE.create()
        qqPlayer.onCreate()*/
        println(QQPlayer.kernel_)
        println(QQPlayer.INSTANCE.getArea())
    }

    @Test
    fun testSealedObject() {
        val expression: ExpressionDemo = ExpressionDemo()
        val a: Double = expression.eval(Expression.Unit())
        val b: Double = expression.eval(Expression.Const(3.0))
        val c: Double = expression.eval(Expression.Sum(Expression.Const(4.0), Expression.Const(5.0)))
        val d: Double = expression.eval(Expression.Multiply(Expression.Const(4.5), Expression.Const(5.5)))
        val e: Double = expression.eval(Expression.NaN)
        println("a=${a}")
        println("b=${b}")
        println("c=${c}")
        println("d=${d}")
        println("e=${e}")
    }

    @Test
    fun testDataObject() {
        //var book: Book = Book("史记", 1280, 999.0, "司马迁")
        var book: Book = Book("史记", 1280, 999.0, "司马迁", "中华书局", 33)
        var des: String = book.getDes()
        println(des)

        //在一些场景下，我们需要复制一个对象来改变它的部分属性，而其余部分保持不变。
        //copy() 函数就是为此而生成
        book = book.copy(price = 389.0)
        des = book.getDes()
        println(des)

        val size: Int = book.size
        val weight: Double = book.getWeight()
        val year: Int? = book.getYear()
        println("size=${size},weitht=${weight},year=${year}")
    }

    @Test
    fun testUsePairData() {
        val standardData: StandardData = StandardData()
        standardData.usePairData()
    }

    @Test
    fun testNested() {
        //访问嵌套类的方式是直接使用 类名.， 有多少层嵌套，就用多少层类名来访问。
        val one: Int = NestedClassesDemo.Outer().one
        var two: Int = NestedClassesDemo.Outer.Nested1().two
        val three: Int = NestedClassesDemo.Outer.Nested1.Nested2().three
        val four: Int = NestedClassesDemo.Outer.Nested1.Nested2().getFour()
        println(one)
        println(two)
        println(three)
        println(four)

        println("=========================================================")

        //类可以标记为 inner 以便能够访问外部类的成员。内部类会带有一个对外部类的对象的引用
        two = NestedClassesDemo.Outer().Nested().getTwo()
        println(two)
        NestedClassesDemo.Outer().Nested().accessOuter()
    }

    @Test
    fun testAnonymousInnerClass() {
        val anonymous: AnonymousInnerClassDemo = AnonymousInnerClassDemo()
        anonymous.doRun()
        anonymous.doStop()
        anonymous.doWait()
        anonymous.doNotify()
        anonymous.doStart()
        anonymous.doCreate()
    }
}