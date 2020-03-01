package Collection;
/*
    Author:liang;
    Date:2020/2/20;
    Time:17:03;
    Package Name:Collection;
    需求：
    步骤：
    知识点：
*/

import java.util.ArrayList;
import java.util.Iterator;


public class ArrayList3 {
    public static void main(String[] args) {
        ArrayList list=new ArrayList();//放入任意自定义对象
        list.add(new Person("zhang3",18));
        list.add(new Person("li4",20));
        Iterator it=list.iterator();
        while (it.hasNext())
        {
            ((Person)it.next()).show();//多态问题，注意.的优先级高，要括住
            System.out.println();
        }
    }
}
class Person
{
    private int age;
    private String name;
    Person()
    {
        super();
    }
    Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getName()
    {
        return this.name;
    }
    public void show()
    {
        System.out.println("name:"+this.name);
        System.out.println("age"+this.age);
    }

}