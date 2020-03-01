package PrintStream;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:liang;
 * Date:2020/2/27;
 * Time:10:54;
 * Package Name:PrintStream;
 * 需求：
 * 步骤：
 *
 *   不负责数据源，只负责数据目的
 *   当想打印数据的时候通常使用这个类
 *
 * write和print
 * 1.共同点：两者都不刷新页面，只在原来的页面写数据.最终都是重写了抽象类Writer里面的write方法.
 * 2.区别：    （1）print方法可以将各种类型的数据转换成字符串的形式输出。
 *
 *            （2）重载的write方法只能输出字符、字符数组、字符串等与字符相关的数据。 
 *
 * PrintStream
 * 1.装饰类,为其他的输出流添加功能.使它们能够方便打印各种数据值的表示形式
 * 2.自动刷新机制，当参数传入true时
 * 3.平台默认的编码方式
 * 4.public PrintStream(String fileName)  public PrintStream(OutputStream out)
 * 5.write方法，参数int，把字节写入文件，只写低八位，高位不写
 * 6.print方法输出的是char类型
 *
 *
 * PrintWriter
 * 1.字符打印流
 * 2.构造函数   PrintWriter(File file)  PrintWriter(String fileName)  PrintWriter(OutputStream out)   PrintWriter(Writer out)
 * 3.PrintWriter(OutputStream out, boolean autoFlush)   PrintWriter(Writer out, boolean autoFlush)   自动刷新机制
 * 4.print方法，传的啥打印的就是啥，想保留原样时候打印，最终输出的是char数据
 */
public class PrintStreamDemo {
    /**
     * 向demo.txt文件中写入一些数据
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter("demo.txt"), true);
        printWriter.println("hello");//
        printWriter.close();
    }
}
