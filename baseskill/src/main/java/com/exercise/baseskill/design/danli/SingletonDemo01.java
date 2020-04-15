package com.exercise.baseskill.design.danli;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 17:30
 * @Description : 双重判断单例模式
 */
public class SingletonDemo01 {
    //volatile 禁止指令重排
    private static volatile SingletonDemo01 instance;

    private SingletonDemo01(){}

    public static SingletonDemo01 getInstance(){
        if(instance==null){
            synchronized (SingletonDemo01.class){
                if(instance==null){
                    instance = new SingletonDemo01();
                }
            }
        }
        return instance;
    }
}
