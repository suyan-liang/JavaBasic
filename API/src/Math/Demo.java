package Math;

import java.util.Random;

/**
 * Author:liang;
 * Date:2020/2/23;
 * Time:12:04;
 * Package Name:Math;
 * 需求：
 * 步骤：
 */
public class Demo {
    public static void main(String[] args) {
        /**
         * Math类
         * 一些数学运算，都是静态方法
         *
         * static double	ceil(double a)  返回大于参数的最小整数值
         * static double	floor(double a) 返回小于参数的最大整数值
         * static long	round(double a)     返回四舍五入的整数值
         * static double	random()   [0,1)
         */
        /**
         * Random类
         * https://blog.csdn.net/qq_40788630/article/details/81587149
         *
         * https://blog.csdn.net/goodbye_youth/article/details/81110123
         */
        Random random=new Random();
        System.out.println(random.nextDouble());
    }
}
