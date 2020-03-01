package Character;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Author:liang;
 * Date:2020/2/24;
 * Time:15:00;
 * Package Name:Character;
 * 需求：将demo.txt复制，另一个文件取名copy.txt
 * 步骤：
 */
public class CopyDemo {
    private static final String LINE_SEPARATOR=System.getProperty("line.separator");
    public static void main(String[] args) throws IOException {
            copy();
    }

    /**
     * 将demo.txt中的数据复制到copy.txt
     * 一般写法
     * @throws IOException
     */
    public static void copy() throws IOException {
        FileReader fileReader=new FileReader("demo.txt");
        FileWriter fileWriter=new FileWriter("copy.txt");
        char[] mid=new char[1024];
        while(fileReader.read(mid)!=-1) {
            fileWriter.write(mid);
        }
        fileReader.close();
        fileWriter.close();
    }

    /**
     * 标准写法
      */
    public static void standard_copy()  {
        FileReader fileReader=null;
        FileWriter fileWriter=null;
        try {
            fileReader=new FileReader("demo.txt");
            fileWriter=new FileWriter("copy.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileReader!=null)
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(fileWriter!=null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
