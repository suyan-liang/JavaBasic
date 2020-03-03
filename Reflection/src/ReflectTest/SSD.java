package ReflectTest;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:12:50;
 * Package Name:ReflectTest;
 * 需求：
 * 步骤：
 */
public class SSD implements PCI {

    @Override
    public void open() {
        System.out.println("SSD is running...");
    }

    @Override
    public void close() {
        System.out.println("SSD is closed...");
    }
}
