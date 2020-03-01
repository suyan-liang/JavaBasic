package BasicElement;

/**
 * Author:liang;
 * Date:2020/3/1;
 * Time:15:01;
 * Package Name:BasicElement;
 * 需求：
 * 步骤：
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *   InetAddress类,静态方法居多
 *   没有构造函数
 */
public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {
            easy_test();
    }

    public static void easy_test() throws UnknownHostException {
        /*
         * 获取本地IP地址对象
         */
        InetAddress ip=InetAddress.getLocalHost();
        System.out.println("本地主机名"+ip.getHostName());
        System.out.println("本地主机地址"+ip.getHostAddress());


        /*
         * 获取其他IP地址对象
         *
         * static InetAddress	getByName(String host) 给定主机名，可获取IP对象。参数也可以是IP地址的字符串形式
         */
        ip=InetAddress.getByName("www.baidu.com");//域名
        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());
    }
}
/*
 * 域名：由于IP地址不好记，所以产生了域名
 *
 * 输入域名，回车，会先去找hosts文件解析，如果失败则自动去互联网DNS解析得到IP地址，再根据IP地址找到目的地
 *
 * DNS---域名解析服务器
 * DNS不止一个，DNS也对应这IP地址，这个地址或者是通信商的或者是自己指定的
 * 也可以自己创建一张DNS对应表：就是hosts文件woc....
 *
 *
 * 所以可用通过修改hosts文件来防止小孩打开网页
 * 把某个网站对应的IP改成127.0.0.1就可以了
 *
 */