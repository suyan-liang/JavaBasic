package Test;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:19:04;
 * Package Name:Test;
 * 需求：治疗口吃
 * 步骤：
 */
public class test1 {
    public static void main(String[] args) {
        String text="我我..我我...我我我....要要要....学学学学学......编..程程程程程";
        //step1 去掉.  把.替换成""
        String regex1="\\.+";
        String mid=text.replaceAll(regex1,"");
        System.out.println(mid);
        //step2 把叠词换成一个字
        String regex2="(.)\\1+";
        String ans=mid.replaceAll(regex2,"$1");
        System.out.println(ans);
    }
}
