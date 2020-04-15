package com.exercise.baseskill.design.builder;

import lombok.Data;
import lombok.ToString;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 18:10
 * @Description : TODO
 */

// 1.需要的对象定义：产品（Product）
@Data
@ToString
public class Human {
    private String head;
    private String body;
    private String hand;
    private String foot;
}
