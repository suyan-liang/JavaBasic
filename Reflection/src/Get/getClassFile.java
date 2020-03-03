package Get;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:9:42;
 * Package Name:Get;
 * 需求：获得Class文件的方法
 * 步骤：
 */
public class getClassFile {
    public static void main(String[] args) throws ClassNotFoundException {
        //get1();
        get3();
    }

    /*
     * 第一种方式，需要明确具体的类，创建对象，麻烦
     */
    public static void get1()
    {
        Person p1=new Person("大黄",15);
        Person p2=new Person("旺财",16);
        Class clazz1=p1.getClass();
        Class clazz2=p2.getClass();
        System.out.println(clazz1);
        System.out.println(clazz1==clazz2);
    }

    /*
     * 第二种方式，使用类的静态成员
     * 但还是需要用到静态成员，不够扩展
     */
    public static void get2()
    {
        System.out.println(Person.class);
    }
    /*
     *
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * 第三种方式,只要使用 类名字符串 即可得到字节码文件
     * 使用Class类的forName方法
     * 注意一定要加上包名,写全面咯
     *
     * 这种方式只要有名称即可，更方便，扩展性更强
     */
    public static void get3() throws ClassNotFoundException {
        String class_name="Get.Person";//可以把这个类名存到配置文件中，这样就可以实现自动读取   .class 文件了
        Class t=Class.forName(class_name);
        System.out.println(t);
    }
}
class haha{
    public int test;

}
class Person extends haha
{
    public int gong;
    private String name;
    private int age;
    public  Person()
    {
        super();
        System.out.println("person 无参 run...........");
    }
    public Person(String name, int age) {
        System.out.println("person 两参 run...........");
        this.name = name;
        this.age = age;
    }

    public Person(int gong) {
        this.gong = gong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void run()
    {
        System.out.println("run......");
    }
    private void sleep(int hour)
    {
        System.out.println("sleep...."+hour+"hours");
    }
}
