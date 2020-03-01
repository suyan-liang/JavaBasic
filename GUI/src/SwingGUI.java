import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Author:liang;
 * Date:2020/2/29;
 * Time:19:24;
 * Package Name:PACKAGE_NAME;
 * 需求：
 * 步骤：
 */
//idea自动生成这个东西回头再搞
public class SwingGUI {
    private JPanel panel1;
    private JButton button1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingGUI");
        frame.setContentPane(new SwingGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public SwingGUI() {
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
