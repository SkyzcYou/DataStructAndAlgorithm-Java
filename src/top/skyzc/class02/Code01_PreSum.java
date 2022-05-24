package top.skyzc.class02;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2022/3/9
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Code01_PreSum {
    // 直接累加
    public static class RangeSum1{
        private int[] arr;

        public RangeSum1(int[] array){
            arr = array;
        }
        public int rangeSum(int L,int R){
            int sum = 0;
            for (int i = L ; i<=R;i++){
                sum += arr[i];
            }
            return sum;
        }

    }

    // 前缀和数组
    public static class RangeSum2{
        private int[] preSum;

        public RangeSum2(int[] array){
            int N = array.length;
            preSum = new int[N]; // 前缀和数组
            preSum[0] = array[0];
            for (int i = 1;i<N;i++){
                preSum[i] = preSum[i - 1] + array[i];
            }
        }
        public int rangeSum(int L,int R){
            return L == 0 ? preSum[R] : preSum[R] - preSum[L-1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {23,123,35,46,565,76,68,878,3};
        RangeSum1 rangeSum1 = new RangeSum1(arr);
        int sum = rangeSum1.rangeSum(0,1);

        RangeSum2 rangeSum2 = new RangeSum2(arr);
        sum = rangeSum2.rangeSum(0,1);

        System.out.println(sum);
    }
}