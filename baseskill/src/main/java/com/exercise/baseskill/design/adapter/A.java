package com.exercise.baseskill.design.adapter;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 19:24
 * @Description :
 * @Url: https://blog.csdn.net/weixin_40834464/article/details/82958187?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-23&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-23
 */
public interface A {
    void a();
    void b();
    void c();
    void d();
    void e();
    void f();
}

//抽象类适配接口，实现空方法
abstract class Adapter implements A{

    @Override
    public void a() {

    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }

    @Override
    public void d() {

    }

    @Override
    public void e() {

    }

    @Override
    public void f() {

    }
}

//真正的工具类想要使用时，继承适配器类，只需要重写我们需要的方法即可
class Ashili extends Adapter{

    @Override
    public void a() {
        System.out.println("A方法被实现");
    }
}

/**
 * 接口适配器模式
 * 原理：通过抽象类来实现适配，用来减少不必要代码的效果 --- MouseAdapter
 *
 * 接口适配器使用场景：
 * （1）想要使用接口中的某个或某些方法，但是接口中有太多方法，
 *  我们要使用时必须实现接口并实现其中的所有方法，可以使用抽象类来实现接口，
 *  并不对方法进行实现（仅置空），然后我们再继承这个抽象类来通过重写想用的方法的方式来实现。这个抽象类就是适配器。
 *
 *  好处：不需要完全实现内部的所有方法，只需要选择有需要的去使用
 **/
class Test{
    public static void main(String[] args) {
        Ashili ashili = new Ashili();
        ashili.a();
        ashili.b();
    }
}
