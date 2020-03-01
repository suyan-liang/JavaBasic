package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Author:liang;
 * Date:2020/3/1;
 * Time:19:31;
 * Package Name:UDP;
 * 需求：
 * 步骤：
 */
class Receive_part implements Runnable {
    private DatagramSocket ds;

    public Receive_part(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {

        try {
            while (true) {
                /*
                 * 用while循环持续进行接收
                 */
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                ds.receive(dp);
                String address = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String text = new String(dp.getData(), 0, dp.getLength());
                System.out.println("数据来咯:" + text);
                System.out.println("address:" + address + ".......port:" + port);
                System.out.println("-------------------------------------");

            }
        } catch (Exception e) {

        }
        ds.close();
    }
}
class Send_part implements Runnable {
    private DatagramSocket ds;

    public Send_part(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            String line = null;
            try {
                if ((line = bfr.readLine()) != null) {
                    byte[] buf = line.getBytes();
                    DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.43.255"), 10050);//采用广播方式实现群聊
                    ds.send(dp);
                    if (line.equals("886")) {
                        break;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        ds.close();

    }
}
public class QQchat {
    public static void main(String[] args) throws SocketException {
        DatagramSocket send=new DatagramSocket();
        DatagramSocket rece=new DatagramSocket(10050);
        Send_part send_part=new Send_part(send);
        Receive_part receive_part=new Receive_part(rece);

        Thread tsend=new Thread(send_part);
        Thread trece=new Thread(receive_part);

        tsend.start();
        trece.start();
    }
}
