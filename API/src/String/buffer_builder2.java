package String;
/*
    Author:liang;
    Date:2020/2/19;
    Time:9:56;
    Package Name:String;
    需求：
    步骤：
    知识点：一、basic
            1.对象可被修改的字符串类型  StringBuffer 和 StringBuilder 类   ，就相当于***可变长度数组***
            2.StringBuffer线程安全，StringBuilder不安全但速度快，通常用后者
            3.创建新对象---StringBuffer x=new StringBuffer("hello");
            二、方法
            1.追加 public StringBuffer append(String s)
            2.反转 public StringBuffer reverse()
            3.删除 public delete(int start, int end)    deleteCharAt(int index)
            4.替换 replace(int start, int end, String str)
            5.插入 StringBuffer insert(int offset, String str)
            三、String,StringBuffer与StringBuilder的区别??
                多线程，且字符串需要频繁修改时使用StringBuffer
                单线程，且字符串需要频繁修改时使用StringBuilder
                字符串无需频繁修改使用String
            四、常用操作
            1.清空缓冲区  delete(0,str.length());
            2.查找   indexOf和lastIndexOf
                Java String indexOf(String str, int fromIndex)方法将返回指定字符串在字符串中从指定位置开始后第一次出现的索引，
                                                               或如果未找到指定子字符串，则返回-1
                                                               这里fromIndex就相当于一个墙，返回墙后面的字符串索引，
                                                               并不是说fromIndex是下标为0的地方
            五、变长数组的原理
              开辟大于原数组的一块新空间，把原来数组的数据放到前面，超出原长的数据放后面
            六、StringBuffer()和StringBuffer(int capacity)的区别
                前者自动创建大小为16字符的缓冲区，后者指定。区别在于效率
                当能确定所存储数据大致长度时用后者效率更高，不必变长额外运算。

*/

public class buffer_builder2 {
    public static void main(String[] args) {
        //创建对象
        StringBuffer x=new StringBuffer("hello");
        System.out.println(x);

        //追加
        x.append(" world!");
        System.out.println(x);

        //反转
        x.reverse();
        System.out.println(x);

        //删除,[start,end),包前不包尾
        x.delete(0,6);
        System.out.println(x);

        //替换,[start,end),包前不包尾
        StringBuffer y=new StringBuffer("test_replace");
        y.replace(0,4,"replace");
        System.out.println(y);

        StringBuffer test=new StringBuffer("hdfuoiijadowifuo");
        System.out.println(test.indexOf("fuo",3));

        test.setCharAt(0,'d');
        System.out.println(test);


        //设置长度
        test.setLength(3);
        System.out.println(test);
        //多的添加空字符
        test.setLength(5);
        System.out.println(test);
    }
}
