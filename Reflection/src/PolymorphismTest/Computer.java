package PolymorphismTest;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:12:16;
 * Package Name:PolymorphismTest;
 * 需求：
 * 步骤：
 */
public class Computer {
    public static void main(String[] args) {
        System.out.println("the computer is running....");

        MainBoard mainBoard=new MainBoard();
        mainBoard.usePCI(new SoundCard());//多态的方法需要传入对象，会修改程序代码，虽然提高了扩展性
    }
}
