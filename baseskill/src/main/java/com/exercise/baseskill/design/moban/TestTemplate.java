package com.exercise.baseskill.design.moban;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 20:22
 * @Description :
 * 行为型模式：模版方法模式
 * 核心：抽象父类定义相同的部分，实现相同的方法，子类实现不同的部分
 * 即：现在有炒菜这个公共行为，但是炒的两个菜不同，具体来说是蔬菜和佐料，不同，因此需要重写的也是这两个部分的方法
 * @Url:https://blog.csdn.net/weixin_40834464/article/details/82958187?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-23&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-23
 */
public class TestTemplate {
    public static void main(String[] args) {
        BaoCai baoCai = new BaoCai();
        SuanRong suanRong = new SuanRong();
        baoCai.cookProcess();
        System.out.println("=======================");
        suanRong.cookProcess();
    }
}
