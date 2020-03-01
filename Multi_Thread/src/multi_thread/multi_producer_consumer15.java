package multi_thread;
/*
    Author:liang;
    Date:2020/2/14;
    Time:10:20;
    Package Name:multi_thread;
    需求：
    步骤：
    知识点：1.while   2.notifyAll
*/
class chicken
{
    private int id=0;
    boolean flag=false;
    public synchronized void  produce()
    {
        while (flag)
        {
            try{
                this.wait();
            }
            catch (InterruptedException e){}
        }
        id++;
        System.out.println(Thread.currentThread().getName()+"做好了No."+id+".....has ok");
        flag=true;
        notifyAll();
    }
    public synchronized void consume() {
        while (!flag)
        {
            try{
                this.wait();
            }
            catch (InterruptedException e)
            {

            }
        }

        System.out.println(Thread.currentThread().getName()+"吃了....No"+id+"烧鸡");
        flag=false;
        notifyAll();
    }
}
class Producer implements Runnable
{
    chicken res;
    Producer(chicken res)
    {
        this.res=res;
    }
    public void run()
    {
        while(true)
        {
            res.produce();
        }
    }
}
class Consumer implements Runnable
{
    chicken res;
    Consumer(chicken res)
    {
        this.res=res;
    }
    public void run()
    {
        while(true)
        {
            res.consume();
        }
    }
}
public class multi_producer_consumer15 {
    public static void main(String[] args) {
        chicken chic=new chicken();
        Producer p=new Producer(chic);
        Consumer c=new Consumer(chic);
        Thread t1=new Thread(p);
        Thread t2=new Thread(p);
        Thread t3=new Thread(c);
        Thread t4=new Thread(c);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
