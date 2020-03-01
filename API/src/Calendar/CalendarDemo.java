package Calendar;

import java.util.Calendar;

/**
 * Author:liang;
 * Date:2020/2/23;
 * Time:20:08;
 * Package Name:Calendar;
 * 需求：
 * 步骤：
 */
public class CalendarDemo {
    public static void main(String[] args) {
        /**
         * Calendar是一个抽象类，不能直接创建对象，而是用getInstance()获取
         * 也是以静态方法居多
         *
         * 当创建一个Calendar时，当时的时间就会放在这个Calendar对象中
         */
        /**
         * https://blog.csdn.net/zhufengyan521521/article/details/89945593
         *
         * https://blog.csdn.net/f2764052703/article/details/89216454
         */
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;//月份要加1 ，切记切记
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        int week=calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println(month);
        System.out.println(year);
        System.out.println("week"+week);

    }
}
