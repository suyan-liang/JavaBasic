package ReflectTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Author:liang;
 * Date:2020/3/3;
 * Time:12:36;
 * Package Name:ReflectTest;
 * 需求：
 * 步骤：
 *
 * 这样在扩展设备的时候，只需要写类实现PCI接口，再把类名写到配置文件中即可
 */
public class Computer {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("Computer is running......");
        MainBoard mainBoard=new MainBoard();
        mainBoard.run();

        //读取配置文件，并加载到Properties对象中
        File PCIfile=new File("C:\\Users\\liang\\IdeaProjects\\firstProject\\Reflection\\src\\ReflectTest\\PCIFile");
        FileInputStream in=new FileInputStream(PCIfile);
        Properties pcifile=new Properties();
        pcifile.load(in);
        /*
         * 循环读取Properties对象中的类名
         *
         * 获取类名对应的class文件，创建实例化对象
         *
         * 把实例化对象传到调用PCI的函数中
         */
        for (int i = 0; i < pcifile.size(); i++) {
            String name=pcifile.getProperty("PCI"+(i+1));
            Class clazz=Class.forName(name);
            PCI pci= (PCI) clazz.newInstance();
            mainBoard.usePCI(pci);
        }
        in.close();
    }
}
