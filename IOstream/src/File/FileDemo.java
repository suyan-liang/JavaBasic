package File;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

/**
 * Author:liang;
 * Date:2020/2/25;
 * Time:20:32;
 * Package Name:File;
 * 需求：
 * 步骤：
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        //file_constructor();
        //file_getfunc();
        //create_delete();
        //judge();
        //rename_test();
        //root();
        //get_below();
        //zone();
        //FilenameFilter_test();
        listFiles_test();
    }

    /**
     * 构造函数测试
     * 文件对象既可以存文件又可以存文件夹
     * 只是文件对象，创建文件对象并不会创建真正的文件，createNewFile()才行
     */
    public static void file_constructor()
    {
        //第一种，直接上路径
        File file1=new File("C:\\test_files");
        //第二种，父路径加子路径
        File file2=new File("C:\\test_files","xiaopipi.ppt");
        //第三种，文件加子路径
        File file3=new File("C:\\test_files");
        File file4=new File(file3,"file.txt");
        //跨平台时，文件名称分隔符  File.separator；路径序列分隔符  File.pathSeparator
        File file5=new File("C:"+File.separator+"test_files");
        System.out.println(file5);
    }

    /**
     * 文件的获取方法
     */
    public static void file_getfunc()
    {
        File file=new File("C:\\test_files","xiaopipi.ppt");
        File file1=new File("C:\\test_files");
        System.out.println("--------获取文件或文件夹名称String-----------");
        String name= file.getName();
        System.out.println(name);
        String name1=file1.getName();
        System.out.println(name1);
        System.out.println("---------获取文件的绝对路径String-------------");
        System.out.println(file.getAbsolutePath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(new File("decode.txt").getAbsolutePath());
        System.out.println("---------获取文件的上级文件夹File-------------");
        System.out.println(file.getParent());
        System.out.println(file1.getParent());

        /**
         * 抽象路径就是路径去掉了系统分割符 ，windows的\，linux的/得到的路径
         * 而实际路径就是填上这系统分隔符得到的路径，所以就是赋值时的路径
         */
        System.out.println("---------获取文件的实际路径string------------");
        System.out.println(new File("decode.txt").getPath());
        System.out.println(file.getPath());
        System.out.println("---------获取文件大小（字节数）--------------");
        System.out.println(file.length());
        System.out.println("---------获取上次修改时间(判断文件是否被修改）------");
        long time=file1.lastModified();
        Date date=new Date(time);
        System.out.println(date);
    }
    /**
     * 在硬盘创建和删除文件
     * 当不存在这个文件时才会创建成功，否则创建失败
     *
     * deleteOnExit：告诉虚拟机在程序运行结束了删除这个文件
     * 这样即使抛出异常文件也会被删除
     */
    public static void create_delete() throws IOException {
        System.out.println("-------------创建文件--------------");
        File file=new File("C:\\test_files\\createtest.ppt");
        boolean issuccess=file.createNewFile();
        System.out.println(issuccess==true?"success":"failure");
        System.out.println("------------删除文件、文件夹---------------");
        //不走回收站，直接byebye
        boolean isok=file.delete();
        System.out.println(isok==true?"success":"failure");
        //如果删除文件夹，里面需没有文件才能删
        boolean ok=new File("C:\\delete_files").delete();
        System.out.println(ok==true?"success":"failure");
        /**
         * mkdir():严格，当指定路径是文件、已存在、路径不为真的时候都不能创建，其他才可以创建。     走路
         * mkdirs():不严格，就是根据你指定的路径一路创建到底，除非指定路径文件夹已存在。            修路
         */
        System.out.println("-----------创建文件夹--------------");
        File file1=new File("C:\\test_files\\create");
        file1.mkdir();
        File file2=new File("C:\\hahhah\\xixiix\\heiheie");
        file2.mkdirs();
    }

    /**
     * 文件的判断
     * 1.是否是绝对路径 boolean	isAbsolute()
     * 2.文件是否存在   boolean exists()
     * 3.文件类型       boolean isFile()       boolean isDirectory()  判断这个之前最好先判断文件是否存在
     * 4.是否隐藏       boolean isHidden()
     */
    public static void judge()
    {
        File file=new File("C:\\Users\\liang\\Desktop\\Files");
        boolean flag=file.isHidden();
        System.out.println(flag);
    }
    /**
     * 其他一些操作
     * boolean	renameTo(File dest) 如果在同一目录下，重命名；不在同一目录，剪切并重命名
     */
    public static void rename_test()
    {
        File file=new File("C:\\test_files\\dapipi.ppt");
        File file1=new File("D:\\xiaopipi.ppt");
        file.renameTo(file1);
    }
    /**
     * 获取系统根目录，就是C盘D盘啥的
     * File类的静态方法,返回文件数组
     */
    public static void root()
    {
        File[] files=File.listRoots();
        for (File file : files) {
            System.out.println(file);
        }
    }
    /**
     * 获取目录空闲空间、总共空间、虚拟机可用空间字节大小
     */
    public static void zone()
    {
        File file=new File("C:\\");
        System.out.println("freespace....."+file.getFreeSpace());
        System.out.println("totalspace....."+file.getTotalSpace());
        System.out.println("usuable....."+file.getUsableSpace());
    }

    /**
     * 这个路径里的文件和文件夹（包括隐藏文件）
     *         1.  当实例对象代表的是文件不是目录时，返回NUll对象
     *
     *         2.  获取的是该目录下的文件名和目录名,并不包含该目录名称和其上级目录名称
     *
     *         3.  字符串数组中都是文件名或目录名并不是路径名
     *
     *         4.  字符串中的元素并不是按照实际系统中目录下的顺序排列的
     *
     */
    public static void get_below()
    {
        File file=new File("C:\\test_files");
        String [] list=file.list();
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 过滤器
     *     1. 过滤器是FilenameFilter类对象，当传入null时，效果和list()方法一样
     *
     *     2. 过滤器是指过滤掉不符合名称的名字
     *
     *     3. FilenameFilter 是一个接口，因此需要自己新建一个类来实现该接口作为参数传入进去
     *
     *     4.仔细研究方法的源码可以发现，所谓过滤就是要重写FilenameFilter的accept方法并在方法中过滤
     *
     *     只留下以.xxx为后缀的文件名的文件或者文件夹
     *     也就是说这个方法只看文件名而不看文件
     */
    public static void FilenameFilter_test()
    {
        File file=new File("C:\\test_files");
       // String [] str=file.list(new TXTFilter());
        String [] str=file.list(new Filter(".ppt"));
        for (String s : str) {
            System.out.println(s);
        }
    }

    /**
     * 与上面不同，这个函数获取文件对象.它的过滤器的accept方法参数是file对象
     */
    public static void listFiles_test()
    {
        File file=new File("C:\\");
        File[] files=file.listFiles(new file_filter());
//        System.out.println(files.length);
        for (File file1 : files) {
            System.out.println(file1);
        }
    }

}

/**
 * 只能过滤txt
 */
class TXTFilter implements FilenameFilter
{

    @Override
    public boolean accept(File dir, String name) {
        if(name.endsWith(".txt"))
            return true;
        else
            return false;
    }
}
/**
 * 可指定过滤文件的后缀
 */
class Filter implements FilenameFilter
{
    private String type;

    public Filter(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean accept(File dir, String name) {
        if(name.endsWith(this.getType()))
            return true;
        else
            return false;
    }
}

/**
 * 注意看清，这个类实现的不是名字过滤，而是文件过滤
 */
class file_filter implements FileFilter
{

    @Override
    public boolean accept(File pathname) {
        if(pathname.isHidden())
            return false;
        else
            return true;
    }
}
