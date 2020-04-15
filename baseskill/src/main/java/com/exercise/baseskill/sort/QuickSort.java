package com.exercise.baseskill.sort;

import java.util.Arrays;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 15:55
 * @Description : 快速排序
 * 定义基准数，将数组分割两边
 * 递归调用自身
 */
public class QuickSort {

    public static void quickSort(int[] arr,int low,int high){
        if(low>=high){
            return ;
        }
        int t=0; //缓存变量
        int tmp=arr[low]; //基准数
        int i=low;
        int j=high;
        while(i<j){
            //右边找比基准数小的，记录下标（等待替换），但是不能超过左边遍历过来的low
            while(j>i && arr[j]>=tmp){   //注意是>= 不是>
                j--;
            }

            //左边找比基准数大的，记录下标（等待替换），但是不能超过右边遍历过来的high
            while(i<j && arr[i]<=tmp){
                i++;
            }

            if(i<j){
                t= arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
        //基准数与交汇处的数字替换
        arr[low] = arr[i];
        arr[i]= tmp;

        //递归调用
        quickSort(arr,low,i-1);  //注意是low不是0
        quickSort(arr,i+1,high);
    }

    public static void main(String[] args) {
        int [] arr = {11,4,6,2,7,12,5,13,20};
        QuickSort.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
