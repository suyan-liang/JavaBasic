package System;

/**
 * Author:liang;
 * Date:2020/2/23;
 * Time:10:56;
 * Package Name:System;
 * 需求：
 * 步骤：
 */

import java.util.Properties;
import java.util.Set;

/**
 * https://www.cnblogs.com/yinzhengjie/p/8887145.html
 * System不能被实例化，内部大部分为静态方法
 * 查看系统信息，添加系统信息
 */
public class Demo {
    public static void main(String[] args) {
        /**
         * 用System.currentTimeMillis()来测试程序运行的时间
         */
        long start=System.currentTimeMillis();
        for (int i = 0; i < 99999; i++) {
            for (int j = 0; j <99999 ; j++) {

            }
        }
        long end=System.currentTimeMillis();
        System.out.println("------------------------------");
        System.out.println(end-start);
        System.out.println("上面程序运行时间为"+(end-start)+"ms");
        System.out.println("------------------------------");
        /**
         * public static Properties getProperties()  获取当前系统的属性
         * 返回类型是Properties ，它继承于HashTable，键值都是String类型
         *
         * Set<String>	stringPropertyNames()   通过这个方法获取键的集合
         * String	getProperty(String key)     通过这个方法获取值
         */
        Properties properties=System.getProperties();
        Set<String> set=properties.stringPropertyNames();
        for (String s : set) {
            System.out.println(s+".............."+properties.getProperty(s));
        }
    }
}
