package ObjectStream;

/**
 * Author:liang;
 * Date:2020/2/27;
 * Time:21:40;
 * Package Name:ObjectStream;
 * 需求：
 * 步骤：
 */

import java.io.*;

/**
 * 能操作对象，把对象读入或者读出  实现对象的持久存储
 * 字节流，对象都是字节
 *
 * 必须实现了Serializable接口（标记接口）的对象才能被写入文件
 * 关于Serializable接口
 * 1.作用就是给类加标记(ID)的功能，如果从文件中读取的对象的接口标记和内存中的对象接口标记(UID)不一致，会抛出异常
 * 2.类被改变，接口标记就会改变（数字签名），自己定义UID除外,自定义private static final long serialVersionUID=xxxxxxxxl;
 * 3.建议自己添加serialVersionUID ,原因是默认计算的对类的信息太敏感，根据编译器的实现千差万别，可能会导致意外的InvalidClassException
 *
 */
public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       writeObject();
        readObject();
    }

    /**
     * 构造函数ObjectOutputStream(OutputStream out)  后缀名存为.object
     * 把对象写入文件，对象需实现serializable接口
     * 只能写入非静态成员，方法不写入，静态不写入，transient不写入
     *
     * transient 用于修饰那些不想被写入内存的，而且是每个对象所特有的（所以不能静态）成员。
     * @throws IOException
     */
    public static void writeObject() throws IOException {
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("obj.object"));
        objectOutputStream.writeObject(new Person("张三",18));
        objectOutputStream.close();
    }

    /**
     * 	ObjectInputStream(InputStream in)
     * 	注意	ObjectInputStream只能读出来以前用ObjectOutputStream写入的对象
     * 将文件中的对象读出来，需要两个文件，一个是对象文件，一个是该类对应的字节码文件（一般加载了都）
     * 所谓反序列化就是把原来读进来的对象按顺序读出来
     * @throws IOException
     */
    public static void readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("obj.object"));
        Person person=(Person) objectInputStream.readObject();
        System.out.println(person.getName()+"....."+person.getAge());
    }
}

/**
 * 创建的一个对象，必须实现serializable接口才能被写入文件
 */
class Person implements Serializable
{
    //自己声明的版本UID
    private static final long serialVersionUID=15613212l;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
}
