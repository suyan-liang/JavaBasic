package Byte_stream;

import java.io.*;

/**
 * Author:liang;
 * Date:2020/2/25;
 * Time:10:45;
 * Package Name:Byte_stream;
 * 需求：
 * 步骤：

 */
public class PPT_TEST {
    public static void main(String[] args) throws IOException {
        copy1();
        copy2();
        copy3();
       // copy4();
    }

    /**
     * 自定义缓冲区，速度第二快
     */
    public static void copy1() throws IOException {
        long start=System.currentTimeMillis();
        FileInputStream fileInputStream=new FileInputStream("C:\\test_files\\xiaopipi.ppt");
        FileOutputStream fileOutputStream=new FileOutputStream("C:\\test_files\\1.ppt");
        byte[] buf=new byte[1024];
        int len=0;
        while ((len=fileInputStream.read(buf))!=-1)
        {
            fileOutputStream.write(buf,0,len);
        }
        fileInputStream.close();
        fileOutputStream.close();
        long end=System.currentTimeMillis();
        System.out.println("copy1运行时间"+(end-start)+"ms");
    }
    /**
     * 单纯使用自带的缓冲区对象，速度第三快
     */
    public static void copy2() throws IOException {
        long start=System.currentTimeMillis();
        FileInputStream fileInputStream=new FileInputStream("C:\\test_files\\xiaopipi.ppt");
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream=new FileOutputStream("C:\\test_files\\2.ppt");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
        int len=0;
        while((len=bufferedInputStream.read())!=-1)
        {
            bufferedOutputStream.write(len);
        }
        long end=System.currentTimeMillis();
        System.out.println("copy2运行时间"+(end-start)+"ms");
    }
    /**
     * 自带缓冲区加自定义缓冲区，速度最快
     * 效率最高!!!!!!!
     * 不要每个都刷新，会降低速度
     */
    public static void copy3() throws IOException {
        long start=System.currentTimeMillis();
        FileInputStream fileInputStream=new FileInputStream("C:\\test_files\\xiaopipi.ppt");
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream=new FileOutputStream("C:\\test_files\\3.ppt");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
        int len=0;
        byte [] buf =new byte[1024];
        while((len=bufferedInputStream.read(buf))!=-1)
        {
            bufferedOutputStream.write(buf,0,len);
        }
        long end=System.currentTimeMillis();
        System.out.println("copy3运行时间"+(end-start)+"ms");
    }

    /**
     * 千万不要使用，慢到怀疑人生
     * @throws IOException
     */
    public static void copy4() throws IOException {
        long start=System.currentTimeMillis();
        FileInputStream fileInputStream=new FileInputStream("C:\\test_files\\xiaopipi.ppt");
        FileOutputStream fileOutputStream=new FileOutputStream("C:\\test_files\\1.ppt");
        int ch=0;
        while ((ch=fileInputStream.read())!=-1)
        {
            fileOutputStream.write(ch);
        }
        fileInputStream.close();
        fileOutputStream.close();
        long end=System.currentTimeMillis();
        System.out.println("copy4运行时间"+(end-start)+"ms");
    }
}
