package Get;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:10:33;
 * Package Name:Get;
 * 需求：获取类中的字段
 * 步骤：
 *
 * 一个规律，如果是获取可访问的都是   getxxx，这样访问不到私有变量，但可以访问父类
 *          想访问私有变量，用       getDeclaredxxx   这样什么类型都能访问，但只能获取本类字段，不能访问父类，即使父类的字段是公有
 */
public class getFields {
    public static void main(String[] args) throws Exception {
            //demo();
        //get_public();
       get_private();
    }

    /**
     * 获取字段
     * @throws ClassNotFoundException
     */
    public static void demo() throws ClassNotFoundException, NoSuchFieldException {
        String name="Get.Person";
        Class clazz=Class.forName(name);
//        Field field=clazz.getDeclaredField("test");
        Field field=clazz.getField("test");
        System.out.println(field);
    }
    /**
     * 操作字段，获取和修改
     * 统统是以字段为主体，实例对象为参数!!!!!!!!即使是在构造器和方法中也是一样，规律!
     */
    public static void get_public() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //公有字段
        String name="Get.Person";
        Class clazz=Class.forName(name);
        Constructor constructor=clazz.getConstructor(int.class);
        Object obj=constructor.newInstance(22);
        //获取 字节码字段
        Field field=clazz.getField("gong");
        //获取 字节码字段的实例对象体现
        Object o=field.get(obj);
        System.out.println(o);
        //修改
        field.set(obj,555);
        Object changed=field.get(obj);
        System.out.println("changed"+changed);

    }
    public static void get_private() throws Exception
    {
        //私有字段
        String name="Get.Person";
        Class clazz=Class.forName(name);
        Constructor constructor=clazz.getConstructor(String.class,int.class );
        Object obj=constructor.newInstance("Zhang3",18);
        Field field=clazz.getDeclaredField("age");
        //对私有字段取消权限检查，暴力访问
        field.setAccessible(true);
        Object o=field.get(obj);
        System.out.println(o);
        field.set(obj,666);
        Object changed=field.get(obj);
        System.out.println("changed..."+changed);


    }
}
