package TCP.MultiThread;

import java.io.*;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:15:28;
 * Package Name:TCP.MultiThread;
 * 需求：
 * 步骤：
 */
public class Picture_Cilent {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("192.168.43.191",15965);
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("C:\\test_files\\jialuo.jpg"));
        BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());
        byte[] buf=new byte[1024];
        int len=0;
        while((len=bis.read(buf))!=-1)
        {
            bos.write(buf,0,len);
            bos.flush();
        }
        socket.shutdownOutput();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ans=bufferedReader.readLine();
        System.out.println(ans);
        socket.close();
        bis.close();

    }
}
