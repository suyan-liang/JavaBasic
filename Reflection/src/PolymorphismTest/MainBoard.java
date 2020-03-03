package PolymorphismTest;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:12:20;
 * Package Name:PolymorphismTest;
 * 需求：
 * 步骤：
 *
 *
 * 主板，可以在主板上进行功能的扩展
 */
public class MainBoard {
    public void run()
    {
        System.out.println("the Mainboard is running..... ");
    }
    public void usePCI(PCI pci)
    {
        if(pci!=null)
        {
            pci.open();
            pci.close();
        }
    }
}
