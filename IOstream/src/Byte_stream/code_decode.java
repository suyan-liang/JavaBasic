package Byte_stream;

import java.io.*;

/**
 * Author:liang;
 * Date:2020/2/25;
 * Time:16:12;
 * Package Name:Byte_stream;
 * 需求：
 * 步骤：
 */
        /*中文在GBK都是两个字节一个汉字；在UTF-8是三个字节。
        注意看FileReader和FileWriter本来就是转化流的子类,但是这两个类只能使用默认编码表GBK，
        查字符对应的字节然后写入文件(write)或转换成字符(read)
        但是转化流可以指定编码码表.如果指定，只能使用转换流eg:InputStreamReader("dauh.txt","utf-8")
        */
public class code_decode {
    public static void main(String[] args) throws IOException {
        write_gbk();
        read_utf8();
    }
    /**
     * 先以FileWriter的方式向decode.txt文件中写入GBK形式的字节
     */
    public static void write_gbk() throws IOException {
//        FileWriter fileWriter=new FileWriter("decode.txt");
//        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
//        bufferedWriter.write("你好");
//        bufferedWriter.close();
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("decode.txt"),"GBK"));
        bufferedWriter.write("啊哈哈哈哈");
        bufferedWriter.close();
    }
    /**
     * 再以utf-8的形式读出来，打印会显示乱码
     */
    public static void read_utf8() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream("decode.txt"),"UTF-8"));
        String mid=bufferedReader.readLine();
        System.out.println(mid);
        bufferedReader.close();
    }
}
