package com.exercise.baseskill.design.strategy;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 20:31
 * @Description : 策略模式
 */
// 定义接口方法
public abstract class Strategy {
    public abstract void show();
}

class StrategyA extends Strategy{

    @Override
    public void show() {
        System.out.println("为春节准备的促销活动A");
    }
}

class StrategyB extends Strategy{

    @Override
    public void show() {
        System.out.println("为中秋节准备的促销活动B");
    }
}

class StrategyC extends Strategy{

    @Override
    public void show() {
        System.out.println("为圣诞节准备的促销活动C");
    }
}