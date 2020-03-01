package hello_world;

/**
 * Author:liang;
 * Date:2020/2/23;
 * Time:10:37;
 * Package Name:hello_world;
 * 需求：
 * 步骤：
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 就是高级一点的for循环
 * 用于当只遍历整个数组或者集合中的元素而不控制访问次数时
 */
public class super_for {
    public static void main(String[] args) {
        /**
         * 数组
         */
        int [] arr={1,3,5,6,55,1,3,22};
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("-------------------------------");
        /**
         * 集合
         */
        List<String> list=new ArrayList<String >();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for (String s : list) {
            System.out.println(s);
        }

    }

}
