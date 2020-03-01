package UDP;

/**
 * Author:liang;
 * Date:2020/3/1;
 * Time:18:10;
 * Package Name:UDP;
 * 需求：
 * 步骤：
 */

/**
 * 通信的两端都有socket。数据在两个socket之间进行传输
 * 可以看出接受数据的口，没有socket无法完成通讯
 *
 */

import java.io.IOException;
import java.net.*;

/**
 * 把SendSocketDemo和ReceiveSocketDemo放在两个java文件
 * 先运行receive再运行send可以实现演示效果
 */


/**
 * DategramSocket
 * 1.既能接收又能发送
 * 2.有send和receive方法进行发送和接受
 *
 *
 * DategramPacket
 * 1.数据报包
 * 2.这个包可以用来封装发送的数据和接受数据
 */
/**
 * 创建UDP的发送端
 * 1.建立UDP的socket服务                 	DatagramSocket()
 * 2.将要发送的数据封装到数据报包            DatagramPacket(byte[] buf, int length, InetAddress address, int port)
 * 3.同过socket服务把数据报包发送出去        void	send(DatagramPacket p)
 * 4.关闭socket                             void	close()
 */
public class SendSocketDemo {
    public static void main(String[] args) throws IOException {
        //1.建立socket
        DatagramSocket ds = new DatagramSocket();
        //2.封装数据到包中
        String str = "hello socket!!!";
        byte[] buf = str.getBytes();
        //必须是字节，第二个参数是要发送数据的数组长度，第三个参数是IP对象，第四个参数是应用层的那个标识端口
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.43.191"), 10000);
        //3.发送
        ds.send(dp);
        ds.close();
    }

}
