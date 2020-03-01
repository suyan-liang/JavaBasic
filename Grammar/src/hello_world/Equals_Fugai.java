package hello_world;
/*
    Author:liang;
    Date:2020/2/12;
    Time:9:47;
    Package Name:hello_world;
    需求：创建person类，内部有一个私有变量age，覆盖equals方法使其能判断person中的age是否相等
    步骤：
    知识点：
*/
class Person
{
    private int age;
    public Person(int age)
    {
        this.age=age;
    }
    /*
    1.复写equals函数，要保证返回值、函数名、参数都一致，如下
    2.在使用多态方面的强制类型转换时应进行健壮性的判断 instanceof,类型不同的抛异常
    3.一般都会覆盖这个方法，建立对象判断相同的依据
    */
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Person))
        {
            throw new ClassCastException("应传递人，而不是其他，发生了类型错误");
        }
        Person out=(Person)obj;
        if(this.age==out.age)
            return true;
        else
            return false;
    }
}
class Pig
{
    private int age;
    public Pig(int age)
    {
        this.age=age;
    }
}
public class Equals_Fugai {
    public static void main(String[] args) {
        Person p1=new Person(18);
        Person p2=new Person(18);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(new Pig(18)));
    }
}
