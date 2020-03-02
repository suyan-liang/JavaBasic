package TCP.MultiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:14:57;
 * Package Name:TCP.MultiThread;
 * 需求：
 * 步骤：
 *
 * 服务端原理
 * 一个监视器端口
 * while(true)
 * 接收客户端对象，封装到单独的线程里面，关闭客户端
 *
 * ServerSocket serversocket =new Serversocket(port);
 * while(true)
 * {
 *     Socket s=serversocket.accept();
 *     new Thread(new Task(s)).start();//在Task中进行s的关闭
 * }
 *
 *
 */
public class PictureServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(15965);
        while (true)
        {
            Socket s=serverSocket.accept();
            new Thread(new UploadTask(s)).start();
        }
    }
}
