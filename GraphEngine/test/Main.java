import core.GraphCore;
import core.Vertex2D;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String args[]) {
        // 1. ����һ���������������ڣ�
        JFrame jf = new ExampleFrame("���Դ���");          // ��������


        // 2. ������ͼpanel
        JPanel panel = new SimpleCanvas();

        // 4. �� ������� ��Ϊ���ڵ�������� ���õ� ����
        jf.setContentPane(panel);

        // 5. ��ʾ���ڣ�ǰ�洴������Ϣ�����ڴ��У�ͨ�� jf.setVisible(true) ���ڴ��еĴ�����ʾ����Ļ�ϡ�
        jf.setVisible(true);

    }
}

class ExampleFrame extends JFrame {

    public ExampleFrame(String title) {
        super(title);
        setTitle("JPanelӦ��ʵ��");
        setSize(400, 300);                            // ���ô��ڴ�С
        setLocationRelativeTo(null);                                // �Ѵ���λ�����õ���Ļ����
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    // ��������ڵĹرհ�ťʱ�˳�����û����һ�䣬���򲻻��˳���
        setBackground(Color.blue);
    }
}

class SimpleCanvas extends JPanel {
    int x, y;

    public void paint(Graphics g) {
        super.paint(g);//����super.paint��g��ȥ����˶��ĺۼ�
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