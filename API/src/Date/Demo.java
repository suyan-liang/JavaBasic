package Date;

import java.util.Date;

/**
 * Author:liang;
 * Date:2020/2/23;
 * Time:13:51;
 * Package Name:Date;
 * 需求：
 * 步骤：
 */

/*
 * https://www.cnblogs.com/gu-bin/p/10022703.html
 */
/*
 * Date类除了Date(),Date(long time)以及long getTime() 和 void setTime(long time)  好像都过期了emmmm......
 * boolean after(Date when) 判断when是不是在当前日期之后，是的话返回true;
 * int compareTo(Date another) 日期的比较方法
 */
public class Demo {
    public static void main(String[] args) {
       // long time=System.currentTimeMillis();
        /*Date date=new Date(time);*/
        Date date=new Date(1582447088860L);//写long型的数据要在后面加上L，我tm才知道,否则会报错
        /*System.out.println(date.toString());*/
        boolean isafter=date.after(new Date());
        System.out.println(isafter);
        int iscompareTo =date.compareTo(new Date());
        System.out.println(iscompareTo);
    }
}
