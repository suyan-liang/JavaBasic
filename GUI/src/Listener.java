/**
 * Author:liang;
 * Date:2020/2/29;
 * Time:16:05;
 * Package Name:PACKAGE_NAME;
 * 需求：
 * 步骤：
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 1.事件源就是控件，比如一个按钮。事件源与监听器的绑定使用add方法，可以add不同控件对应的监听器。
 * 2.窗口：void	addWindowListener(WindowListener l)  其中WindowListener是一个接口，WindowAdapter是实现它的子类。
 *        它实现的时候里面的方法什么都没写，我们使用时想使用哪个功能复写即可，只需复写想自己添加的语句，其他自动实现
 */
public class Listener {
    public static void main(String[] args) {
        //easy_test();
        button_test();
    }

    /**
     * 窗口监听器
     */
    public static void easy_test(){
        Frame frame=new Frame("我的窗口");
        frame.setLocation(800,500);
        frame.setSize(400,300);
        //step2.设置控件的布局
        frame.setLayout(new FlowLayout());//流式布局
        //step3.创建并添加控件
        Button button=new Button("一个按钮");
        frame.add(button);
        //step4.窗口可视化
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("closing.....");
            }
        });
    }
    /**
     * 按钮监听器
     */
    public static void button_test(){
        Frame frame=new Frame("按钮测试");
        frame.setLocation(800,500);
        frame.setSize(400,300);
        frame.setLayout(new FlowLayout());//流式布局
        /*
         * 超过两个方法才需要适配器adapter，否则都是直接复写
         */
        Button button=new Button("close");
        frame.add(button);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
