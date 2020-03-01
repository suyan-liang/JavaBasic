package hello_world;
/*
    Author:liang;
    Date:2020/2/12;
    Time:10:42;
    Package Name:hello_world;
    需求：验证知识点1
    步骤：创建一个类，创建他的对象，直接打印 再 打印toString，再复写测试
    知识点：1.如果System.out.println()括号中是对象，自动调用toString方法，一般都会覆盖掉
*/
class toStringTest
{
    private String name;
    private int age;
    toStringTest(String name,int age)
    {
        this.age=age;
        this.name=name;
    }

}
class toStringTest2
{
    private String name;
    private int age;
    toStringTest2(String name,int age) {
        this.age = age;
        this.name = name;
    }
    public String toString()
    {
        String msg=this.getClass()+"   name="+this.name+"   age="+this.age;
        return msg;
    }
}
public class toString {
    public static void main(String[] args) {
        toStringTest x=new toStringTest("zhang3",18);
        System.out.println(x);
        System.out.println(x.toString());

        toStringTest2 y=new toStringTest2("lisi",19);
        System.out.println(y);
        System.out.println(y.toString());
    }
}
