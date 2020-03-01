package Collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
    Author:liang;
    Date:2020/2/21;
    Time:10:18;
    Package Name:Collection;
    需求：验证TreeSet对自定义对象的操作，自动排序，Override方法compareTo
    步骤：
    知识点：
*/

/**
 * 创建一个比较器,实现Comparator的compare方法
 */
class my_compare implements Comparator
{
    public int compare(Object o1,Object o2)
    {
        /**
         * 以id为主要依据进行排序
         */
        Cat c1=(Cat)o1;
        Cat c2=(Cat)o2;
        int judge=c1.getId()-c2.getId();
        if(judge!=0)
        {
            return judge;
        }
        else if(c1.getAge()-c2.getAge()!=0)
        {
            return c1.getAge()-c2.getAge();
        }
        else
            return c1.getName().compareTo(c2.getName());
    }
}
class Cat implements Comparable
{
    private String name;
    private int age;
    private int id;
    public Cat(String name,int age,int id)
    {
        this.age=age;
        this.name=name;
        this.id=id;
    }


    public void show()
    {
        System.out.println("俺叫"+this.name);
        System.out.println("俺今年"+this.age+"岁啦！");
        System.out.println("俺的编号是"+this.id);
        System.out.println("-----------------");
    }


    public int getId()
    {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 对象自身的排序，自然排序
     * @param o
     * @return
     */
    public int compareTo(Object o) {
        //按照年龄比较，年龄相同比较姓名
        Cat cat = (Cat) o;
        int judge = this.age - cat.age;//返回正值是从小到大排序
        //return judge==0?this.name.compareTo(cat.name):judge;
        /*
        多个比较项时的操作
         */
        if (judge!=0)
        {
             return judge;
        }
        else if(this.name.compareTo(cat.name)!=0)
        {
            return this.name.compareTo(cat.name);
        }
        else
            return this.id-cat.id;
    }
}
public class TreeSet6 {
    public static void main(String[] args) {
        Set treeset=new TreeSet(new my_compare());
        treeset.add(new Cat("miaomiaomiao",3,0));
        treeset.add(new Cat("liyunmiao",2,1));
        treeset.add(new Cat("zhangdamiao",2,2));
        Iterator it=treeset.iterator();
        while(it.hasNext())
        {
            Cat p=(Cat)it.next();
            p.show();
        }
    }
}
