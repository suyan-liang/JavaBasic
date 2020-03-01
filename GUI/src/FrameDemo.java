/**
 * Author:liang;
 * Date:2020/2/29;
 * Time:10:08;
 * Package Name:PACKAGE_NAME;
 * 需求：
 * 步骤：
 */

import java.awt.*;

/**
 * 1.GUI的对象都存在与java.awt---调用本地的按钮或者框框和javax.swing---调用自己的
 * 2.管理图形的是一个新线程
 * 3.Frame就是比如我的电脑那样的窗口界面，Frame(),Frame(String title)
 * 4.使用setVisible方法显示窗口
 * 5.设置大小setSize(x,y)  设置位置setLocation(x,y)
 * 6.窗体可以通过add方法来把按钮等控件添加到窗体中
 * 7.默认边界式布局，可以通过setLayOut()
 */
public class FrameDemo {
    public static void main(String[] args) {
        test_frame();
    }
    public static void test_frame(){
        //step1.创建窗体并进行基本设置
        Frame frame=new Frame("我的窗口");
        frame.setLocation(800,500);
        frame.setSize(400,300);
        //step2.设置控件的布局
        frame.setLayout(new FlowLayout());//流式布局
        //step3.创建并添加控件
        Button button=new Button("一个按钮");//我去这编码什么情况啊!!!!!!!!!!!!!!!!
        frame.add(button);
        //step4.窗口可视化
        frame.setVisible(true);

}
}
