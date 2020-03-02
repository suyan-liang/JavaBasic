package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/1;
 * Time:21:03;
 * Package Name:TCP;
 * 需求：
 * 步骤：
 */

/*
 * 客户端套接字
 * 所谓客户端，既然一样，那存在意义？为什么不设置一样？
 *
 * 构造时要指定发送端的IP地址以及端口号      	Socket(InetAddress address, int port)     	Socket(String host, int port)
 *
 * 网络中进行数据传输也是一种IO流，调用底层资源，既有输入又有输出。想要流对象，需找socket对象获取
 * 使用getOutputStream和getInputStream来获取这两个流
 *
 * TCP传输 客户端建立并向服务端发送数据
 * 1.创建socket服务，使用Socket，指定IP和端口
 * 2.如果连接成功，说明数据连接通道已建立
 * 3.使用输出流，将数据写出
 * 4.关闭资源,把socket关闭即可
 *
 *
 */
public class SocketDemo {
    public static void main(String[] args) throws IOException {
        //客户端和服务端建立连接并发送数据
        Socket socket=new Socket("192.168.43.191",12345);
        OutputStream out =socket.getOutputStream();
        out.write("TCP demo".getBytes());

        //获取从服务端返回的数据
        InputStream in=socket.getInputStream();
        byte[] buf=new byte[1024];
        int len=0;
//        while ((len=in.read(buf))!=-1)
//        {
//            System.out.println("服务端返回数据"+new String (buf,0,len));
//        }    为什么用这个就不行？？？也没那么多数据啊
        len=in.read(buf);
        String text=new String(buf,0,len);
        System.out.println(text);
        socket.close();
    }
}
