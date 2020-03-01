package multi_thread;
/*
    Author:liang;
    Date:2020/2/12;
    Time:19:57;
    Package Name:multi_thread;
    需求：利用第二种方法创建线程
    步骤：和前面差不多
    知识点：
    1.创建线程的第二种方法，实现Runnable接口。
        1.实现Runnable接口run方法，创建线程任务   2.通过Thread创建线程对象，并将实现Runnable接口的子类对象作为构造函数的参数传进去
        3.调用Thread对象的start方法
    2.好处 1.可以把那些有爹的类的类作为线程避免了Java单继承的局限性  2.降低了线程对象与线程任务之间的耦合性
                 3.Runnable仅仅是将线程的任务进行了封装  4.分离线程任务和线程对象，体现面向对象的思想
*/
class another_method implements Runnable
{
    private String name;
    another_method(String name)
    {
        this.name=name;
    }
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(this.name+"......."+i);
            for (int j = -99999; j <99999 ; j++) {

            }
        }
    }

}
public class another_create6 {
    public static void main(String[] args) {
        another_method x1=new another_method("旺财");
        another_method x2=new another_method("大黄");
        Thread t1=new Thread(x1);
        Thread t2=new Thread(x2);
        t1.start();
        t2.start();
        for(int i=0;i<10;i++)
        {
            System.out.println("main......."+i);
            for (int j = -99999; j <99999 ; j++) {

            }
        }
    }
}
