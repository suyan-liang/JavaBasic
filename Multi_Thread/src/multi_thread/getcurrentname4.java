package multi_thread;

import java.util.TreeMap;

/*
    Author:liang;
    Date:2020/2/12;
    Time:18:11;
    Package Name:multi_thread;
    需求：获取当前运行线程的名字
    步骤：1.创建一个线程类，重写run方法，在run方法中打印当前线程的名字
          2.利用带string的构造函数来给进程命名,super(name)
          3.在main函数创建进程并启动
    知识点：
    1.不能直接在对象中使用getName()函数，因为在线程对象创建的时候，构造函数会自动给对象分配一个名称。
      此时getName()函数获取的其实是对象名称而不是当前线程名称
    2.要获取当前线程名字，需要Thread.currentThread()函数获得当前线程的引用，再调用getName方法可以得到当前线程的名字，无需创建对象
    3.线程默认带名字Thread-0,Thread-1依次编号，主线程是Thread-main
*/
class getCurrentdemo extends Thread
{
    private String name;
    getCurrentdemo(String name)
    {
        super(name);
        this.name=name;
    }
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(this.name+"......."+Thread.currentThread().getName());
            for (int j = -999999; j <10000000 ; j++) {

            }
        }

    }
}
public class getcurrentname4 {
    public static void main(String[] args) {
        getCurrentdemo x=new getCurrentdemo("zhang3");
        x.start();
        for(int i=0;i<10;i++)
        {
            System.out.println("........."+Thread.currentThread().getName());
            for (int j = -999999; j <10000000 ; j++) {

            }
        }

    }
}
