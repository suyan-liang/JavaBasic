package Collection;
/*
    Author:liang;
    Date:2020/2/19;
    Time:20:47;
    Package Name:Collection;
    需求：
    步骤：
    知识点：
*/
/*
A:添加功能
        boolean add(E e):向集合中添加一个元素
        void add(int index, E element):在指定位置添加元素
        boolean addAll(Collection<? extends E> c)：向集合中添加一个集合的元素。

        B:删除功能
        void clear()：删除集合中的所有元素
        E remove(int index)：根据指定索引删除元素，并把删除的元素返回
        boolean remove(Object o)：从集合中删除指定的元素
        boolean removeAll(Collection<?> c):从集合中删除一个指定的集合元素。

        C:修改功能
        E set(int index, E element):把指定索引位置的元素修改为指定的值，返回修改前的值。

        D:获取功能
        E get(int index)：获取指定位置的元素
        Iterator iterator():就是用来获取集合中每一个元素。

        E:判断功能
        boolean isEmpty()：判断集合是否为空。
        boolean contains(Object o)：判断集合中是否存在指定的元素。
        boolean containsAll(Collection<?> c)：判断集合中是否存在指定的一个集合中的元素。

        F:长度功能
        int size():获取集合中的元素个数

        G:把集合转换成数组
        Object[] toArray():把集合变成数组。

 */
import java.util.*;
public class List1 {
    public static void main(String[] args) {

        //创建一个ArrayList对象
        List<String >l1=new ArrayList<String >();

        //增
        System.out.println("增");
        l1.add("string");
        l1.add(1,"index+string");
        l1.add("hello");
        l1.add(1,"world");
        System.out.println(l1);
        System.out.println("-------------");


        //删
        System.out.println("删");
        l1.remove(0);
        l1.remove("hello");
        System.out.println(l1);
        System.out.println("------------");
        //改
        System.out.println("改");
        String res=l1.set(0,"set");
        System.out.println("返回值"+res);
        System.out.println(l1);
        System.out.println("------------");

        //查
        System.out.println("查");
        String ans=l1.get(1);
        System.out.println("ans="+ans);
        System.out.println(l1);
        System.out.println("子列表");
        System.out.println("sublist："+l1.subList(0,l1.size()));
        System.out.println("------------");
        //遍历
        System.out.println("迭代器while遍历");
        Iterator<String> it=l1.iterator();
        while(it.hasNext())//从数组的角度应该可以认为iterator初始位置下标是-1
        {
            System.out.println(it.next());
        }
        System.out.println("迭代器for遍历");
        for(Iterator x=l1.iterator();x.hasNext();)
        {
            System.out.println(x.next());
        }
        System.out.println("for遍历");
        for(String str:l1)
        {
            System.out.println(str);

        }
        System.out.println("-----------");
        System.out.println("包含");
        boolean judge=l1.contains("set");
        System.out.println(judge);
        System.out.println("-----------");
        System.out.println("大小");
        System.out.println(l1.size());//当前内容大小
        System.out.println("-----------");
        System.out.println("转化为数组");
        String [] test=l1.toArray(new String[]{});
        for(int i=0;i<test.length;i++)
        {
            System.out.println(test[i]);
        }
        System.out.println(l1);
    }
}
