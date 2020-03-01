package some;

import java.io.*;
import java.util.Scanner;

/**
 * Author:liang;
 * Date:2020/2/25;
 * Time:11:13;
 * Package Name:some;
 * 需求：
 * 步骤：
 */
public class keyboard_input {
    public static void main(String[] args) throws IOException {
        //display();
        //line();
        scanner_test();
    }

    /**
     * 只读取一个字符
     * @throws IOException
     */
    public static void display() throws IOException {


        InputStream inputStream= System.in;//获取系统标准输入流，这个流不要关闭，一旦关闭不能打开
        int ch;
        while ((ch=inputStream.read())!='#')//和getchar()差不多
        {
            System.out.println((char)ch);
        }
        System.out.println("over");
    }

    /**
     * 读取一个字符串，但无法分清int，float，double等
     * InputStreamReader流是字节流到字符流之间的转换桥梁，称为转换流
     * 可以把字节流转化为字符流
     * 系统是字节流
     * @throws IOException
     */
    public static void line() throws IOException {
        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        System.out.println("请输入str");
        String str;
        str=bufferedReader.readLine();
        System.out.println("str="+str);
    }
    public static void scanner_test()
    {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        System.out.println("int x ="+x);
//        System.out.println();
        String line=scanner.nextLine();
        //回车也会被当成一个字符串吞掉!!!
//        String line2=scanner.nextLine();
        System.out.println("line="+line);
    }
}
