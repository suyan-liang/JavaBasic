package hello_world;
/*
    Author:liang;
    Date:2020/2/12;
    Time:10:00;
    Package Name:hello_world;
    需求：A.验证hashCode的功能：返回哈希值(默认十进制)
    步骤：A1.建立一个类，创建一个它的对象。直接调用该函数即可
    知识点： 1.通常hashCode要随着equals的重写而重写
             2.直接打印 vs hashCode
             3.十六进制转换
*/
class hashCodeTest
{
    hashCodeTest()
    {

    }
}
public class hashCode {
    public static void main(String[] args) {
        hashCodeTest x=new hashCodeTest();
        System.out.println("直接打印对象(十六进制):"+x);
        System.out.println("调用hashCode方法(默认十进制):"+x.hashCode());
        System.out.println("十六进制"+Integer.toHexString(x.hashCode()));
    }
}
