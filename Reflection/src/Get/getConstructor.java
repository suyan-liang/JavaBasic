package Get;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:9:55;
 * Package Name:Get;
 * 需求：
 * 步骤：
 *
 * 如何创建Class文件对象?
 * 就是我已经获得Class文件了，如何根据文件创建一个Class对象
 *
 * 文件--字节码对象--实例对象
 * 以Person为例
 * 以前的情况是，先找到需要用到的类的字节码文件，加载进内存并创建字节码对象，再在new的时候创建Person对象
 * 现在的情况是，通过Class.forName获取字节码文件及对象，通过newInstance方法创建实例对象(相当于Person()无参构造函数)
 *
 * 如果没有空参的构造函数怎么办？
 * 这种情况要先获取指定的构造函数，通过字节码文件对象获取
 * Constructor<T>	getConstructor(Class<?>... parameterTypes)
 * 参数是数据类型对象的字节码对象
 * 返回值是构造函数对象
 *
 */
public class getConstructor {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
       // test();
        get_constructor();
    }
    public static void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Person类在上个文件，无参构造会打印信息
        String name="Get.Person";
        Class clazz=Class.forName(name);
        Object obj=clazz.newInstance();//直接使用字节码对象的newInstance方法
    }
    public static void get_constructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String name="Get.Person";
        Class clazz=Class.forName(name);
        Constructor constructor=clazz.getConstructor(String.class,int.class);
        //Java真是万物皆对象，构造函数也被封装成了对象
        Object obj=constructor.newInstance("zhang3",18);//通过构造器对象的newInstance方法
    }
}
