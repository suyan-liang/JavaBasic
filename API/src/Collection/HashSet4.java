package Collection;
/*
    Author:liang;
    Date:2020/2/20;
    Time:19:46;
    Package Name:Collection;
    需求：
    步骤：
    知识点：
*/

import java.util.HashSet;
import java.util.Iterator;

public class HashSet4 {
    public static void main(String[] args) {
        /*
            测试不重复和无序如下
        */
        HashSet hashSet=new HashSet();
        hashSet.add("??????");
        hashSet.add("haha");
        hashSet.add("hehe");
        hashSet.add("xixi");
        hashSet.add("xixi");
        Iterator it=hashSet.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
