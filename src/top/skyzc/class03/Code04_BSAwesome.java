package com.company.class03;

/**
 * @Title Code04_BSAwesome
 * @Description // 寻找局部最小
 * @Author SkyzcYou youzhengcai@gmail.com
 * @Date 下午5:57 2022/3/14
 **/

public class Code04_BSAwesome {
    // arr 整体无序，相邻数不相等
    public static int oneMinIndex(int[] arr){
        // 处理边界情况
        if (arr == null || arr.length == 0){
            return -1;
        }
        int N = arr.length;
        if (N == 1){
            return 0;
        }
        // 两头
        if (arr[0] < arr[1]){
            return 0;
        }
        if (arr[N-1] < arr[N-2]){
            return N-1;
        }
        // 中间
        // N > 2
        int L = 0;
        int R = N-1;
        int ans = -1;

//        while (L <= R){
        while (L < R-1){  // 只有当有3个及以上的数时才二分 否则直接判断
            int mid = (L + R) / 2;
            // 同时小于两边，则拿到答案
            if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]){
                return mid;
            }else {
                // 不同时小
                // 1. 左>我    我>右 321
                // 2. 左<我    我<右 123
                // 3. 左<我    我>右 132
                if (arr[mid] > arr[mid - 1]){ // mid > L 切右边 满足2,3条件
                    R = mid - 1;
                }else { // arr[mid] > arr[mid+1] // mid > R 切左边
                    L = mid + 1;
                }
            }
            // 如果 mid > L 则切掉右边 形成一个凹形
//            if (arr[mid] > arr[mid-1]){
//                R = mid - 1;
//                continue;
//            }
            // 如果 mid > R 则切掉左边 形成一个凹形
//            if (arr[mid] > arr[mid+1]){
//                L = mid + 1;
//                continue;
//            }
        }
//        return ans;
        return arr[L] < arr[R] ? L:R;
    }
    // 生成随机数组，且相邻数不相等
    public static int[] randomArray(int maxLen,int maxValue){
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];

        if (len > 0){
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1;i < len;i++){
                do{
                    arr[i] = (int) (Math.random() * maxValue);  // 随机生成 arr[i]
                }while (arr[i] == arr[i-1]);  // 和前一个相等则重做
            }
        }
        return arr;
    }

    // 验证方法，拿到数组和一个测试值索引，返回该测试值是否为局部最小
    public static boolean check(int[] arr,int minIndex){
        if (arr.length == 0){
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;   // 判断 left 是否合法，如不合法则表示左边无值，断定 true,否则去判断
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true; // 判断 right 是否合法，越界了也表示为 true

        return leftBigger && rightBigger;
    }
    // 打印数组
    public static void printArray(int[] arr){
        for (int item : arr){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int maxLen = 100;
        int maxValue = 20;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0;i < testTime;i++){
            int[] arr = randomArray(maxLen,maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr,ans)){ // 如果出错
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("ending");
    }
}
