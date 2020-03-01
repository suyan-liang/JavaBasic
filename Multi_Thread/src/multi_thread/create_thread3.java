package multi_thread;
/*
    Author:liang;
    Date:2020/2/12;
    Time:17:18;
    Package Name:multi_thread;
    需求：创建两个线程,体现创建的线程以及线程切换的随机性
    步骤：1.创建两个线程类，run中任务是输出for循环中的数字，其中嵌套一个for循环拖时间，以体现随机性
          2.创建线程对象并启动
    知识点：
    0.创建线程的目的：为了开辟一条执行路径，去运行指定代码，和其他代码实现同时运行。运行的指定代码就是这个进程的任务
    1.jvm创建的主线程的任务都在主函数中。自定义线程的任务(代码)应封装在Thread类的run方法中
      run方法中定义的就是线程的运行代码，所以要继承Thread并重写run方法
    1.创建线程的方法一：
          1.定义一个类继承Thread类   2.复写Thread的run()方法(写入自定义线程要执行的代码)(run方法无需手工调用，启动后jvm自动调用)
          3.创建对象                 4.启动线程start() (start的两个功能 1.开启线程 2.调用run方法)
*/
class thread extends Thread {
    private String name;

    thread(String name)
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
public class create_thread3 {
    public static void main(String[] args) {
        thread demo1=new thread("小屁");
        thread demo2=new thread("二硕");
        demo1.start();
        demo2.start();
        for(int x=0;x<10;x++)
        {
            System.out.println("main......"+x);
            for(int y=-9999999;y<99999999;y++)
            {

            }

        }
    }
}
