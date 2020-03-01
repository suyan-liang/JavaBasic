package String;
/*
    Author:liang;
    Date:2020/2/19;
    Time:14:20;
    Package Name:String;
    需求：
    步骤：
    知识点：
*/

public class Integer_test3 {
    public static void main(String[] args) {
        Integer x=new Integer("16");
        System.out.println(x);

        //两个静态常量
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        //int--->String
        //String ans=Integer.toString(x);   //直接转化
        //String ans=Integer.toString(x,2);//进制转换
        //String ans=Integer.toHexString(x);//转为16进制
        String ans=x+"";
        System.out.println(ans);

        //String--->int
        String str="15";
        int i=Integer.parseInt(str);
        int j=Integer.parseInt(str,16);
        System.out.println(i);
        System.out.println(j);

        //Integer--->int
        Integer xx=new Integer("12");
        int answer=xx.intValue();
        System.out.println(answer);
    }
}
