package top.skyzc.class01;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2022/3/7
 * Time: 17:52
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Code07_SelectionSort {
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

    // 冒泡排序
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        // 0 ~ N-1
        // 0 ~ N-2
        // 0 ~ N-3
        int N = arr.length;
        for (int end = N-1;end>=0;end--){
            // 0 ~ end 上干一坨事
            // 0 1   1 2    2 3    end-1 end
            for (int second = 1;second<=end;second++){
                if (arr[second-1]>arr[second]){
                    swap(arr,second-1,second);
                }
            }
        }

    }

    // 插入排序 1
    public static void insertSort1(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        // 0 ~ 0 完成
        // 0 ~ 1
        // 0 ~ 2
        // 0 ~ n-1
        int N = arr.length;
        for (int end = 1;end < N;end++){
            int newNumIndex = end;
            // 如果当前的数
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]){
                swap(arr,newNumIndex-1,newNumIndex);
                newNumIndex --;

            }
        }
    }
    // 插入排序 2
    public static void insertSort2(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N;end++){
            for (int pre = end - 1;pre >= 0 && arr[pre] > arr[end]; pre--){
                swap(arr,pre,pre-1);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void printArray(int[] arr){
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {7,1,3,5,1,6,8,1,3,5,7,6,6};

        printArray(arr);
//        selectSort(arr);
//        bubbleSort(arr);
        insertSort1(arr);
        printArray(arr);
        insertSort2(arr);
        printArray(arr);
    }
}