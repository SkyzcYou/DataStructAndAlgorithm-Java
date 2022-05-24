package top.skyzc.class03;


import java.util.Arrays;

/**
 * @Title Code01_BSExist
 * @Description // 二分查找
 * @Author SkyzcYou youzhengcai@gmail.com
 * @Date 下午3:00 2022/3/14
 **/

public class Code01_BSExist {
    // arr 保证有序
    public static boolean find(int[] arr, int num){
        if (arr == null || arr.length == 0) return false;

        int L = 0;
        int R = arr.length - 1;
        while(L <= R){
            int mid = (L + R) / 2;
            // 第一种情况： num 正好在中间，一次命中
            if (arr[mid] == num){
                return true;
            }else if (arr[mid] < num){ // 第二种情况： 中间的小于目标，说明目标在右边
                L = mid + 1;            // 将 L 游标移动现在位置 + 1
            }else {  // 第三种情况：中间值大于目标，说明目标在右边
                R = mid - 1; // 移动 R 游标
            }
        }
        return false;
    }


    // 对数器： 同样的输出，对比别的方法答案是否一致
    // test 暴力破解
    public static boolean test(int[] sortAar,int target){
        for (int i = 0;i<sortAar.length;i++){
            if (sortAar[i] == target){
                return true;
            }
        }
        return false;
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0;i<arr.length;i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
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

            if (test(arr,value) != find(arr,value)){
                System.out.println("出错了！");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice":"Fucking fucked!!!");



    }

}
