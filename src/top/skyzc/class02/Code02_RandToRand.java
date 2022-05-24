package top.skyzc.class02;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2022/3/9
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Code02_RandToRand {
    public static void main(String[] args) {
        System.out.println("测试开始");
        // Math.random() -> double -> [0,1)
        // [0,1) 范围等概率返回一个小数
        int testTimes = 10000000;
        int count = 0;
        for (int i = 0;i<testTimes;i++){
           if (Math.random() < 0.3){
               count++;
           }
        }
        // 打印 Math.random() < 0.3 的概率，可以看出的确是等概率
        System.out.println((double) count/(double) testTimes);
        System.out.println("=====================");

        // [0,1) -> [0,8)
        count = 0;
        double ans = Math.random() * 8;
        for (int i = 0; i<testTimes;i++){
            if (Math.random() * 8  < 4){
                count++;
            }
        }
        System.out.println((double) count/(double) testTimes);
        System.out.println((double) 5/(double) 8);

        int K = 9;
        // [0,K) -> [0,K-1]
        int ans1 = (int)(Math.random() * K);
        int[] counts = new int[9]; // 统计 0-8 出现的次数
        for (int i = 0;i < testTimes;i++){
            int ans2 = (int)(Math.random() * K);
            counts[ans2]++;
        }
        for (int i = 0;i<K;i++){
            System.out.println(i+"这个数，出现了"+counts[i]+"次");
        }

        System.out.println("=====================");
        count = 0;
        double x = 0.7;
        for (int i = 0;i<testTimes;i++){
            if (xToXPower2() < x){
                count ++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x,2));

        System.out.println("========================");
        count = 0;
        for (int i = 0;i<testTimes;i++){
            if (f2()==0){
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("====================");
        counts = new int[9];
        for (int i = 0;i < testTimes;i++){
            int num = g();
            counts[num]++;
        }
        for (int i = 0;i<8;i++){
            System.out.println(
                    i + "这个数，出现了" + counts[i] + "次"
            );
        }
    }
    // 思考： 如何让对于任意一个 x ，x 出现的概率是 x^2?
    // 返回 [0,1) 的一个小数
    // 任意的 x,x属于[0,1),[0,x) 范围上的数出现的概率由原来的x调整为x平方
    public static double xToXPower2(){
        return Math.max(Math.random(),Math.random());
    }

    // lib 里面的，不能改！
    public static int f1(){
        return (int)(Math.random() * 5) + 1;
    }
    // 随机机制，只能用 f1，等概率返回 0和1
    public static int f2(){
        int ans = 0;
        do{
            ans = f1();
        }while (ans == 3);
        return ans < 3 ? 0:1;
    }
    // 得到 000 ~ 111 做到等概率
    // 做到了 0-7 等概率返回一个
    public static int f3(){
        return (f2() << 2) + (f2() << 1) + (f2() << 0);
    }
    // 0 ~6 等概率返回 排除 7 即可
    public static int f4(){
        int ans = 0;
        do {
            ans = f3();
        }while (ans==7);
        return ans;
    }
    public static int g(){
        return f4() + 1;
    }
    // 你只能知道，x 会以固定概率返回 0 和 1 ，但是 x 的内容，你看不到！
    public static int xx(){
        return Math.random() < 0.84 ? 0:1;
    }
    // 等概率返回 0 和 1
    public static int y(){
        int ans = 0;
        do {
            ans = xx();
        }while (ans == xx()); // 两次不等概率01发生器，两次相等则丢掉重来
        return ans;
    }
}