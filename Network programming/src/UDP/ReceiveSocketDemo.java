package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Author:liang;
 * Date:2020/3/1;
 * Time:19:01;
 * Package Name:UDP;
 * 需求：
 * 步骤：
 */
/**
 * 创建UDP的接收端
 * 1.建立UDP的socket服务，必须明确端口号
 * 2.创建数据报包，通过数据报包解析数据（此时里面没数据）
 * 3.使用socket的receive服务将数据接受到数据报包里
 * 4.通过数据报包的方法解析数据
 * 5.关闭socket
 */
public class ReceiveSocketDemo {
    public static void main(String[] args) throws IOException {
        //1.创建socket
        DatagramSocket ds=new DatagramSocket(10000);
        //2.创建报包以及作为参数的数组
        byte[] buf=new byte[1024];//这个数组足够大了。如果不够还要写循环的
        DatagramPacket dp=new DatagramPacket(buf,buf.length);
        //3.把数据接收到包
        ds.receive(dp);
        //4.通过报包的方法解析数据，比如地址，端口，数据内容
        String address=dp.getAddress().getHostAddress();
        int port=dp.getPort();
        String text=new String (dp.getData(),0,dp.getLength());  //getData方法返回一个byte数组
        System.out.println("数据来咯"+text);
        System.out.println("address:"+address+".......port:"+port);
        //5.关闭资源
        ds.close();
    }
}
