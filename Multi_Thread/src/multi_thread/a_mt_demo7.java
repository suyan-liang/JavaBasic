package multi_thread;
/*
    Author:liang;
    Date:2020/2/13;
    Time:9:25;
    Package Name:multi_thread;
    需求：
    步骤：
    知识点：1.一个线程任务，四个线程对象。这样操作的都是同一个数据，不用静态，更好更nice!!!

*/
class sell_window implements Runnable
{
    private int num=20;
    public void run()
    {
        while(true)
        {
            if(num>0)
            {
                try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException e)
                {};

                System.out.println(Thread.currentThread().getName()+"...sell the no......"+(num--)+"........ticket");
            }

        }
    }
}
public class a_mt_demo7 {
    public static void main(String[] args) {
        sell_window s=new sell_window();
        Thread t1=new Thread(s);
        Thread t2=new Thread(s);
        Thread t3=new Thread(s);
        Thread t4=new Thread(s);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
