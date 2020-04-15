package com.exercise.baseskill.design.builder;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 18:12
 * @Description : TODO
 */
// 2.定义需要对象应有的方法及返回对象的抽象方法  --- 建造者角色（Builder）
public interface IBuildHuman {
    public void buildHead();
    public void buildBody();
    public void buildHand();
    public void buildFoot();
    public Human createHuman();
}
