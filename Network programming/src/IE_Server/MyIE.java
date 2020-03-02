package IE_Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:19:04;
 * Package Name:IE_Server;
 * 需求：模仿浏览器，向Tomcat请求文件资源，看能不能得到来自Tomcat的数据
 * 步骤：
 */
public class MyIE {
    public static void main(String[] args) throws IOException {
        /*
         *  创建socket连接，并发送请求
         */
        Socket socket=new Socket("192.168.43.191",8080);
        PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
        printWriter.println("GET /myweb/test.html HTTP/1.1");
        printWriter.println("Accept:*/*");
        printWriter.println("Host: 192.168.43.191:8080");
        printWriter.println("Connection: close");
        printWriter.println();

        /*
         *  接收服务器返回的资源
         */
        InputStream in=socket.getInputStream();
        byte[] buf=new byte[1024];
        int len=in.read(buf);
        System.out.println(new String(buf,0,len));
        socket.close();
    }
}
