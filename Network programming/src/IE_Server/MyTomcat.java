package IE_Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:17:36;
 * Package Name:IE_Server;
 * 需求：测试一下浏览器向服务器发送的信息究竟是什么
 * 步骤：1.浏览器作为客户端，在搜索栏访问IP地址，就相当于Socket与客户端建立联系
 *
 */
public class MyTomcat {
    public static void main(String[] args) throws IOException {
        /*
         * 创建服务端口，接收客户端
         */
        ServerSocket serverSocket=new ServerSocket(9090);
        Socket s=serverSocket.accept();
        InetAddress ip=s.getInetAddress();
        System.out.println("IP"+ip.getHostAddress()+".....has connected!");

        /*
         * 接收客户端信息
         */
        InputStream in=s.getInputStream();
        byte []buf=new byte[1024];
        int len=0;
        len=in.read(buf);//循环的话会出错，奇怪....
        System.out.println(new String (buf,0,len));
        /*
         * 给客户端发送反馈信息
         */
        OutputStream out=s.getOutputStream();
        out.write("欢迎光临".getBytes("GBK"));
        s.close();
    }
}
