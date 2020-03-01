package Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:liang;
 * Date:2020/2/23;
 * Time:16:54;
 * Package Name:Date;
 * 需求：
 * 步骤：
 */
public class DateFormatDemo {
    public static void main(String[] args) {
        Date date=new Date();
        /**
         * DateFormat是一个抽象类
         * 通过getDateInstance() 获取日期格式化对象
         * 通过getDateTimeInstance()获取日期和时间格式化对象
         * 日期对象调用format函数可以把日期对象转为字符串
         */
        /**
         * 不带参数：getInstance不带参数默认是xxxx-xx-xx形式
         * 带参数：static DateFormat	getDateInstance(int style)
         *         static DateFormat	getDateTimeInstance(int dateStyle, int timeStyle)
         * FULL格式是年月日星期，还有LONG,SHORT等格式，作为参数(DateFormat.FULL)
         */
        DateFormat dateFormat=DateFormat.getDateInstance();
        String now=dateFormat.format(date);
        System.out.println(now);

        /**
         * 带参数的形式
         */
        //日期
        DateFormat dateFormat1=DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("FULL"+dateFormat1.format(date));
        //时间日期
        DateFormat dateFormat2=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        System.out.println(dateFormat2.format(date));

        /**
         * 自定义日期格式---simpleDateFormat
         * 构造函数SimpleDateFormat(String pattern)
         * 其中y代表年，M代表月，d代表日，H代表时，m代表分,s代表秒,E代表星期几
         * 'character'代表要写的符号包含上述符号(y,M,d......)
         * 如"yyyy-MM-dd "
         *
         * 自动中国化
         */
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy'year'MM##dd EEE");
        System.out.println(simpleDateFormat.format(date));


        /**
         * 将日期字符串转换为日期对象??????????????????
         * public Date parse(String source)
         * 依据DateFormat对象getDateInstance时传入的风格解析，如果无法解析抛出异常
         *
         * 使用simpleDateFormat同理
         */
    }
}
