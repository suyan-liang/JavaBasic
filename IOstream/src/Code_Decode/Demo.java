package Code_Decode;

import java.io.UnsupportedEncodingException;

/**
 * Author:liang;
 * Date:2020/2/28;
 * Time:19:56;
 * Package Name:Code_Decode;
 * 需求：
 * 步骤：
 */
public class Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {

        //easy_test();
    }
    public static void easy_test() throws UnsupportedEncodingException {
        String str="你好";
        byte[] buf=new byte[1024];
        buf=str.getBytes();
        for (byte b : buf) {
            System.out.print(b);
            System.out.print("   ");
        }
        //???本地UTF???
        // System.out.println();
        byte[] bbb=new byte[1024];
        bbb=str.getBytes("GBK");
        for (byte b : bbb) {
            System.out.print(b);
            System.out.print("   ");
        }
    }
}
