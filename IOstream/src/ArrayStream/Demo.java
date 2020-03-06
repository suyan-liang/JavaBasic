package ArrayStream;

/**
 * Author:liang;
 * Date:2020/2/28;
 * Time:19:19;
 * Package Name:ArrayStream;
 * 需求：
 * 步骤：
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 当需要操作的数据涉及到内存的时候使用这个流
 * 其实就是用流的思想来操作数组
 * 有操作字节的ByteArrayInputStream，有操作字符的CharArrayReader，有操作字符串的StringReader
 *
 * 数组输出输出流
 * 1.数据被输出到一个byte数组（内置的），此数组大小可变
 * 2.操作数组的流，无需关闭，关了也没用，因为它不调用底层资源
 * 3.不抛IOException
 *
 * 数组输入流
 * 1.  2,3,和输出流一致
 * 2.用来操作数组
 *
 *
 * 下面以操作字节的流演示
 */
public class Demo {
    public static void main(String[] args) {
        ByteArrayInputStream bis= new ByteArrayInputStream("hello java".getBytes());
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        int ch=0;
        while ((ch=bis.read())!=-1){
            bos.write(ch);
        }
        System.out.println(bos.toString());

    }
}
