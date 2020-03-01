package multi_thread;
/*
    Author:liang;
    Date:2020/2/12;
    Time:19:47;
    Package Name:multi_thread;
    需求：1.证明不同的线程有不同的栈，即使别的线程结束，本线程也不受影响，继续运行
          2.证明主线程结束了，其他线程仍可以进行
    步骤：1.通过创建异常来强制结束线程
          2.先创建一个线程，和原来的差不多，打印数字即可。
          3.创建两个对象，在main函数中创建异常，观察打印结果即可
    知识点：
*/
class independent_test extends Thread
{
    private String name;

    independent_test(String name)
    {
        this.name=name;
    }
    public void run()
    {
        for(int x=0;x<10;x++)
        {
            System.out.println(this.name+"......"+x);
            for(int y=-9999999;y<99999999;y++)
            {

            }

        }

    }
}
public class independent_stack5 {
    public static void main(String[] args) {
        independent_test x1=new independent_test("旺财");
        independent_test x2=new independent_test("大黄");
        x1.start();
        x2.start();
        for(int x=0;x<10;x++)
        {
            System.out.println("main......"+x);
            for(int y=-9999999;y<99999999;y++)
            {

            }

        }
        System.out.println(3/0);//创建异常
    }
}
