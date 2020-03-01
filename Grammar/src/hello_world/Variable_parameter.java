package hello_world;

/**
 * Author:liang;
 * Date:2020/2/23;
 * Time:10:42;
 * Package Name:hello_world;
 * 需求：
 * 步骤：
 */
public class Variable_parameter {
    public static void main(String[] args) {
        /**
         * 函数的可变参数
         * 其实就是一个数组，但是可以直接接受元素，自动封装成数组，简化了调用者的书写
         * 函数内部还是当成数组去处理
         * 注意：可变类型参数类型必须定义在参数列表的结尾
         */
        int ans=add(1,2,3,4,5);
        System.out.println("ans="+ans);

        int res=add_a(100,1,2,3,4,5);
        System.out.println(res);
    }
    public static int add(int...arr)
    {
        int sum=0;
        for (int i : arr) {
            sum+=i;
        }
        return sum;
    }
    public static int add_a(int a,int...arr)
    {
        int sum=a;
        for (int i : arr) {
            sum+=i;
        }
        return  sum;
    }
}
