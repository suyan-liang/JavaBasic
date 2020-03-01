package multi_thread;
/*
    Author:liang;
    Date:2020/2/13;
    Time:22:36;
    Package Name:multi_thread;
    需求：和12程序类似，但是输入线程输入一个名字，输出线程就要输出一个名字，强调一对一。
    步骤：1.在resource中加入一个boolean类型的变量flag，利用等待唤醒实现需求
    知识点：1.等待唤醒机制
                涉及的方法 1.wait():让指定线程冻结，放到线程池中
                           2.notify():唤醒线程池中随机一个线程，注意是随机一个
                           3.notifyAll():唤醒线程池中所有线程
                这些方法都必须定义在同步中synchronized，必须要明确到底是操作的哪个线程------- 锁对象.wait()  锁对象.notify()
                称为监视器(锁)方法

            2.为什么这些方法都被定义在Object类中？
                    因为这些方法都是监视器(锁)的方法，而锁可以是任意对象，故放在Object类中
*/
class Resource2//就是封装一下资源
{
    public String name;
    public String sex;//用public是为了方便访问，简化了一下
    boolean flag=false;//加入flag变量，用于实现一对一，方便wait和notify。flag为false代表Resource中无数据或数据被取走，为true代表数据未被取走
}
class Input2 implements Runnable//输入线程
{
    Resource2 r;
    Input2(Resource2 r)//通过使用构造函数的方法将那一个公共的资源传递进线程
    {
        this.r=r;
    }
    public void run()//线程任务是进行姓名和性别的赋值
    {
        int x=0;//现在还没有学输入语句，简单的用这个模拟一下
        while(true)
        {
            synchronized (r)//内部的代码多线程、共享资源、两句以上，要考虑线程安全
            {
                try//wait方法会抛出InterruptedException异常
                {
                    if(r.flag)
                        r.wait();
                }
                catch (InterruptedException e)
                {

                }
                if(x%2==0)
                {
                    r.name="zhang3";
                    r.sex="man";
                }
                else
                {
                    r.name="丽丽";
                    r.sex="女女女女女";
                }
                x++;
                r.flag=true;//改变flag状态
                r.notify();//唤醒线程池中随机一个线程，但是现在线程池中只有一个线程或者没有线程，所以就把Output唤醒

            }
        }
    }
}
class Output2 implements Runnable
{
    Resource2 r;
    Output2(Resource2 r)
    {
        this.r=r;
    }
    public void run()
    {
        while(true)
        {


            synchronized (r)
            {
                try
                {
                    if(!r.flag)
                    {
                        r.wait();
                    }
                }
                catch (InterruptedException e)
                {

                }
                System.out.println(r.name+"......"+r.sex);
                r.flag=false;
                r.notify();
            }


        }
    }
}
public class wait_notify13 {
    public static void main(String[] args) {
        Resource2 r=new Resource2();//一个对象作为资源
        Input2 input=new Input2(r);
        Output2 output=new Output2(r);
        Thread x=new Thread(input);
        Thread y=new Thread(output);
        x.start();
        y.start();
    }

}
