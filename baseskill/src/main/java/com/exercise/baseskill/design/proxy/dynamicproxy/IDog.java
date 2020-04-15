package com.exercise.baseskill.design.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 18:36
 * @Description : jdk动态代理
 */
public interface IDog {
    void run();
}

//目标类
class Dog implements IDog{

    @Override
    public void run() {
        System.out.println("狗哥再跑");
    }
}

class DogUtils{
    public static void method1() {
        System.out.println("增强方式一");
    }

    public static void method2() {
        System.out.println("增强方式二");
    }
}

class ProxyFactory {

    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                DogUtils.method1();
                method.invoke(target);
                DogUtils.method2();
                return null;
            }
        });
    }
}

class ProxyTest{
    public static void main(String[] args) {
        IDog dog = new Dog();
        IDog proxy = (IDog)ProxyFactory.getProxy(dog);
        proxy.run();
    }
}