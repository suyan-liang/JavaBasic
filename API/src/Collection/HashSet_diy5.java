package Collection;

import java.util.HashSet;
import java.util.Iterator;

/*
    Author:liang;
    Date:2020/2/20;
    Time:20:16;
    Package Name:Collection;
    需求：
    步骤：
    知识点：
*/
class Dog
{
    private int flag;
    private int age;
    private String color;
    Dog(int age,String color,int flag)
    {
        this.age=age;
        this.color=color;
        this.flag=flag;//flag是做测试用的，没啥特殊含义
    }
    public void show()
    {
        System.out.println("********************"+this);
        System.out.println("color:"+this.color);
        System.out.println("age="+this.age);
        System.out.println();
    }
    public boolean equals(Object object)
    {
        System.out.println("equals is running....."+this.hashCode());
        //剪枝一
        if(this==object)
            return true;
        //剪枝二
        if(!(object instanceof Dog))
        {
            throw new ClassCastException("请传入Dog对象");
        }
        //判断,注意类型转换
        Dog dog=(Dog)object;
        if(this.age==dog.age && this.color==dog.color)
            return true;
        else
            return false;
    }
    public int hashCode()
    {   //System.out.println(this+"hashCode is running......");
        //return this.age+this.color.hashCode();
        //this确实会自动调用hashcode方法
        System.out.println("hashCode is running...."+this.flag);
        return this.age*37;
    }
}
public class HashSet_diy5 {
    public static void main(String[] args) {
        HashSet hashSet=new HashSet();
        hashSet.add(new Dog(3,"black",1));
        hashSet.add(new Dog(5,"yellow",0));
        System.out.println("-----------------");
        hashSet.add(new Dog(5,"yellow",2));
     //   hashSet.add(new Dog(5,"yellow"));
        System.out.println("-------------------");
        Iterator it=hashSet.iterator();
        while (it.hasNext())
        {
            ((Dog)it.next()).show();
        }
    }
}
