package SequenceInputStream;

/**
 * Author:liang;
 * Date:2020/2/27;
 * Time:18:48;
 * Package Name:SequenceInputStream;
 * 需求：把一文件切割成碎片文件，再重新组合形成这个文件
 * 步骤：
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 问题：怎么能知道碎片文件的个数，怎么能知道源文件的后缀名----配置文件
 */


public class File_Divide {
    /**
     * main函数用于测试
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
       //spilt(new File("C:\\test_files\\csInternet.pdf"));
       merge_files(new File("C:\\test_files\\divided_files"));
    }

    /**
     * 怎么切？1.按大小切√  2.按份数切×
     * 切割文件时，必须使用配置文件记录切割文件的名称以及切割出的碎片的个数，以方便合并
     * @param file  需要被切割的文件
     */
    public static void spilt(File file) throws IOException {
        /*
         * 1.设置要放置碎片文件的文件夹
         */
        File dir=new File("C:\\test_files\\divided_files");
        if(!dir.exists())
            dir.mkdirs();

        /*
         * 2.正常进行文件的输入流输出流操作，不同的是一个输出流多次使用，每读一次buf，输出到一个碎片文件中，利用计数器count完成
         */
        FileInputStream fileInputStream =new FileInputStream(file);
        byte[] buf=new byte[1024*1024];//设定切割文件的大小，1M
        int len=0;
        int count=0;
        //只需要一个输出流，先定义为null
        FileOutputStream outputStream=null;
        while ((len=fileInputStream.read(buf))!=-1)//read(buf)的原理别忘
        {
            outputStream=new FileOutputStream(new File(dir,(count++)+".part"));
            outputStream.write(buf,0,len);
            outputStream.close();//每一个循环后关闭即可，毕竟下一次的文件是另一个碎片文件
        }


        /*
         * 3.生成配置文件
         */
        Properties properties=new Properties();
        properties.setProperty("name",file.getName());
        properties.setProperty("number",count+"");
        FileOutputStream fileOutputStream=new FileOutputStream(new File(dir,count+".properties"));
        properties.store(fileOutputStream,"file of properties");

        /*
         * 4.关闭流
         */
        fileOutputStream.close();
        fileInputStream.close();

    }


    /**
     * 必须先获取配置文件信息
     * 就是使用序列流进行合并
     * @param dir 碎片文件目录
     */
    public static void merge_files(File dir) throws IOException {
        /**
         * 1.过滤.properties后缀名的文件，获取配置文件并判断配置文件的个数和碎片文件的个数。把碎片文件放到一个文件数组中
         */
        File[] files=dir.listFiles(new myFileFilter(".properties"));
        if(files.length!=1)
            throw new RuntimeException("没有properties后缀名文件或者个数多于一个");
        Properties properties=new Properties();
        FileInputStream fs=new FileInputStream(files[0]);
        properties.load(fs);
        String name=properties.getProperty("name");
        int count=Integer.parseInt(properties.getProperty("number"));
        File[] partfiles=dir.listFiles(new myFileFilter(".part"));
        if(partfiles.length!=count)
            throw new RuntimeException("碎片文件个数不对");

        /**
         * 2.创建序列流进行合并
         */
        ArrayList<FileInputStream> arrayList=new ArrayList<FileInputStream>();
        for(int i=0;i<count;i++)
        {
            arrayList.add(new FileInputStream(partfiles[i]));

        }
        Enumeration<FileInputStream> en= Collections.enumeration(arrayList);
        SequenceInputStream sequenceInputStream=new SequenceInputStream(en);
        FileOutputStream fileOutputStream=new FileOutputStream(new File(dir,name));
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=sequenceInputStream.read(bytes))!=-1)
        {
            fileOutputStream.write(bytes,0,len);
        }

        /*
         * 3.关闭文件
         */
        fileOutputStream.close();
        sequenceInputStream.close();

    }

}
/**
 * 文件过滤器
 */
class myFileFilter implements FileFilter
{
    private String name;

    public myFileFilter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean accept(File pathname) {
        String file_name=pathname.getName();
        if (file_name.endsWith(this.name))
            return true;
        else
            return false;
    }
}