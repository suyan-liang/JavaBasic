package PipedStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 报错了，有问题!!!!!!!!!!
 */

/**
 * Author:liang;
 * Date:2020/2/28;
 * Time:10:54;
 * Package Name:PipedStream;
 * 需求：
 * 步骤：
 *
 * 1.输入流和输出流可以接上
 * 2.数据从管道输入流读取，由其他线程写入对应的管道输出流，支持多线程。如果单线程操作可能会死锁。
 * 3.输入流和输出流的连接，两种方法：第一种是构造函数，第二种是connect方法（输入流的方法）---void	connect(PipedOutputStream src)
 * 4.管道输出流是整个管道的输入方，管道输入流是整个管道的输出方。写再读。
 * 5.它们之间就像是量子纠缠，可以凭空传递，一个直接写，另一个直接读就能读到，只要连接起来就可以
 */
public class Demo {
    public static void main(String[] args) throws IOException {
            PipedOutputStream pout=new PipedOutputStream();
            PipedInputStream pin=new PipedInputStream();
            pin.connect(pout);
            Thread t1=new Thread(new Input(pin));
            Thread t2=new Thread(new Output(pout));
            t1.start();
            t2.start();


    }
}
class Input implements Runnable {
    private PipedInputStream input;

    public Input(PipedInputStream inputStream) {
        this.input = inputStream;
    }

    @Override
    public void run() {
        int len=0;
        byte[] bytes=new byte[1024];
        while (true)
        {
            try {
                 input.read(bytes);
                 //System.out.println(new String (bytes,0,len));
                System.out.println(new String (bytes));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
class Output implements Runnable{
    private PipedOutputStream pipedOutputStream;

    public Output(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        try {
            pipedOutputStream.write("hello!!!!!!!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}