package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Author:liang;
 * Date:2020/3/1;
 * Time:19:11;
 * Package Name:UDP;
 * 需求：
 * 步骤：
 */
public class QQReceive {
    public static void main(String[] args) throws IOException {
        while (true){
            /*
             * 用while循环持续进行接收
             */
            DatagramSocket ds=new DatagramSocket(10000);
            byte[] buf=new byte[1024];
            DatagramPacket dp=new DatagramPacket(buf,buf.length);
            ds.receive(dp);
            String address=dp.getAddress().getHostAddress();
            int port=dp.getPort();
            String text=new String (dp.getData(),0,dp.getLength());
            System.out.println("数据来咯:"+text);
            System.out.println("address:"+address+".......port:"+port);
            System.out.println("-------------------------------------");
            ds.close();
        }

    }
}
