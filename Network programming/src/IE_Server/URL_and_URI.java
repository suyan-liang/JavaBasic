package IE_Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Author:liang;
 * Date:2020/3/2;
 * Time:20:02;
 * Package Name:IE_Server;
 * 需求：
 * 步骤：
 *
 *
 * URL 统一资源定位符
 * URI 统一资源标识符
 * 每个URL都是URI
 *
 * 我们平常的比如   https://www.bilibili.com/video/av35927212?p=427  都是URL  ?后面是个人的一些信息，会填到页面对应的变量值里
 * URL中包含着协议
 *
 * url可以进行http解析，不会再出现应答头
 *
 * URL可以直接通过openStream方法获取指定路径文件的输入流，获得了流之后就可以很轻松获得文件内容
 *
 */
public class URL_and_URI {
    public static void main(String[] args) throws IOException {
            String str_url="http://192.168.43.191:8080/myweb/test.html?name=zs";
            URL url=new URL(str_url);
            get_resource(url);
            //test_get(url);
    }

    /**
     * 测试URL的get方法
     * @param url
     */
    public static void test_get(URL url)
    {
        System.out.println("协议---"+url.getProtocol());
        System.out.println("IP---"+url.getHost());
        System.out.println("端口---"+url.getPort());
        System.out.println("文件（包括参数信息）---"+url.getFile());
        System.out.println("路径（不包含参数信息）---"+url.getPath());
        System.out.println("参数---"+url.getQuery());
    }

    /**
     * 直接使用openStream方法获取输入流,进而获得文件资源
     *
     *
     * openStream 方法相当于 openConnection().getInputStream()
     * openConnection方法返回url对象的连接器对象，将连接封装成了对象
     *
     *
     * url可以进行http解析，不会再出现应答头
     * @param url
     */
    public static void get_resource(URL url) throws IOException {
        /*
         * sun.net.www.protocol.http.HttpURLConnection:http://192.168.43.191:8080/myweb/test.html?name=zs
         * 这个包是底层的包，sun公司已经帮忙把http协议封装到里面了
         *         URLConnection uc=url.openConnection();
         *         System.out.println(uc);
         * 通过这个方法获得的uc对象相当于封装了http协议的socket对象
         *
         * 通过这个对象可以获得应答头的值，key，value
         *
         */

        InputStream in=url.openStream();
        byte[] buf=new byte[1024];
        int len=0;
        while ((len=in.read(buf))!=-1)
        {
            System.out.println(new String (buf,0,len));
        }
        in.close();
    }
}
