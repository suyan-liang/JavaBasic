package Character;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author:liang;
 * Date:2020/2/24;
 * Time:9:49;
 * Package Name:Character;
 * 需求：
 * 步骤：
 */
public class FileReaderDemo {
    public static final String LINE_SEPARATOR=System.getProperty("line.separator");
    public static void main(String[] args) throws IOException {
        //FileReader_test();
        read_cbuf();
    }

    /**
     * 1.public int read()读取单个字符，返回字符的ASCII码值,可以用强制类型转换转为字符
     * 2.-1表示文件结尾，C++中的EOF
     * @throws FileNotFoundException
     */
    public static void FileReader_test() throws IOException {
        FileReader fileReader=new FileReader("demo.txt");//必须要确保文件要存在
        int ch;
        while((ch=fileReader.read())!=-1)
        {
            System.out.println((char)ch);
        }
    }

    /**
     * 1.public int read(char[] cbuf) 一次读取一个字符存入数组，返回值是读取的字符数，如果没有读取到字符返回-1
     * 一次读取一个字符进数组，直到达到数组长度或者读到尾（一次性完成）
     * 换行是一个字符\r会被当做一个字符来读，所以就实现换行了
     * @throws IOException
     */
    public static void read_cbuf() throws IOException {
        FileReader fileReader=new FileReader("demo.txt");
        char[] cbuf=new char[1024];//一般指定这个大小为1024的整数倍
        int len=0;
        int cnt=0;
        while ((len=fileReader.read(cbuf))!=-1)
        {
            cnt++;
            System.out.println(new String(cbuf,0,len));
        }
        System.out.println("cnt="+cnt);
    }
}
