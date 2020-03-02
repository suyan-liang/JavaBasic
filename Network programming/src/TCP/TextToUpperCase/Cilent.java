package TCP.TextToUpperCase;

import java.io.*;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:9:15;
 * Package Name:TCP;
 * 需求：把一串英文数据发给服务端，并接收服务端返回的数据打印在控制台上
 * 步骤：1.创建与服务端的socket连接
 *       2.把从键盘录入的数据发送给服务端
 *       3.接收来自客户端的数据
 *       4.把数据打印在控制台上
 *
 *
 * 总结出现的问题
 * 1."\n"的问题   使用BufferedWriter的时候一定要注意这个问题!!!!!!!!!   锅在readLine,标记问题
 * 2.边写边读的问题，不然丢包
 * 3.flush的问题   使用BufferedWriter的时候一定要注意这个问题!!!!!!!!!
 *
 * https://blog.csdn.net/cc007cc009/article/details/79128388
 */
public class Cilent {
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket("192.168.43.191",55555);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String text=null;
        BufferedReader bufferedReader1=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while((text=bufferedReader.readLine())!=null)
        {
            if(text.equals("over"))
                break;
            bufferedWriter.write(text+"\n");
            bufferedWriter.flush();
            String ans=bufferedReader1.readLine();
            System.out.println(ans);
        }
        socket.close();
    }
}
