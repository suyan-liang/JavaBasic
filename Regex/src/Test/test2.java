package Test;

import java.util.TreeSet;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:19:14;
 * Package Name:Test;
 * 需求：对ip地址进行排序
 *
 *
 * 做题先考虑分组替换思想
 * 替换几乎都要用到组，考虑清楚目的是什么，把目的封装成组
 *
 * 步骤：
 * 排序直接用TreeSet去排，但是像8.8.8.8这种本应在192.xx.xx.xx之前，但由于是按字符串排的，所以须补零
 * 1.先将ip地址都补两个0
 * 2.再把多余的0去掉
 *
 * 3.排序
 * 4.恢复原样
 */
public class test2 {
    public static void main(String[] args) {
        String text="192.168.12.5    8.8.8.8  13.51.235.1        3.15.135.22";
        //补两个0
        String mid1=text.replaceAll("(\\d+)","00$1");
        //去掉多余的0
        String mid2=mid1.replaceAll("0*(\\d{3})","$1");
        //切割进字符串数组并排序
        String[] strs=mid2.split(" +");
        TreeSet<String > treeSet=new TreeSet<String >();
        for (String str : strs) {
            treeSet.add(str);
        }
        //去除前导零
        for (String s : treeSet) {
            System.out.println(s.replaceAll("0*(\\d+)","$1"));
        }
    }
}
