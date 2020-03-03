package ReflectTest;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:12:37;
 * Package Name:ReflectTest;
 * 需求：
 * 步骤：
 */
public class MainBoard {
   public void run()
   {
      System.out.println("the MainBoard is running");
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
