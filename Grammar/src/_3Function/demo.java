package _3Function;

/**
 * Author:liang;
 * Date:2020/3/12;
 * Time:9:36;
 * Package Name:_3Function;
 * 需求：
 * 步骤：
 *
 * 函数重载:唯一区别---参数不同    与返回值无关
 *
 *
 * 只能在函数内部使用函数，不能在函数内部定义实现函数
 *
 *
 * 函数的调用在内存中的体现是入栈出栈
 *
 * 存在着栈内存，以本例为例
 * 首先main函数入栈
 * 而后hello入栈  执行完毕  hello出栈
 * fun1....
 * fun2....
 * main函数出栈
 *
 */
public class demo {
    public static void main(String[] args) {
        hello();
        fun1(2);
        fun2(2,3);
    }
    /**
     * 在内部定义函数，要被main函数直接调用，需要定义为static
     */
    public static void hello(){
        System.out.println("hello world");
    }

    public static void fun1(int x)
    {
        System.out.println("一参数");
    }
    public static void fun2(int x,int y)
    {
        System.out.println("两参数");
    }


}
