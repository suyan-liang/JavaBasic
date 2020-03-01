/**
 * Author:liang;
 * Date:2020/2/29;
 * Time:16:43;
 * Package Name:PACKAGE_NAME;
 * 需求：
 * 步骤：
 */

import java.awt.*;
import java.awt.event.*;

/**
 * 一般来说，创建一个GUI这样的类
 * step1.明确组件成员
 * step2.构造函数初始化，对组件进行基本设置
 */

/**
 * 此外，KeyEvent类也有不少常用的量
 * VK_HOME         Home键                          VK_CONTROL                  控制键
 * VK_END            End键                             VK_SHIFT                       shift键
 * VK_PGUP          page up键                       VK_BACK_SPACE             退格键
 * VK_PGDN          page down键                   VK_CAPS_LOCK              大小写锁定键
 * VK_UP              上箭头                            VK_NUM_LOCK                小键盘锁定键
 * VK_DOWN         下箭头                            VK_ENTER                      回车键
 * VK_LEFT           左箭头                            VK_UNDEFINED                未知键
 * VK_RIGHT          右箭头                           VK_F1--VK_F12                F1 -- F12
 * VK_ESCAPE       Esc键                              VK_0 --VK_9                    0 --- 9
 * VK_TAB             Tab键                             VK_A --VK_Z                    A----Z
 */

/**
 * consume()方法，平时像adapter之类的在方法中都有默认隐藏代码
 * 使用consume方法可以使那些代码不执行
 */
public class Mouse_Key_Listener {
    //第一步，明确组件
    private Frame frame;
    private Button button;
    private TextField textField;
    //第二步，进行初始化基本设置

    public Mouse_Key_Listener() {
        //窗口初始化
        frame=new Frame("鼠标事件");
        frame.setLocation(800,500);
        frame.setSize(400,300);
        frame.setLayout(new FlowLayout());//流式布局
        frame.setVisible(true);
        //按钮初始化
        button=new Button("button");
        //文本框初始化
        textField=new TextField(15);

        //把组件添加到窗口
        frame.add(button);
        frame.add(textField);

        //添加监听器
        //窗口的关闭监听器
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //按钮的鼠标按下监听器,只需要复写需要用到的函数即可
        button.addMouseListener(new MouseAdapter() {
            int count=0;
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    System.out.println("双击按钮了！");
                    textField.setText("Mouse...."+count++);
                }

            }
        });
        //文本框的键盘监视器，和鼠标其实产不多
        textField.addKeyListener(new KeyAdapter() {
            int cnt=0;
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==' ')
                    textField.setText("hahah"+cnt++);
            }
        });

    }
/*
 * 双击怎么操作呢？
 * 都是去鼠标事件中找方法
 * 键盘就去键盘事件中找方法
 */
    public static void main(String[] args) {
        new Mouse_Key_Listener();
    }
}
