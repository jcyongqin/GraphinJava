import core.GraphCore;
import core.Vertex2D;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String args[]) {
        // 1. 创建一个顶层容器（窗口）
        JFrame jf = new ExampleFrame("测试窗口");          // 创建窗口


        // 2. 创建绘图panel
        JPanel panel = new SimpleCanvas();

        // 4. 把 面板容器 作为窗口的内容面板 设置到 窗口
        jf.setContentPane(panel);

        // 5. 显示窗口，前面创建的信息都在内存中，通过 jf.setVisible(true) 把内存中的窗口显示在屏幕上。
        jf.setVisible(true);

    }
}

class ExampleFrame extends JFrame {

    public ExampleFrame(String title) {
        super(title);
        setTitle("JPanel应用实例");
        setSize(400, 300);                            // 设置窗口大小
        setLocationRelativeTo(null);                                // 把窗口位置设置到屏幕中心
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）
        setBackground(Color.blue);
    }
}

class SimpleCanvas extends JPanel {
    int x, y;

    public void paint(Graphics g) {
        super.paint(g);//调用super.paint（g）去清除运动的痕迹
        GraphCore gc = new GraphCore((Graphics2D) g);

        Vertex2D[] vb = {
                new Vertex2D(0, 250, Color.red),
                new Vertex2D(200, 0, Color.green),
                new Vertex2D(370, 250, new Color(0,0,254)),
        };
        gc.drawLine(vb[0],vb[1]);
        gc.drawLine(vb[1],vb[2]);
        gc.drawLine(vb[2],vb[0]);
    }
}