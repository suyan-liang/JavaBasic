package RandomAccessFile;

/**
 * Author:liang;
 * Date:2020/2/28;
 * Time:9:25;
 * Package Name:RandomAccessFile;
 * 需求：
 * 步骤：
 */

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * !!!!!!!!!!!!!!!!有问题，出现了乱码!!!!!!!!!!!!!!!!!!!!
 */
/**
 * 1.RandomAccessFile不在字节流，也不在字符流。不是IO体系
 * 2.就像C语言的文件操作
 * 3.既能读，又能写
 * 4.该对象内部维护了一个byte数组，通过指针操作数组中的元素
 * 5.通过getFilePointer方法获取指针位置，通过seek方法设置指针位置
 * 6.该对象就是将字节输入流和字节输出流进行封装
 * 7.该对象只能用来操作File,指定访问模式 r只读,rw读写,rws底层,rwd底层
 * 8.RandomAccessFile(File file, String mode)          RandomAccessFile(String name, String mode)
 *
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        //RAF_write();
        RAF_read();
}

    /**
     * 1.进行写操作时
     * 如果是写字符串，不要使用public final void writeBytes(String s)，这个函数只写低八位
     * 也就是说，凡是使用write或者writeBytes之类的函数，都只写低八位（byte大小）的数据，
     * 所以如果数据超出128，必须使用专门的写方法writeInt()之类
     * 2.没有文件就创建文件，有文件就不创建。而输出流是不管有没有都创建新文件
     * 3.多线程操作时，利用seek指定各个线程写的位置可以实现多线程的写
     * @throws IOException
     */
    public static void RAF_write() throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("randomacc.txt"), "rw");
        randomAccessFile.write("旺财".getBytes());//一个文字是由两个字节组成，所以不会超byte
        randomAccessFile.writeInt(123);
        randomAccessFile.write("大黄".getBytes());
        randomAccessFile.writeInt(78);
        randomAccessFile.close();
    }

    /**
     * 读文件
     * 1.读文件也有类似于写文件那样针对类型专门的方法readInt等
     * 2.通过getFilePointer方法获取指针位置（数组下标），通过seek方法设置指针位置，按字节设置  从而实现随机读取
     * @throws IOException
     */
    public static void RAF_read() throws IOException
    {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("randomacc.txt"), "r");
        randomAccessFile.seek(8);
        System.out.println(randomAccessFile.getFilePointer());
        byte[] buf=new byte[4];
        randomAccessFile.read(buf);
        String name=new String(buf);
        int age=randomAccessFile.readInt();
        System.out.println("name="+name+"...age="+age);
        randomAccessFile.close();
    }
}
