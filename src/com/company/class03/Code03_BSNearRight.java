package com.company.class03;

import java.util.Arrays;

/**
 * @Title Code02_BSNearLeft
 * @Description //TODO
 * @Author SkyzcYou youzhengcai@gmail.com
 * @Date 下午3:45 2022/3/14
 **/

public class Code03_BSNearRight {
    // <=num 最右
    public static int mostRightNoBigNumIndex(int[] arr,int target){
        if (arr == null || arr.length == 0) return -1;

        int L = 0;
        int R = arr.length - 1;
        int T = -1;

        while (L <= R){ // 一直扫描完所有
            int mid = (L + R) / 2;
            // 第一种情况： mid <= target 砍掉左边
            if (arr[mid] <= target){
                T = mid;
                L = mid + 1;
            }else {  // mid > target 砍掉右边
                R = mid - 1;
            }
        }
        return T;
    }

    // 对数器 直接反向遍历
    public static int test(int[] sortAar,int target){
        for (int i = sortAar.length - 1 ;i >= 0;i--){
            if (sortAar[i] <= target){
                return i;
            }
        }
        return -1;
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0;i<arr.length;i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for (int item : arr){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0;i < testTime;i++){
            int[] arr = generateRandomArray(maxSize,maxValue); // 生成一个随机数组
            Arrays.sort(arr); // 排序
            int value = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());

            if (test(arr,value) != mostRightNoBigNumIndex(arr,value)){
                System.out.print("Array is: ");
                printArray(arr);
                System.out.println("target is: " + value);
                System.out.println("test result:" + test(arr,value));
                System.out.println("mROBNI result:" + mostRightNoBigNumIndex(arr,value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice":"Fucking fucked!!!");

//        int[] arr1 = {0,1,2,2,3};
//        int target = -22;
//        int[] arr1 = {8,30,34};
//        System.out.println(test(arr1,5));
//        System.out.println(test(arr1,target));
//        System.out.println(mostRightNoBigNumIndex(arr1,5));
//        System.out.println(mostRightNoBigNumIndex(arr1,target));
    }
}
