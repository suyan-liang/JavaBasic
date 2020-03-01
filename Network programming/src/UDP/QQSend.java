package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Author:liang;
 * Date:2020/3/1;
 * Time:19:11;
 * Package Name:UDP;
 * 需求：
 * 步骤：
 */
public class QQSend {
    public static void main(String[] args) throws IOException {
        //1.建立socket
        DatagramSocket ds = new DatagramSocket();
        //2.封装数据到包中
        BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=bfr.readLine())!=null)
        {
            byte[] buf = line.getBytes();
            //必须是字节，第二个参数是要发送数据的数组长度，第三个参数是IP对象，第四个参数是应用层的那个标识端口
            DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.43.191"), 10000);
            //3.发送
            ds.send(dp);
            if(line.equals("886"))
            {
                break;
            }
        }
        ds.close();
    }
}
