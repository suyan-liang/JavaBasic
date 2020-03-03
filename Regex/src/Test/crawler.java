package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:19:40;
 * Package Name:Test;
 * 需求：网页爬虫  就是用程序在互联网上获取符合规则的数据
 * 步骤：
 *
 *
 * 获取一个网页的所有邮箱
 */
public class crawler {
    public static void main(String[] args) throws IOException {
        List<String >  mails=getMailByWeb();
        for (String mail : mails) {
            System.out.println(mail);
        }
    }

    /**
     * 获取一个网页的所有邮箱
     *
     * 1.读取源文件
     * 2.对读取到的数据进行正则匹配，获取符合规则的数据
     * 3.将符合规则的数据存储到集合中
     *
     *
     */
    public static List<String> getMailByWeb() throws IOException {
        //获取资源的流
        URL url=new URL("http://blog.sina.com.cn/s/blog_147f99d5d0102vmyv.html");
        BufferedReader in=new BufferedReader(new InputStreamReader(url.openStream()));
        //读取源文件并进行匹配
        List<String > mails=new ArrayList<String >();
        String mail_regex="\\w+@+\\w+(\\w+\\.\\w+)+";//邮箱正则
        Pattern pattern=Pattern.compile(mail_regex);
        String text=null;
        while ((text=in.readLine())!=null)
        {
            Matcher m=pattern.matcher(text);
            while(m.find())
            {
                mails.add(m.group());//把符合规则的数据存储到集合中
            }
        }
        return mails;
    }
}
