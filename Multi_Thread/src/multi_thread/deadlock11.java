package multi_thread;
/*
    Author:liang;
    Date:2020/2/13;
    Time:17:23;
    Package Name:multi_thread;
    需求：展示死锁现象。创建两个...静态对象...作为同步锁，两个线程，a线程的任务是先锁住x,等待一会再去锁y，
                                                                 b线程的任务是先锁住y，等待一会再去锁x
                                                                 这样就会造成死锁。
    步骤：
    知识点：1.死锁
*/

class A implements Runnable
{
    public void run()
    {
            System.out.println("A is running...");
            synchronized (deadlock11.x)
            {
                System.out.println("x has been locked!");
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e)
                {

                }
                synchronized (deadlock11.y)
                {
                    System.out.println("y has been locked!");
                }
            }

    }
}
class B implements Runnable
{
    public void run()
    {
        System.out.println("B is running...");
        synchronized (deadlock11.y)
        {
            System.out.println("y has been locked!");
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {

            }
            synchronized (deadlock11.x)
            {
                System.out.println("x has been locked!");
            }
        }

    }
}
public class deadlock11 {
    public static Object x=new Object();
    public static Object y=new Object();
    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        Thread m=new Thread(a);
        Thread n=new Thread(b);
        m.start();
        n.start();
    }
}
