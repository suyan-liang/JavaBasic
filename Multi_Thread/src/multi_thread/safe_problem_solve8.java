package multi_thread;
/*
    Author:liang;
    Date:2020/2/13;
    Time:10:03;
    Package Name:multi_thread;
    需求：还是卖票
    步骤：
    知识点：1.解决安全隐患的方法，使用同步代码块 synchronized(对象){需要同步的代码块}，这个对象直接用Object对象即可
*/
class window_ticket implements Runnable
{
    private int num=20;
    Object obj=new Object();
    public void run()
    {


            while(num>0)
            {
                synchronized (obj)
                {
                    if(num>0)
                    {
                        try{Thread.sleep(20);}catch (InterruptedException e){};
                        System.out.println(Thread.currentThread().getName()+"..........."+num--);
                    }
                }

            }


    }
}
public class safe_problem_solve8 {
    public static void main(String[] args) {
        window_ticket task=new window_ticket();
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
