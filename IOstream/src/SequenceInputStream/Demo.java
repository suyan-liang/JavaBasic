package SequenceInputStream;

/**
 * Author:liang;
 * Date:2020/2/27;
 * Time:13:40;
 * Package Name:SequenceInputStream;
 * 需求：
 * 步骤：
 */

/**
 * 1.只负责源，可以用来合并数据
 *   作用应用：文件切割成碎片文件发过去，把碎片文件进行合并可以得到完整的文件
 * 2.本质上就是Java帮你把多个输入流封装成的一个输入流，可以智能判断哪个是最后一个流从而读完最后一个就停止。顺序很严格
 * 3.构造函数，多个使用SequenceInputStream(Enumeration<? extends InputStream> e)，
 *             两个使用SequenceInputStream(InputStream s1, InputStream s2)，先操作s1，再操作s2
 * 4.获取枚举对象，使用vector里面的elements方法
 * 5.使用ArrayList来使用序列流的方法：由于枚举和迭代器功能一致，所以可以使用迭代器来进行override枚举对象的方法，但太复杂
 *   更高效的方法，static <T> Enumeration<T>	enumeration(Collection<T> c)  使用这个方法获取一个枚举对象，然后剩下的都一样
 *   Collections.enumeration()
 */

import java.io.*;
import java.util.*;

/**
 * 需求：把buffered.txt,copy.txt,demo.txt合并成一个文件union.txt
 */
public class Demo {
    public static void main(String[] args) throws IOException {
            //union();
            arraylist_version();
    }
    public static void union() throws IOException {
        //想要序列流，先整一个输入流的枚举序列
        Vector<FileInputStream> vector=new Vector<FileInputStream>();
        vector.add(new FileInputStream("buffered.txt"));
        vector.add(new FileInputStream("copy.txt"));
        vector.add(new FileInputStream("demo.txt"));
        Enumeration<FileInputStream> en=vector.elements();
        System.out.println("hello");

        //再创建序列流对象
        SequenceInputStream sequenceInputStream=new SequenceInputStream(en);
        //然后再正常读写即可
        //读取操作：水管,一个碗，一个len
        FileOutputStream fileOutputStream=new FileOutputStream("union.txt");
        byte[] buf=new byte[1024];
        int len=0;
        while((len=sequenceInputStream.read(buf))!=-1)
        {
            fileOutputStream.write(buf,0,len);
        }
        fileOutputStream.close();
        sequenceInputStream.close();
    }

    /**
     * ArrayList的方法，把store.txt,union.txt,woc.txt放到buffered.txt中
     */
    public static void arraylist_version() throws IOException {
        ArrayList<FileInputStream> arrayList=new ArrayList<FileInputStream>();
        arrayList.add(new FileInputStream(new File("store.txt")));
        arrayList.add(new FileInputStream(new File("union.txt")));
        arrayList.add(new FileInputStream(new File("woc.txt")));
        Enumeration<FileInputStream> en= Collections.enumeration(arrayList);
        SequenceInputStream sequenceInputStream=new SequenceInputStream(en);
        FileOutputStream fileOutputStream= new FileOutputStream("buffered.txt");
        byte[] buf=new byte[1024];
        int len=0;
        while ((len=sequenceInputStream.read(buf))!=-1)
        {

            fileOutputStream.write(buf,0,len);
        }
        fileOutputStream.close();
        sequenceInputStream.close();
    }
}
