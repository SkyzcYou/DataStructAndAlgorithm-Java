package top.skyzc.class03;

import java.util.Arrays;

/**
 * @Title Code02_BSNearLeft
 * @Description //TODO
 * @Author SkyzcYou youzhengcai@gmail.com
 * @Date 下午3:45 2022/3/14
 **/

public class Code02_BSNearLeft {
    // arr 有序 ，在有序数组中找到 >= num （最左）的位置
    public static int mostLeftNoLessNumIndex(int[] arr, int num){
        if (arr == null || arr.length == 0) return -1;

        int L = 0;
        int R = arr.length - 1;
        int ans = -1; // 设置一个变量 t 用于记录搜索到的索引
        while(L <= R ){
            int mid = (L + R) / 2;
            // 第一种情况： mid 大于等于目标，砍右边
            if (arr[mid] >= num){
                // 记录 t
                ans = mid; // 移动 R
                R = mid - 1;
            }else {  // 第二种情况：mid 小于目标，砍左边
                L = mid + 1; // 移动 L 游标
            }
        }
        return ans;
    }

    // 对数器 直接遍历
    public static int test(int[] sortAar,int target){
        for (int i = 0;i<sortAar.length;i++){
            if (sortAar[i] >= target){
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

    // 在 arr 上，找满足 >= value的最左位置
    public static int nearestIndex(int[] arr,int value){

        return -1;
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

            if (test(arr,value) != mostLeftNoLessNumIndex(arr,value)){
                printArray(arr);
                System.out.println(value);
                System.out.println(test(arr,value));
                System.out.println(mostLeftNoLessNumIndex(arr,value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice":"Fucking fucked!!!");


//        int[] arr1 = {1,2,2,3};
//        int target = -2;
//        System.out.println(test(arr1,target));
//        System.out.println(mostLeftNoLessNumIndex(arr1,target));

    }
}
