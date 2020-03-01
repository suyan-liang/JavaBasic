package hello_world;
/*
    Author:liang;
    Date:2020/2/12;
    Time:10:16;
    Package Name:hello_world;
    需求：验证同一类的两个对象的运行时类相同，并获取该运行时类
    步骤：创建一个类，创建两个对象，并创建两个Class引用分别获取这两个对象的运行时类的引用，判断相等与否并打印出名字
    知识点：1.比如Person p=new Person();   加载完毕后，在创建Person对象之前，堆中加载有一个字节码文件对象Person.class
              后面创建的person对象的运行时类都是这个字节码文件对象。
            2.其实创建所有的对象都是这样，在堆中都有他们对应的字节码文件对象，这些字节码文件对象的类称为Class，
              利用getClass()方法获得的其实就是这些字节码文件对象
*/
class getClassTest
{
    getClassTest()
    {

    }
}
public class getClass {
    public static void main(String[] args) {
        getClassTest x1=new getClassTest();
        getClassTest x2=new getClassTest();
        Class clazz1=x1.getClass();
        Class clazz2=x2.getClass();
        System.out.println(clazz1==clazz2);
        System.out.println(clazz1.getName());
    }
}
