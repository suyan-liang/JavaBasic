package PolymorphismTest;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:12:27;
 * Package Name:PolymorphismTest;
 * 需求：
 * 步骤：
 */
public class SoundCard implements PCI {

    @Override
    public void open() {
        System.out.println("the SoundCard is running.....");
    }

    @Override
    public void close() {
        System.out.println("the SoundCard is closed......");
    }
}
