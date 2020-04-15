package com.exercise.baseskill.design.builder;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 18:15
 * @Description : TODO
 */
// 3.实现类实现抽象方法，进行建造 --- 具体创建者角色 当前为运动员
public class ActiveManBuilder implements IBuildHuman {

    Human human;
    public ActiveManBuilder() {
        human = new Human();
    }

    @Override
    public void buildHead() {
        human.setHead("头脑智商180");
    }

    @Override
    public void buildBody() {
        human.setBody("身体无敌的运动员");
    }

    @Override
    public void buildHand() {
        human.setHand("手");
    }

    @Override
    public void buildFoot() {
        human.setFoot("脚");
    }

    @Override
    public Human createHuman() {
        return human;
    }

}