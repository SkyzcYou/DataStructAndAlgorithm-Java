package top.skyzc.class02;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2022/3/10
 * Time: 23:52
 * To change this template use File | Settings | File Templates.
 * Description: 对数器
 */
public class Code03_Camp {
    // 选择排序
    public static  void selectSort(int[] arr){
        // 处理边界条件
        if (arr == null || arr.length <2) {
            return;
        }
        int N = arr.length;
        // 0 ~ n-1
        // 1 ~ n-1
        // 2 ~ n-1
        for (int i = 0; i<N;i++){
            // 1. 范围内选出最小值
            int minValueIndex = i;
            for (int j = i+1;j<N;j++){
                // 如果当前位置值小于已记录的最小值 则更新最小值，否则不变。
                minValueIndex = arr[j] < arr[minValueIndex] ? j:minValueIndex;
            }
            // 2. 交换
            swap(arr,i,minValueIndex);
        }

    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    // 返回一个数组 arr , arr 长度 [0,maxLen-1] , arr 中的每个值[0,maxValue-1]
    public static int[] lenRandomValueRandom(int maxLen,int maxValue){
        int len = (int) (Math.random() * maxLen);
        int [] ans = new int[len];
        // 数组中每个值也随机
        for (int i = 0;i<len;i++){
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;

    }
    public static int[] copyArray(int[] arr){
        int[] ans = new int[arr.length];
        for (int i = 0;i<arr.length;i++){
            ans[i] = arr[i];
        }
        return ans;
    }
    // arr1 和 arr2 一定等长
    public static boolean isSorted(int[] arr){
//        for (int i = 0;i< arr1.length;i++){
//            if (arr1[i] != arr2[i]){
//                return false;
//            }
//        }
        if (arr.length <2){
            return true;
        }
        int max = arr[0];
        for (int i = 1;i<arr.length;i++){
            if (max > arr[i]){
                return false;
            }
            max = Math.max(max,arr[i]);
        }
        return true;
    }
    // 对数器 生成随机样本自己做比对的机器
    public static void main(String[] args) {
        int maxLen = 50;
        int maxValue = 1000;
        int testTime = 10000;
        for (int i = 0 ;i <testTime;i++){
            int[] arr1 = lenRandomValueRandom(maxLen,maxValue);
            int[] tmp = copyArray(arr1);
            selectSort(arr1);
            if (!isSorted(arr1)){
                // 打印错误的数据
                for (int x = 0;x < tmp.length;x++){
                    System.out.print(tmp[x] + "");
                }
                System.out.println();
                System.out.println("选择排序错了！！！");
                break;
            }
        }

    }
}