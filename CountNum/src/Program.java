import javax.swing.*;
import java.awt.*;

public class Program {
    public Integer num = 0;

    public static void main(String[] args) {
        final Integer[] num = {0};

        try {
            // 设置窗口风格
            UIManager.setLookAndFeel(String.valueOf(UIManager.getSystemLookAndFeelClassName()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 1. 创建一个顶层容器（窗口）
        JFrame jf = new JFrame("测试窗口");          // 创建窗口

        jf.setSize(250, 250);                // 设置窗口大小
        jf.setLocationRelativeTo(null);                    // 把窗口位置设置到屏幕中心
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）

        GridBagLayout gridBag = new GridBagLayout();        // 布局管理器
        GridBagConstraints c;                               // 约束


        // 2. 创建中间容器（面板容器）
        JPanel panel = new JPanel(gridBag);                 // 创建面板容器，使用默认的布局管理器

        // 3. 创建一个基本组件（按钮），并添加到 面板容器 中

        JLabel lab = new JLabel(num[0].toString());
        // Button05 显示区域独占一行（换行），组件填充显示区域
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.VERTICAL;

        panel.add(lab, c);

        JButton btn = new JButton("测试按钮");
        btn.setFocusable(false);
        panel.add(btn, c);
        btn.addActionListener(e -> {
            num[0] += 1;
            lab.setText(num[0].toString());                 // 独立出update函数
        });

        // 4. 把 面板容器 作为窗口的内容面板 设置到 窗口
        jf.setContentPane(panel);

        // 5. 显示窗口，前面创建的信息都在内存中，通过 jf.setVisible(true) 把内存中的窗口显示在屏幕上。
        jf.setVisible(true);
    }
}


