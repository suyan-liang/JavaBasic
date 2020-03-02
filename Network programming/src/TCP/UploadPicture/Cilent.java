package TCP.UploadPicture;

import java.io.*;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:14:26;
 * Package Name:TCP.UploadPicture;
 * 需求：把 C:\test_files\jialuo.jpg 上传到服务端
 * 步骤：
 */
public class Cilent {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("192.168.43.191",15965);
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("C:\\test_files\\xiaopipi.ppt"));
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
