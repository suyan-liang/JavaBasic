package Test;

import java.io.*;
import java.net.URL;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:20:38;
 * Package Name:Test;
 * 需求：
 * 步骤：
 */
public class PhotoDowload {
    public static void main(String[] args) throws IOException {
        String photo_url="http://img03.sogoucdn.com/app/a/100520093/3c28af542f2d49f7-8331c86ff317d9f5-8ee52078d03feac9b8502dad26f33c31.jpg";
        PhotoCrawler(photo_url);
    }
    public static void PhotoCrawler(String net) throws IOException {
        //获取资源流
        URL url=new URL(net);
        BufferedInputStream in=new BufferedInputStream(url.openStream());
        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(new File("C:\\test_files\\test.jpg")));
        int len=0;
        byte[] buf=new byte[1024];
        while ((len=in.read(buf))!=-1)
        {
            out.write(buf,0,len);
            out.flush();
        }
        System.out.println("下载成功");
        out.close();
    }
}
