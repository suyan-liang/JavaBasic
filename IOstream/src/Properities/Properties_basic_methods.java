package Properities;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Author:liang;
 * Date:2020/2/26;
 * Time:15:05;
 * Package Name:Properities;
 * 需求：
 * 步骤：
 * <p>
 *     Properties集合中键和值的类型都是字符串类型
 *     Properties集合中的数据可以保存到流中或者从流中获取
 *     通常用于存储以键值对形式存在的配置信息
 * </p>
 * 1.存   Object	setProperty(String key, String value)
 * 2.取   String	getProperty(String key)
 * 3.获取键的set    Set<String>	stringPropertyNames()
 */
public class Properties_basic_methods {
    public static void main(String[] args) throws IOException {

//        test_basic();
//        stream();
//        store_func();
    change_func();
    }


    /**
     * 测试Properties的基本方法
     */
    public static void test_basic()
    {
        Properties properties=new Properties();
        properties.setProperty("zhang3","18");
        properties.setProperty("li4","20");
        properties.setProperty("wang5","22");
/*        String res=properties.getProperty("zhang3");
        System.out.println("zhang3的年龄"+res);*/
        Set<String > set=properties.stringPropertyNames();
        for (String s : set) {
            System.out.println(s+"...."+properties.getProperty(s));
        }
    }
    /**
     * 和流结合的功能
     * list方法，主要是用于调试，可以显示集合中的数据
     * 参数是PrintStream，通常使用System.out输出到控制台上
     */
    public static void stream()
    {
        Properties properties=new Properties();
        properties.setProperty("zhang3","18");
        properties.setProperty("li4","20");
        properties.setProperty("wang5","22");
        properties.list(System.out);
    }

    /**
     * 利用properties生成文件
     *
     * 持久化，就是让集合中的信息不随内存的释放而释放，而是存储起来
     * properties集合生成配置文件之类的，肯定不能一运行结束就没
     *
     * 其实这些方法就是便捷了一点
     * 有字符流有字节流
     * void	store(OutputStream out, String comments)
     * void	store(Writer writer, String comments)
     * 注释不要写中文，否则会被转化成十六进制
     * 用字符流和字节流效果好像差不多
     */
    public static void store_func() throws IOException {
        Properties properties=new Properties();
        properties.setProperty("zhang3","18");
        properties.setProperty("li4","20");
        properties.setProperty("wang5","22");
//        FileOutputStream fileOutputStream=new FileOutputStream("store.txt");
//        properties.store(fileOutputStream,"the comments must be English");
//        fileOutputStream.close();
        FileWriter fileWriter=new FileWriter("woc.txt");
        properties.store(fileWriter,"chsadui");
        fileWriter.close();
    }
    /**
     * 修改配置文件信息
     * .properties文件就是配置文件
     * 许多个性化设置都是通过配置文件来完成的
     * 1.加载 load函数，参数可以是字符流也可以是字节流
     * 2.创建FileWriter的时候默认参数是会清空文件内容的
     *
     * 需求
     * 将woc.txt中li4的年龄改为25
     */
    public static void change_func() throws IOException {
        /*Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream("woc.txt");
        properties.load(fileInputStream);
        properties.list(System.out);*/
        /*
         * 如果不存在文件，那么进行创建
         */
        File file=new File("woc.txt");
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileReader fileReader=new FileReader(file);//这里可以直接把file传进去
        Properties properties=new Properties();
        properties.load(fileReader);
        properties.setProperty("li4","25");
        FileWriter fileWriter=new FileWriter(file);//创建的时候会默认清空这个文件，所以操作同一个文件时不能在FileReader读取完内容之前创建FileWriter

        properties.store(fileWriter,"changed");
        fileReader.close();
        fileWriter.close();
    }
}
