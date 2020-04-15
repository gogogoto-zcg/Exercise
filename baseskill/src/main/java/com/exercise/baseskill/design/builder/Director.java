package com.exercise.baseskill.design.builder;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 18:15
 * @Description : TODO
 */
// 4.建造模式的核心 --- 指导者（Director,进行建造组装)
public class Director {

    public Human createHumanByDirecotr(IBuildHuman bh) {
        bh.buildBody();
        bh.buildFoot();
        bh.buildHand();
        bh.buildHead();
        return bh.createHuman();
    }
}
