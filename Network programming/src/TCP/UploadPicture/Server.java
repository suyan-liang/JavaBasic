package TCP.UploadPicture;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:14:26;
 * Package Name:TCP.UploadPicture;
 * 需求：接受客户端的数据，并把数据放到 C:\test_files\TCP_receive\taihau.jpg
 * 步骤：
 *
 *
 * Buffed都要刷新,但是字节流无需\n
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(15965);
        Socket s=serverSocket.accept();
        System.out.println("IP:"+s.getInetAddress().getHostAddress()+"...has connected...");
        InputStream in=s.getInputStream();
        File dir=new File("C:\\test_files\\TCP_receive\\dir_test");
        if(!dir.exists())
            dir.mkdirs();
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(dir.getAbsolutePath()+"\\dapipi.ppt"));
        int len=0;
        byte[] buf=new byte[1024];
        while ((len=in.read(buf))!=-1)
        {
            bos.write(buf,0,len);
            bos.flush();
        }
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bufferedWriter.write("上传成功\n");
        bufferedWriter.flush();
        bos.close();
        s.close();
        serverSocket.close();
    }
}
