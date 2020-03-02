package TCP.UploadTXT;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:12:51;
 * Package Name:TCP.UploadTXT;
 * 需求：接收客户端上传的数据，并存放在C:\\test_files\\TCP_receive文件夹中
 * 步骤：
 *
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 又出现了服务端与客户端相互等待的情况
 * 原因：
 * 服务端的读的那个循环没有结束
 * 客户端发一句，服务端读一句
 * 再发一句，再读一句
 * ...
 * 客户端发完最后一句，服务端读了这最后一句
 * 客户端退出循环了，服务端不知道，仍在等待
 *
 * 要让客户端告诉服务端结束，服务端才会结束
 *
 * 添加一个over标志但是这样不安全
 * 标准  void	shutdownOutput() 使用socket的此函数可以在输出流的末尾添加结束标志
 *       void	shutdownInput()                         输入流
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(12345);
        Socket s=serverSocket.accept();
        System.out.println("-----文件上传客户端-----");
        System.out.println("IP....."+s.getInetAddress().getHostAddress()+"has connected!...........");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("C:\\test_files\\TCP_receive\\accept.txt"));
        String text=null;
        while((text=bufferedReader.readLine())!=null)
        {
//            if(text.equals("over"))
//                break;
            System.out.println(text);
            bufferedWriter.write(text+"\n");//都加上吧
            bufferedWriter.flush();
        }
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        out.write("上传成功"+"\n");
        out.flush();
        s.close();
        bufferedWriter.close();
        serverSocket.close();
    }
}
