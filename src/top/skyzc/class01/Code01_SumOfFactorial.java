package top.skyzc.class01;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2022/3/7
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Code01_SumOfFactorial {
    public static long f1(int N){
        long ans = 0;
        for (int i = 1;i<N;i++){
            ans += factorial(i);
        }
        return ans;
    }
    // 单独求一个数的阶乘
    public static long factorial(int N){
        long ans = 1;
        for (int i = 1;i<=N;i++){
            ans *= i;
        }
        return ans;
    }
    public static long f2(int N){
        long ans = 0;
        long cur = 1; // 缓存上一步的结果
        for (int i = 1;i<=N;i++){
            cur = cur * i; // 求当前的阶乘，就是 N-1 的阶乘 * 当前数
            ans += cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 100;
        System.out.println(f1(N));
        System.out.println(f2(N));
    }
}