package multi_thread;
/*
    Author:liang;
    Date:2020/2/14;
    Time:8:41;
    Package Name:multi_thread;
    需求：和13一致，只不过资源内容变为私有
    步骤：
    知识点：1.对资源的操作，尽量同步封装在资源内部，这样线程一次调用不用考虑安全问题。如必须外部，务必考虑同步问题是否存在
*/
class Resource3
{
    private String name;
    private String sex;  //变成私有内容，外界直接访问，所以要加上set和get方法如下
    boolean flag=false;
    public synchronized void set(String name,String sex)//set方法，对Resource资源赋值，考虑到赋值时会产生安全隐患
                                                        //所以把函数定义为同步函数。这样在线程中可以直接调用，不用考虑函数过程中的
                                                        //多线程安全隐患问题
    {
        try {
            if(flag)
                this.wait();;
        }
        catch (InterruptedException e)
        {}
        this.name=name;
        this.sex=sex;
        flag=true;
        this.notify();
    }
    public synchronized void out()
    {
        try{
            if(!flag)
                this.wait();
        }
        catch (InterruptedException e)
        {

        }
        System.out.println(this.name+"......."+this.sex);
        flag=false;
        this.notify();

    }
}
class Input3 implements Runnable
{
    Resource3 r;
    Input3(Resource3 r)
    {
        this.r=r;
    }
    public void run()
    {
        int x=0;
        while(true)
        {
            if(x%2==0)
            {
                r.set("zhang3","man");//直接使用，不用考虑函数过程中的安全问题
            }
            else
                r.set("丽丽","女");
            x++;
        }
    }

}
class Output3 implements Runnable {
    Resource3 r;

    Output3(Resource3 r) {
        this.r = r;
    }

    public void run()
    {
        while(true)
        {
            r.out();
        }


    }

}

public class code_update14 {
    public static void main(String[] args) {
        Resource3 r=new Resource3();
        Input3 input =new Input3(r);
        Output3 output=new Output3(r);
            Thread t1=new Thread(input);
            Thread t2=new Thread(output);
            t1.start();
            t2.start();
    }
}
