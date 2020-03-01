package multi_thread;
/*
    Author:liang;
    Date:2020/2/13;
    Time:20:05;
    Package Name:multi_thread;
    需求：有一个资源Resource，一个输入线程input，一个输出线程output
          希望能实现输入线程输入不同名字性别，输出线程分别输出
          要去考虑1.线程任务 2.线程安全问题
    步骤：
    知识点：1.线程间通信：多个线程处理同一资源，但是线程任务不同，例子如下
*/

class Resource//就是封装一下资源
{
    public String name;
    public String sex;//用public是为了方便访问，简化了一下
}
class Input implements Runnable//输入线程
{
    Resource r;
    Input(Resource r)//通过使用构造函数的方法将那一个公共的资源传递进线程
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
            }
        }
    }
}
class Output implements Runnable
{
    Resource r;
    Output(Resource r)
    {
        this.r=r;
    }
    public void run()
    {
        while(true)
        {
            synchronized (r)
            {
                System.out.println(r.name+"......"+r.sex);
            }


        }
    }
}
public class communication12 {

    public static void main(String[] args) {
        Resource r=new Resource();//一个对象作为资源
        Input input=new Input(r);
        Output output=new Output(r);
        Thread x=new Thread(input);
        Thread y=new Thread(output);
        x.start();
        y.start();

    }
}
