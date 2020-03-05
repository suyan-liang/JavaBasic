package _3Data_type;

/**
 * Author:liang;
 * Date:2020/3/5;
 * Time:17:09;
 * Package Name:_3Data_type;
 * 需求：
 * 步骤：
 *
 *
 *
 * 标识符--自定义的名字
 * 1、不能数字开头
 * 2、不能用关键字
 *
 * 注释
 * 1.单行注释和多行注释和C++一样
 * 2.文档注释有其规范注意
 * 3.面试和做项目都要写
 * 4.写代码之前先写需求和步骤，厘清思路
 *
 *
 * 常量
 * 和C++一致
 *
 * 负数二进制
 * 正数二进制取反加1
 *
 */

/**
 *
 * 直接出现的，整数默认是int,小数默认是double
 *
 *
 * 一、整数
 * byte short int long
 * 1.byte类型，范围[-128,127]
 * 2.int 占32位，byte占8位
 *
 *
 * 二、小数
 * float double
 *
 *
 * 三、字符型
 * char
 *
 *
 */
public class demo {

    public static void main(String[] args) {
        /*
         *  类型转换
         *
         * 1.位数低的可以自动升级为位数高的(byte-int)
         * 2.位数高的转为位数低的会损失精度
         * 3.强转  (int)(x+2)
         * 4.字符变量和数字运算自动转化为数字
         * 5.只要运算，byte,short,char自动提升到int long; double，float仍是本身
         */
        byte_test();

    }
    public static void byte_test(){
        byte b=3+7;//不会报错，右边都是常量，会自动检查，超出会进行提示

        byte bb=3;
        byte b1=4;
        byte b2=5;
        //bb=b1+b2;  这样会报错，因为右边都是变量，无法进行检查
    }
}
