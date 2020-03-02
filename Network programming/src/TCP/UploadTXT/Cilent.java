package TCP.UploadTXT;

import java.io.*;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:12:51;
 * Package Name:TCP.UploadTXT;
 * 需求：把C:\\test_files\\xiaopipi.ppt上传到服务器
 * 步骤：先测试一下小文件，然后测试发送大文件（碎片化，拼接）
 *
 *
 * 注意：FileReader和FileWriter只能操作文本而不能操作PPT文件!!!!!!
 *
 *
 *
 * 也可以用PrintWriter代替BufferedWriter进行输出，参数置为true，println  这样就无须考虑Buffered存在的问题
 * 凡是用到BufferedWriter  一\n 二刷新   千万别忘，不然会shi
 *
 *
 *
 */
public class Cilent {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("192.168.43.191",12345);
        BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\test_files\\123.txt"));
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String text=null;

        while((text=bufferedReader.readLine())!=null)
        {
            bufferedWriter.write(text+"\n");//有readLine()等着的时候一定要加"\n"
            bufferedWriter.flush();
        }
//        bufferedWriter.write("over"+"\n");
//        bufferedWriter.flush();
        socket.shutdownOutput();
        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ans=in.readLine();
        System.out.println(ans);
        bufferedReader.close();
        socket.close();
    }
}
