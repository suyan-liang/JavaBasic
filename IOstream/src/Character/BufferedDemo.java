package Character;

import java.io.*;

/**
 * Author:liang;
 * Date:2020/2/24;
 * Time:17:28;
 * Package Name:Character;
 * 需求：
 * 步骤：
 * 感觉这个就像Cache
 */
public class BufferedDemo {
    public static void main(String[] args) throws IOException {
            test_buffered_writer();
            test_buffered_reader();
    }

    /**
     * 1.缓冲区和public int read(char[] cbuf)中的cbuf数组功能一致，是其封装，
     * 2.减少切换次数，提高读写效率
     * 3.BufferedWriter(Writer out) 创建缓冲区对象需指定被缓冲的对象
     * 4.newLine()是写一个行分隔符
     * 5.创建一个缓冲区对象，然后后面都使用其方法即可，缓冲区关闭其实就是关闭流
     */
    public static void test_buffered_writer() throws IOException {
        FileWriter fileWriter=new FileWriter("buffered.txt");
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        for (int i = 0; i < 4; i++) {
            bufferedWriter.write("abc"+i);
            bufferedWriter.newLine();//这个东西可以方便地换行，但也可以自定义LINE_SEPARATOR
            bufferedWriter.flush();//经常刷新
        }
        bufferedWriter.close();//缓冲区关闭流也会被关闭
    }

    /**
     * 1.BufferedReader(Reader in) 也需指定被缓冲对象
     * 2.String	readLine()  可读一行，行依据回车判断  读到结尾返回null
     * 3.read()方法被重写，这里的read方法是从缓冲区读，效率快
     * 4.readLine()使用了读取缓冲区的read方法，将读取到的字符进行缓冲并判断换行标记，将标记前的缓存数据变为字符串返回
     */
    public static void test_buffered_reader() throws IOException {
        FileReader fileReader=new FileReader("buffered.txt");
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String mid;
        while ((mid=bufferedReader.readLine())!=null)
        {
            System.out.println(mid);
        }
    }

}
