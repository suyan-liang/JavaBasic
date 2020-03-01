package Character;

/**
 * Author:liang;
 * Date:2020/2/24;
 * Time:8:32;
 * Package Name:Character;
 * 需求：
 * 步骤：
 */

/**
 * 0.!!!!!输入流是从硬盘（文件）到内存（数组之类），输出流是从内存到硬盘。输入输出是相对内存而言
 *
 * 1.Java 操作流的对象都在IO包
 *
 * 2.流按操作的数据分为 字节流 和 字符流
 *   字符流=字节流读取字节数字后立即查找指定编码表获取文字，再对文字进行操作
 * 3.字节流的顶层父类（抽象） InputStream  OutputStream
 *   字符流的顶层父类（抽象） Reader       Writer
 */

import java.io.FileWriter;
import java.io.IOException;

/**
 * 1.要操作文字数据，首先考虑字符流
 *   要从内存写到硬盘，需要用Writer
 * 2.操作文件要用到FileWriter，创建对象时指定路径和文件的名字
 *   如果文件不存在，会自动创建；存在则会被覆盖
 *
 */
public class FileWriterDemo {
    public static final String LINE_SEPARATOR=System.getProperty("line.separator");
    public static void main(String[] args) throws IOException {
        FileWriterdemo();
        FileWriter_append();
        IO_exception_handle();
    }

    /**
     * 根据文件名创建   注意要使用writer的时候会抛异常
     * @throws IOException
     */
    public static void FileWriterdemo() throws IOException {
        FileWriter fileWriter=new FileWriter("demo.txt");
        fileWriter.write("hello iostream");//把数据写到缓冲区
        fileWriter.flush();//把缓冲区的数据写进硬盘
        fileWriter.close();//关闭流，并进行刷新flush
    }

    /**
     * 换行和续写append
     * 续写只需在创建FileWriter的构造函数加上true即可：  FileWriter(String fileName, boolean append)
     * 换行的话由于各个操作系统不同，所以需要调用系统信息中的换行符定义一下即可  System.getProperty("line.separator");见上面
     */
    public static void FileWriter_append() throws IOException {
        FileWriter fileWriter=new FileWriter("demo.txt",true);
        fileWriter.write(LINE_SEPARATOR+"java!");
        fileWriter.close();
    }

    /**
     *处理IO异常
     * 1.FileWriter写外面定义为空
     * 2.在try里面创建对象引用
     * 3.close写在finally并进行空指针判断
     */
    public static void IO_exception_handle()
    {
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter("demo.txt",true);
            fileWriter.write(LINE_SEPARATOR+"C++!");
          //  System.out.println(fileWriter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileWriter!=null)
            {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
