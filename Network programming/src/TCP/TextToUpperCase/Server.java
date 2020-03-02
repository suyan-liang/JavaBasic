package TCP.TextToUpperCase;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:9:35;
 * Package Name:TCP.TextToUpperCase;
 * 需求：接收来自客户端的数据，把该数据转化为大写，并返回到客户端
 * 步骤：1.创建ServerSocket端口
 *       2.接收连接服务端的客户端对象并获取来自客户端的数据
 *       3.把数据转为大写
 *       4.发送回客户端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1
        ServerSocket serverSocket=new ServerSocket(55555);
        //2
        Socket s=serverSocket.accept();
        System.out.println("IP:"+s.getInetAddress().getHostAddress()+"...has  connected!");
        System.out.println("接收的socket"+s.toString());
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String mid=null;
        while((mid=bufferedReader.readLine())!=null)
        {
            System.out.println(mid);
            bufferedWriter.write(mid.toUpperCase()+"\n");
            bufferedWriter.flush();
        }
        s.close();
    }
}
