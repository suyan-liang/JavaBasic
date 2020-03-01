package multi_thread;

import com.sun.org.apache.xpath.internal.axes.OneStepIterator;

/*
    Author:liang;
    Date:2020/2/12;
    Time:16:43;
    Package Name:multi_thread;
    需求：和上一个代码一样演示
    步骤：
    知识点：
*/
class main_thread_demo extends Object
{
    private String name;
    public main_thread_demo(String name)
    {
        this.name=name;
    }
    void show()
    {
        for(int i=0;i<20;i++)
        {
            System.out.println(this.name+"...show..."+i);
        }
    }
    public void finalize()
    {
        System.out.println(this.name+"!!!!!!!!!!!回收了！！！！！！");
    }
}
public class mt_twothread2 {
    public static void main(String[] args) {
        new main_thread_demo("zhang3");
        System.gc();
        main_thread_demo x=new main_thread_demo("张三");
        x.show();

    }
}
