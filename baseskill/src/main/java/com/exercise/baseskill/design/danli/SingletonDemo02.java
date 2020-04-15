package com.exercise.baseskill.design.danli;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 17:37
 * @Description : 创建内部类方式
 */
public class SingletonDemo02 {

    private SingletonDemo02(){}

    private static class SingletonFactory{
        private static SingletonDemo02 instance = new SingletonDemo02();
    }

    public static SingletonDemo02 getInstance(){
        return SingletonFactory.instance;
    }

}
