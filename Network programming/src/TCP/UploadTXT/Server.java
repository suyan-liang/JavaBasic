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
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(12345);
        Socket s=serverSocket.accept();
        System.out.println("-----文件上传客户端-----");
        System.out.println("IP....."+s.getInetAddress().getHostAddress()+"has connected!...........");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("C:\\test_files\\TCP_receive\\received.txt"));
        String text=null;
        while((text=bufferedReader.readLine())!=null)
        {
            bufferedWriter.write(text+"\n");//都加上吧
            bufferedWriter.flush();
        }
        System.out.println("已接收");
        s.close();
        bufferedWriter.close();
        serverSocket.close();
    }
}
