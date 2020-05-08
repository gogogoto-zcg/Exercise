package com.exercise.baseskill.sort;

import java.util.Arrays;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 17:00
 * @Description : 简单选择排序
 * 明确循环次数 数组长度-1
 * 每次循环确定一个最小值
 */
public class SelectSort {

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 4, 6, 2, 7, 12, 5, 13, 1};
        SelectSort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
