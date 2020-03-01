package Character;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Author:liang;
 * Date:2020/2/25;
 * Time:9:48;
 * Package Name:Character;
 * 需求：
 * 步骤：
 *
 */

/**
 * 也是一个装饰类
 * 就和visual c++那个插件
 * 似的，把filereader放到里面
 * 就可以获取行号，可以指定行号起始值
 */
public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
    System.out.println("默认");
    default_linenumber();
    System.out.println("--------------------------");
    System.out.println("指定");
    zhiding_linenumber();

    }

    /**
     *
     *          行号默认从1开始，当然也可以指定
     *
     * @throws IOException
     */
    public static void default_linenumber() throws IOException {
        FileReader fileReader=new FileReader("buffered.txt");
        LineNumberReader lineNumberReader=new LineNumberReader(fileReader);
        String mid=null;
        while ((mid=lineNumberReader.readLine())!=null)
        {
            System.out.println(lineNumberReader.getLineNumber()+"...."+mid);
        }
        lineNumberReader.close();
        System.out.println();
    }

    /**
     * 指定行号
     * @throws FileNotFoundException
     */
    public static void zhiding_linenumber() throws IOException {
        FileReader fileReader=new FileReader("buffered.txt");
        LineNumberReader lineNumberReader=new LineNumberReader(fileReader);
        String mid=null;
        lineNumberReader.setLineNumber(100);
        while ((mid=lineNumberReader.readLine())!=null)
        {
            System.out.println(lineNumberReader.getLineNumber()+"...."+mid);
        }
        lineNumberReader.close();
        System.out.println();
    }


}
