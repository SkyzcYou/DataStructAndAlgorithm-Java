package top.skyzc.class01;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2022/3/7
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 * Description:
 * 打印二进制
 */
public class Code06_PrintBinary {

    // 打印一个 int 整数的全部 32 位二进制
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1<<i)) == 0 ? "0":"1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int是32位二进制 long 是64位二进制
//        int num = 1;
//        print(num);
//
//        int test = 1;
//        print(test);
//        print(test<<1); // 移位运算
//        print(test<<2);

        // int 的最大值 2^31-1
//        int a = Integer.MAX_VALUE;
//        System.out.println(a);
//        print(a);

//        print(-1); // -1 的二进制
        // int 的最小值
//        int a = Integer.MIN_VALUE;
//        print(a);

        // 逻辑运算
//        int a = 123123123;
//        int b = 23423242;
//        print(a);
//        print(b);
//        System.out.println("=====");
//        print(a | b);
//        print(a & b);
//        print(a ^ b);

        // 右移
//        int a = 1024; //2^10
//        print(a);
//        print(a >> 1);

        // 用移位运算求一个数的相反数
        int c = Integer.MIN_VALUE;
        int d = -c;
        d =  (~c + 1); // 对c取反+1

        System.out.println(c);
        System.out.println(d);
    }
}