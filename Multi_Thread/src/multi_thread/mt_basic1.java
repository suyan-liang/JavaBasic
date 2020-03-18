package multi_thread;
/**
    Author:liang;
    Date:2020/2/12;
    Time:13:48;
    Package Name:multi_thread;
    需求：演示主线程和虚拟机两条线程，以及CPU的随机切换
    步骤：1.先创建一个类，里面不要定义变量，直接复写finalize()函数，令其打印一个内容 hello thread!
          2.在main函数中声明对象并调用gc函数,多试验几次观察打印情况，可验证需求
    知识点：1.进程是在内存中开辟的空间；
              线程是进程中一个负责执行的控制单元，一个进程中可以有多个线程同时运作，称为多线程，至少有一个线程
              比喻：进程是一个场地，程序是一台黄金饮料机，多个口的那种，线程就是接饮料的人，至少有一个人留在场地
            2.开启多个线程是为了同时运行多部分代码。每个线程都有自己运行的内容，这些内容称为 任务
            3.看上去是cpu同时执行，实际上是cpu不停随机切换线程。当线程多的时候，被处理的几率会降低，这样会卡，降低速度
            4.多线程的       好处：解决了多部分同时运行的问题
                             弊端：线程太多会造成效率的降低
            5.Java程序，jvm本身就依赖多线程
              执行主函数代码的称之为主线程，该线程任务的代码都在主函数中
              除此之外还有回收堆中垃圾的线程，代码在垃圾回收器中等等...
              主线程结束，虚拟机并不一定会结束
            6.垃圾回收线程依靠object类中的finalize方法来回收垃圾或者系统资源，一般子类会重写以匹配情况
              System.gc();函数用于主函数提醒垃圾回收器回收垃圾，但并不会立即回收，因为不在一个线程
*/


class mainThreadTest extends Object
{

    public void finalize()
    {
        System.out.println("hello thread!");
    }

}
public class mt_basic1 {
    public static void main(String[] args) {
            new mainThreadTest();
            new mainThreadTest();
            new mainThreadTest();
            System.gc();
            System.out.println("main over");

            /*
            下列是一种情况
            分析：先是进行主线程，创建对象；中间垃圾回收线程执行(可能gc前或者后)，然后执行主线程打印main over
                  主线程结束，垃圾回收线程执行，调用finalize函数打印出hello thread。充分体现了多线程
            hello thread!
            main over
            hello thread!
            hello thread!
             */
    }
}

