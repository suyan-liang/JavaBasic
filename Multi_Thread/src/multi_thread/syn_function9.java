package multi_thread;
/*
    Author:liang;
    Date:2020/2/13;
    Time:11:11;
    Package Name:multi_thread;
    需求：
    步骤：
    知识点： 1.直接在函数前面加上同步修饰符synchronized即可,但是要考虑好厕所安在哪里
             2.锁是谁？？   锁是this，是固定的
*/

class window_ticket_two implements Runnable
{
    private int num=20;
    Object obj=new Object();
    public void run()
    {
            while(true)
            {
                syn_fun();
            }
    }
    public synchronized void syn_fun()
    {

            if(num>0)
            {
                try{Thread.sleep(20);}catch (InterruptedException e){};
                System.out.println(Thread.currentThread().getName()+"..........."+(num--));
            }

    }
}
public class syn_function9 {
    public static void main(String[] args) {
        window_ticket_two task=new window_ticket_two();
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