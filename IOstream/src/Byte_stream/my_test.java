package Byte_stream;

import java.io.*;

/**
 * Author:liang;
 * Date:2020/2/25;
 * Time:15:46;
 * Package Name:Byte_stream;
 * 需求：
 * 步骤：
 */
public class my_test {
    public static void main(String[] args) throws IOException {
            myfunc();
    }
    public static void myfunc() throws IOException {
       // InputStream inputStream=System.in;
        BufferedInputStream bufferedInputStream=new BufferedInputStream(System.in);
        InputStreamReader inputStreamReader=new InputStreamReader(bufferedInputStream);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new BufferedOutputStream(System.out));
        int c=inputStreamReader.read();
        outputStreamWriter.write(c);
        inputStreamReader.close();
        outputStreamWriter.close();
    }
}
