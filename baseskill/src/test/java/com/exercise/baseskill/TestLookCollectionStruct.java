package com.exercise.baseskill;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/16 0016 14:29
 * @Description : 常用数据结构
 */
public class TestLookCollectionStruct {

    @Test
    public void test(){
        //Object数组 、 Capacity: 10 、1.5倍扩容 、Arrays.copyOf 拷贝数组实现扩容 ，有指定容量构造器 ，容量不够就扩容
        //增删慢，查询快、线程不安全、效率高、可重复、有序
        new ArrayList().add("1");

        //Node节点 LinkedList 是一个双向链表
        //查询慢，增删快、线程不安全、效率高
        new LinkedList<Integer>().add(1);

        // 线程安全、效率低
        new Vector<>();

        //底层是一个固定value的hashMap，
        //不可重复、无序
        new HashSet<>().add("1");

        //有序、不可重复
        new LinkedHashSet<>().add(1);

        //去重、有序
        TreeSet<Object> objects = new TreeSet<>();

        //底层是 数组加单向链表 、 容量 16 、2倍扩容、负载因子 0.75 、在容量达到capacity*loadFactor的时候扩容、线程不安全、效率高
        //数组长度是64、链表长度大于8,会转化为红黑树 、
        //为什么hashmap的初始容量是2的n次幂 ，定位数组位置的时候使用位运算  （求余数位运算） ^  效率高
        new HashMap<>().put("","1");

        //线程安全、效率低
        //初始容量11、扩容为2N+1(N为上次容量)，定位方式（求余） %
        //相比与hashmap 他不会转化为红黑树，查询时间复杂度慢慢变高
        new Hashtable<>().put("","1");

        //常用于读取配置文件，实现动态配置参数
        new Properties();

        //实现队列、栈
        //细节查看：https://blog.csdn.net/weixin_36328444/article/details/80919727?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1

        //LinkedList 实现栈
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addFirst(1);  //入栈
        list1.removeFirst();   //出栈
        list1.peekFirst();      //获取栈顶元素
        list1.isEmpty();        //判空

        //LinkedList 实现队列
        list1.offerLast(1);  //入队列末尾
        list1.pollFirst();      //取队列头并移除
        list1.peekFirst();      //查看队列头
        list1.isEmpty();        //判空

    }
}
