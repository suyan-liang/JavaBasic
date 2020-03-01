package Byte_stream;

/**
 * Author:liang;
 * Date:2020/2/25;
 * Time:10:04;
 * Package Name:Byte_stream;
 * 需求：
 * 步骤：
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流  和字符流的区别在于操作的对象不止是字符还可以是其他文件  但操作大概一致
 * 区别看下面代码
 */
public class BasicDemo {
    public static void main(String[] args) throws IOException {
        test_write();
        test_read();
        available_test();
    }

    /**
     * 无需刷新,但须关闭
     * 写入的时候要转成字节形式
     * @throws IOException
     */
    public static void test_write() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("fileoutoutstream.txt");
        fileOutputStream.write("abvasgbi".getBytes());
        fileOutputStream.close();
    }

    /**
     * 读取的话就是数组变了，变成了byte数组
     * @throws IOException
     */
    public static void test_read() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("fileoutoutstream.txt");
        byte[] buf=new byte[1024];
        int len=0;
        while((len=fileInputStream.read(buf))!=-1)
        {
            System.out.println(new String (buf,0,len));
        }
        fileInputStream.close();
    }

    /**'
     * available函数可以返回文件的大小，但要慎用，万一文件太大就gg了
     * @throws IOException
     */
    public static void available_test() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("fileoutoutstream.txt");
        byte[] buf=new byte[fileInputStream.available()];
        fileInputStream.read(buf);
        System.out.println(new String (buf));
        fileInputStream.close();
    }
}
