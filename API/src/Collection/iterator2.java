package Collection;
/*
    Author:liang;
    Date:2020/2/20;
    Time:10:34;
    Package Name:Collection;
    需求：
    步骤：
    知识点：
*/
import java.util.*;
public class iterator2 {
    public static void main(String[] args) {
        //迭代器不允许在迭代过程中对集合数据进行添加，只能进行iterator.remove()，否则抛出异常,如下面演示
        //发动FBI一定要谨慎，分配巡逻任务
        //比喻迭代器是一个FBI，任务巡逻全部居民很辛苦，结果中途插入了，FBI:"!!!?????"只能回头再多检查，累死。但是可以减啊
        //而且迭代器可以选择增减list，自愿嘛！但是普通的迭代器里面没有增加和修改功能，要用list迭代器
        //https://blog.csdn.net/weixin_43113679/article/details/99775014?utm_source=distribute.pc_relevant.none-task
        //https://blog.csdn.net/weixin_39241397/article/details/79687789
        //next函数为返回下一个元素并指针后移一位，previous是返回上一个元素前移一位
        //ListIterator对应的方法均是作用在指针处

        ArrayList<String > l1=new ArrayList<String >();


        l1.add("hello");
        l1.add("world");
        ListIterator<String > it=l1.listIterator();
      //  Iterator it=l1.iterator();
        while(it.hasNext())
        {
            Object obj=it.next();
            if(obj.equals("world"))
                it.add("123");
        }
        System.out.println(l1);
        System.out.println("-----------------------------------------");
        ArrayList<String > l=new ArrayList<String >();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("d");
        ListIterator<String > iter=l.listIterator();
        while (iter.hasNext())
        {
            if(iter.next()=="c")
            {
                iter.set("???");
                break;
            }

        }
        if(iter.previous()=="???")
            System.out.println("okk");
        System.out.println(l);
        System.out.println("------------------------------------------");
        ArrayList<String > list=new ArrayList<String >();
        list.add("0");
        list.add("1");
        list.add("2");
        ListIterator<String > itt=list.listIterator(1);//说明插在"0"和"1"之间的箭头上
        if(itt.next()=="1")
            System.out.println("true!!!!!!!");
    }
}
