package Collection;

/**
 * Author:liang;
 * Date:2020/2/21;
 * Time:19:45;
 * Package Name:Collection;
 * 需求：
 * 步骤：
 */

import java.util.*;

/**
 * 1.和函数一样，只能一对一或者多对一，不能一对多。
 */
public class Map7 {
    public static void main(String[] args) {
        /**Map的基本方法
         * 1.添加  put(key,value) ，存在key返回原来value，不存在返回null
         * 2.删除  remove(key)，返回对应value        clear()
         * 3.通过键获取值  get(key) ,不存在返回null
         * 4.包含 containsKey(key)  containsValue(value)
         * 5.判空 isEmpty()
         * 6.键值对个数 size()
         * 7.获取值序列  Collection<V> values();  返回的是一个集合而不是set，因为值可能重复
         */
        System.out.println("-----------Map基本方法----------");
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(1,"ee");//基本类型会直接覆盖了，自定义类型需要override方法
        System.out.println(map);//可以直接打印
        map.remove(2);
        System.out.println(map);
        System.out.println(map.get(1));
        System.out.println("包含键1？"+map.containsKey(1));
        System.out.println("包含值h? "+map.containsValue("h"));
        System.out.println("键值对的个数"+map.size());
        System.out.println("值序列");
        Collection<String> values=map.values();
        System.out.println(values);
        /**Map的遍历方法
         * 1.Set<K> keySet()  返回map的键的集合，然后用迭代器遍历
         * 2.Set<Map.Entry<K,V>> entrySet()，返回打好包的一对对Map键值集合，用getKey()和getValue()访问，理解为结婚证书，Map.Entry<K,V>是类型
         * ps. static interface Map.Entry<K,V>   其实Entry是Map的内部的一个静态接口
         */
        map.put(4,"d");
        map.put(5,"e");
        System.out.println(map);
        System.out.println("keySet()-----------");
        Set<Integer> set=map.keySet();
        Iterator it=set.iterator();
        while(it.hasNext())
        {
            Integer mid=(Integer)it.next();
            System.out.println("key:"+mid+"...value:"+map.get(mid));
        }
        System.out.println("------------------------------------");
        System.out.println("Map.Entry<K,V>  迭代器---------");
        Set<Map.Entry<Integer,String >> couple=map.entrySet();
        Iterator iter=couple.iterator();
        while(iter.hasNext())
        {
            Map.Entry<Integer,String> mid=(Map.Entry<Integer,String >)iter.next();
            System.out.println("key:"+mid.getKey()+"...value:"+mid.getValue());
        }
        System.out.println("Map.Entry<K,V>  for---------");
        for (Map.Entry<Integer, String> integerStringEntry : couple) {
            System.out.println("key:"+integerStringEntry.getKey()+"...value:"+integerStringEntry.getValue());
        }

    }
}
