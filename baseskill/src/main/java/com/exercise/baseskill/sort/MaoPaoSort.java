package com.exercise.baseskill.sort;

import java.util.Arrays;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 15:31
 * @Description : 冒泡排序算法
 * 明确循环次数
 * 明确循环长度
 */
public class MaoPaoSort {
    //冒泡升序
    public static void maoPaoSort(int[] arr){
        int tmp = 0;
        for (int i = 0; i < arr.length-1; i++) {  //循环次数
            for (int j = 0; j < arr.length-1; j++) { //两两比较的元素长度
                if(arr[j]>arr[j+1]){
                    tmp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {3,5,1,6,7,2};
        MaoPaoSort.maoPaoSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
