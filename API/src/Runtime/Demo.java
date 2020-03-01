package Runtime;

import java.io.IOException;

/**
 * Author:liang;
 * Date:2020/2/23;
 * Time:11:25;
 * Package Name:Runtime;
 * 需求：
 * 步骤：
 */
public class Demo {
    public static void main(String[] args) throws IOException, InterruptedException {
        /**
         * 没有构造函数，说明构造函数被私有化了，不能自己创建对象
         * 如果一个类没有构造函数，且不都是静态方法，那么至少有一个静态方法返回此对象、
         * Runtime使用单例设计模式，通过getRuntime()获取，可以用来调用程序
         *
         * 快捷抛异常的方法  把光标点到异常上，按alt+Enter
         */
        /**
         * 用于需要调用本地程序时
         * exec方法运行程序，里面是执行路径，如果找不到会去classpath找，再找不到就抛异常
         * 路径注意写/的时候要写成//，转义字符
         *
         * 可以用一个程序去解析一个文件如下
         *
         * exec返回一个进程，可以调用destroy()方法去灭掉进程
         * 但是要记住，只有用这个runtime打开的程序才能被destroy掉，其他的不行
         */
        Runtime runtime=Runtime.getRuntime();
        /*Process notepad=runtime.exec("notepad.exe");*/
        /*runtime.exec("notepad.exe C:\\test_files\\file");*/
         Process huyanbao=runtime.exec("C:\\Program Files (x86)\\护眼宝\\HuYanBao.exe");
        Thread.sleep(5000);
       /* notepad.destroy();*/
        huyanbao.destroy();
    }
}
