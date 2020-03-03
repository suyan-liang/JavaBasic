package Get;

import java.lang.reflect.Method;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:11:14;
 * Package Name:Get;
 * 需求：
 * 步骤：
 */
public class getMethod {
    public static void main(String[] args) throws Exception {
       // get_method();
        run_method();
    }
    public static void get_method() throws Exception {
        Class clazz=Class.forName("Get.Person");
        //获取公有方法，包括父类
        Method[] methods=clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //获取本类中的方法，包括私有,不包括父类
        System.out.println("-------------------------------------------------");
        methods=clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //获取指定参数的函数,方法名和列表
        System.out.println("-------------------------------------------------");
        Method method=clazz.getDeclaredMethod("sleep",int.class);
        System.out.println(method);
    }
    /**
     * 运行方法
     */
    public static void run_method()throws Exception
    {
        Class clazz=Class.forName("Get.Person");
        Method method=clazz.getDeclaredMethod("sleep", int.class);
        method.setAccessible(true);//还是一样的套路
        Object obj=clazz.newInstance();
        method.invoke(obj,8);//使用这个方法运行

    }
}
