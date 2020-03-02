package TCP.MultiThread;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:15:31;
 * Package Name:TCP.MultiThread;
 * 需求：
 * 步骤：
 */
public class UploadTask implements Runnable {
    private Socket s;

    public UploadTask(Socket s) {
        this.s = s;
    }

    /**
     * 线程任务
     */
    @Override
    public void run() {
        try{
            /*
             *  获取登录IP对象并打印显示
             */
            InetAddress ip=s.getInetAddress();
            System.out.println("IP:"+ip.getHostAddress()+"...has connected...");
            /*
             * 进行文件健壮性判断
             * 1.创建文件夹，mkdirs
             * 2.判断文件是否已存在，重名机制
             */
            File dir=new File("C:\\test_files\\TCP_receive\\dir_test");
            if(!dir.exists())
                dir.mkdirs();
            File file=new File(dir,ip.getHostAddress()+".jpg");
            int count=0;
            while(file.exists())
            {
                count++;
                file=new File(dir,ip+"("+count+")"+".jpg");
            }

            /*
             * 从socket流中读取数据并写入指定文件夹
             */
            InputStream in=s.getInputStream();
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file));
            int len=0;
            byte[] buf=new byte[1024];
            while ((len=in.read(buf))!=-1)
            {
                bos.write(buf,0,len);
                bos.flush();
            }

            /*
             * 给客户端反馈
             */
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bufferedWriter.write("上传成功\n");
            bufferedWriter.flush();
            /*
             * 关闭资源
             */
            bos.close();
            s.close();
        }catch (IOException e)
        {

        }
        finally {

        }


    }
}
