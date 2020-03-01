package utilities;

/**
 * Author:liang;
 * Date:2020/2/23;
 * Time:9:07;
 * Package Name:utilities;
 * 需求：
 * 步骤：
 * <p>
 * 工具类，补充原有集合类没有的一些功能，内部均为静态方法
 * 两篇很好的博客
 * https://www.cnblogs.com/Eason-S/p/5786066.html
 * <p>
 * https://www.cnblogs.com/codingcc1/p/11066591.html
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * static <T> List<T>	synchronizedList(List<T> list)
 * static <K,V> Map<K,V>	synchronizedMap(Map<K,V> m)
 * static <T> Set<T>	synchronizedSet(Set<T> s)
 * 通过这些方法返回线程安全的容器
 *
 */
public class Collections1 {
    public static void main(String[] args) {
        /**
         * !!!!!!Arrays类，数组转集合
         */
        String[] arr = {"aaa", "bbb", "ccc", "ddd"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        /*
        Arrays.asList得到的列表是被阉了的列表，无法使用改变列表长度的方法如增删，否则UnsupportedOperationException
        list.add("eee");
        System.out.println(list);
        */
        int[] arr1={1,3,5,7,9};
       /* List<Integer> list1=Arrays.asList(arr1);使用泛型的情况下会直接报错，爽，下面试试不使用*/
        /**
         * 如果数组中的元素是对象，直接存入List
         * 如果数组中的元素是基本数据类型，则存入数组的引用，如下面  [[I@4554617c]
         */
        List list1=Arrays.asList(arr1);
        System.out.println(list1);//发现只打印了一个元素


        /**
         * !!!!!!集合转数组，使用Collection里面的 <T> T[]	toArray(T[] a)
         * 标准写法 String arr[]=list.toArray(new String[list.size()]);
         * 一般如果指定的长度小于集合的长度，会自动创建和集合长度相同的数组
         * 如果大于集合长度，那么就使用这个，前面正常存，后面存null
         */
        List<String > list2=new ArrayList<String >();
        list2.add("hello");
        list2.add("Java");
        list2.add("C++");
        list2.add("Python");
        System.out.println("list2...."+list2);
        String [] res=list2.toArray(new String[list2.size()]);
        System.out.println(Arrays.toString(res));//为毛一定要用这个才能打印出来???下面测试发现字符串数组没有复写toString,直接用Arrays的
/*        String [] test={"a","b","c"};
        System.out.println(test);*/
    }

}
