package String;
/*
    Author:liang;
    Date:2020/2/15;
    Time:9:58;
    Package Name:String;
    需求：
    步骤：
    知识点：一、基本
                    1.String str="abc";//其中abc是字符串对象，str只是一个引用,值代表字符串的地址
                    2.字符串对象一旦初始化就不会被改变，不是说引用不能变
                    3.String str="abc";,str这种方法创建初始化的时候就像STL 集合一样，唯一性，先看常量池里面有没有这个"abc"
                      如果有，就直接让str值等于该字符串地址值。没有则重新开辟。
                    4.String str=new String("abc");是在堆中创建对象，不在常量池操作，与常量池中"abc"的地址不同;这句话开辟两个对象;
                    5.字符串中equals方法复写，比较内容
                    6.String str=new String();创建一个空串
            二、构造函数
                    1.上面的那种参数为字符串的不说了
                    2.String(byte [] bytes)   将bytes数组中的值转为ASCLL对应的字符放到字符串
                    3.String(char [] value)   直接将value数组中的字符放到字符串
                    4.String(char [] value,int offset,int count)   将value数组从offset开始截取count个
            三、常用方法
                    *Java中的字符串不能直接用下标调用字符，而是用charAt(int index)方法
                    *Java中比较字符串大小，用compareTo方法，这个和strcmp函数是一样的
                    *用replace函数把target替换成空串后，后面的向前自动补全,length减少
                     String replace(target_string,new_string),   String replace(old_char,new_char)
                    https://blog.csdn.net/qq_41879343/article/details/86577571
            四、实践
                    1.求字符串中指定字符串出现的次数
                    https://blog.csdn.net/qq_19533277/article/details/83039659


                    2.
*/
class str_basic_test//一、中基本内容的测试
{
    private String a="abc";
    private String b="abc";
    private String str=new String ("abc");
    void first_same_test()//测试3
    {
        System.out.println("一、3.测试");
        System.out.println(a==b);
    }
    void same_test_two()//测试4
    {
        System.out.println("一、4.测试");
        System.out.println(a==str);
    }
    void equals_test()//测试5
    {
        System.out.println("一、5.测试");
        System.out.println(str.equals(a));
    }
}
public class basic1 {
    public static void main(String[] args) {
        str_basic_test test=new str_basic_test();
        test.first_same_test();
        test.same_test_two();
        test.equals_test();

        byte[] bytes={65,66,67};
        String x1=new String (bytes);
        System.out.println("x1=="+x1);

        char[] value={'a','b','c'};
        String x2=new String (value);
        System.out.println("x2="+x2);
        String x3=new String (value,1,2);
        System.out.println("x3="+x3);
        System.out.println(x3.charAt(1));
        String x4=x3;
        System.out.println(x4.compareTo(x3));


        String rep="aacdssdffgdswww";
        String ans=rep.replace("ss","");
        System.out.println(ans);
    }
}
