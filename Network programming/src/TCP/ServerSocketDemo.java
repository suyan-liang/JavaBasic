package TCP;

/**
 * Author:liang;
 * Date:2020/3/1;
 * Time:21:03;
 * Package Name:TCP;
 * 需求：
 * 步骤：
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 建立TCP服务端的步骤 以把客户端数据打印在控制端为例
 * 1.创建服务端socket服务，通过SeverSocket对象  服务端必须对外提供一个端口，否则客户端无法连接
 * 2.获取连接来的客户端对象
 * 3.通过客户端对象获取socket输入流读取客户端发来的数据
 * 4.关闭资源，客户端和服务端，否则会耗费资源
 */
public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        //建立服务端
        ServerSocket serverSocket=new ServerSocket(12345);//服务端可以接受此端口的所有客户端
        //获取连接对象并读取客户端请求
        Socket s=serverSocket.accept();
        InputStream in=s.getInputStream();
        byte[] buf=new byte[1024];//先假定
        int len=0;
//        while((len=in.read(buf))!=-1)
//        {
//            System.out.println("text"+new String (buf,0,len));
//        }      ???????
        len=in.read(buf);
        String text=new String(buf,0,len);
        System.out.println(text);
        //向客户端发送数据
        OutputStream out=s.getOutputStream();
        String ans="数据balabala";
        out.write(ans.getBytes());

        s.close();
        serverSocket.close();//这里服务端只使用了一次，所以就关了。一般不关
    }
}
