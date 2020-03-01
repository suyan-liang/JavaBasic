package hello_world;
/*
    Author:liang;
    Date:2020/2/12;
    Time:9:18;
    Package Name:hello_world;
    需求：1.验证equals方法的功能，即同一个对象返回true，否则返回false
    步骤：创建一个类，两个对象，进行比较,证明不是内容的不同。让引用指向同一个对象，再进行比较
    知识点:1.equals是 Object中自带的函数，默认功能是比较两个对象地址值是否相同，返回一个boolean值，很低级
*/
class judge
{
    private int age;
    public judge(int age)
    {
        this.age=age;
    }
}
public class EqualsDemo {
    public static void main(String[] args) {
        judge x1=new judge(12);
        judge x2=new judge(12);
        System.out.println(x1.equals(x2));//false
        x1=x2;
        System.out.println(x1.equals(x2));//true
        System.out.println(x1==x2);//true
    }
}
