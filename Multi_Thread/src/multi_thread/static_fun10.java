package multi_thread;
/*
    Author:liang;
    Date:2020/2/13;
    Time:14:03;
    Package Name:multi_thread;
    需求：验证静态同步函数的锁是字节码文件对象，只需让锁为字节码文件对象时票数无异常即可
    步骤：1.创建窗口类，定义票数，复写run函数，调用静态同步函数。while循环持续卖票
          2.创建一个进程任务，四个进程对象，启动进程，观察票数变化
    知识点：
*/
class static_window implements Runnable
{
    private static int num=20;
    public void run()
    {
        while(num>0)
        {
            static_thread_fun();
        }
    }
    public static synchronized void static_thread_fun()
    {
        try {
            Thread.sleep(20);
        }
        catch (InterruptedException e)
        {

        }
        if(num>0)
        {
            System.out.println(Thread.currentThread().getName()+"........num="+num--);
        }
    }
}
public class static_fun10 {
    public static void main(String[] args) {
        static_window task=new static_window();
        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        Thread t3=new Thread(task);
        Thread t4=new Thread(task);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
