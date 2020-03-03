import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:17:21;
 * Package Name:PACKAGE_NAME;
 * 需求：
 * 步骤：
 *
 *
 * 正则表达式，常用于对字符串的操作
 * 1.匹配   boolean	matches(String regex)
 *
 * 2.切割   String[]	split(String regex)
 *
 * 3.替换
 *
 * 4.获取
 */
public class Function {
    public static void main(String[] args) {
        //matches_demo();
        //spilt_demo();
        //replace_demo();
        get_demo();
    }

    /**
     * 匹配操作
     * 其实就是类似于测试QQ号是否符合规范
     * 假设首位为1-3，其余位尾数字，一共6-11位
     */
    public static void matches_demo()
   {
        String number="1115642953";
        String regex="[1-3]\\d{5,10}";


        boolean isqq=number.matches(regex);
        System.out.println(isqq);
    }
    /**
     * 切割，返回的是字符串数组
     *
     * () 是一个组  利用\\1之类进行引用  按左括号数组
     */
    public static void spilt_demo()
    {
        String text="zhang3       li4  wang5    zhao6";
        String regex=" +";//  \s真垃圾，不如用这个
        String[] ans=text.split(regex);
        for (String an : ans) {
            System.out.println(an);
        }
        System.out.println("--------------------------");
        String text2="zhang3&&&&&li4hhhhhhwang566666zhao6+++++";//用叠词分割开
        String myregex="(.)\\1{2,}";// \\1指用第一组，相当于js的$1
        String[] res=text2.split(myregex);
        for (String re : res) {
            System.out.println(re);
        }
    }
    /**
     * 替换
     *
     * String	replaceAll(String regex, String replacement)
     * String	replaceFirst(String regex, String replacement)
     *
     * 另一个字符串想使用前一个正则表达式的组，用 $符号
     *
     * 复用的时候就想到用组，分割的时候也想到
     *
     */
    public static void replace_demo()
    {
        String text="zhang3&&&&&li4hhhhhhwang566666zhao6+++++";//把重复的字符用一个字符替换
        String regex="(.)\\1+";
        String ans=text.replaceAll(regex,"$1");
        System.out.println(ans);

        System.out.println("--------------------------------------------------");
        String number="12345678978";//把中间四位用*代替
        String myregex="(\\d{3})\\d{4}(\\d{4})";
        String res=number.replaceAll(myregex,"$1****$2");
        System.out.println(res);
    }

    /**
     * 获取
     *
     *
     *  Pattern p = Pattern.compile("a*b");    将正则封装成对象
     *  Matcher m = p.matcher("aaaaab");       通过正则获取匹配器对象
     *  操作                                   对匹配的字符串进行操作
     *
     *
     */
    public static void get_demo()
    {
        String text="da jia hao , ming tian bu fang jia la!";//获取由三个字母组成的单词
        /*
         * 当字符串中没有这种方法，看pattern和matcher
         * 字符串的很多方法都是来源于pattern和matcher
         */
        Pattern p=Pattern.compile("\\b[a-z]{3}\\b");
        Matcher matcher=p.matcher(text);
        System.out.println(text);
        while (matcher.find())//find函数看是否能匹配到正则对应的字符串
        {
            System.out.println(matcher.group());//group对象可以获取刚刚匹配到的那个字符串
            System.out.println("["+matcher.start()+","+matcher.end()+")");//获取index
        }

    }
}
