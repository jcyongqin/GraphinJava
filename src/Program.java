import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Program {
    public Integer num = 0;
    public static void main(String[] args) {
        final Integer[] num = {0};

        // 1. ����һ���������������ڣ�
        final JFrame[] jf = {new JFrame("���Դ���")};          // ��������

        jf[0].setSize(250, 250);                       // ���ô��ڴ�С
        jf[0].setLocationRelativeTo(null);             // �Ѵ���λ�����õ���Ļ����
        jf[0].setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // ��������ڵĹرհ�ťʱ�˳�����û����һ�䣬���򲻻��˳���

        GridBagLayout gridBag = new GridBagLayout();    // ���ֹ�����
        GridBagConstraints c;                    // Լ��


        // 2. �����м����������������
        JPanel panel = new JPanel(gridBag);                // �������������ʹ��Ĭ�ϵĲ��ֹ�����

        // 3. ����һ�������������ť��������ӵ� ������� ��

        JLabel lab = new JLabel(num[0].toString());
        // Button05 ��ʾ�����ռһ�У����У�����������ʾ����
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.VERTICAL;

        panel.add(lab,c);

        JButton btn = new JButton("���԰�ť");
        panel.add(btn,c);
        btn.addActionListener(e -> {
                 num[0] +=1;
                 lab.setText(num[0].toString());    // ������update����
        });




        // 4. �� ������� ��Ϊ���ڵ�������� ���õ� ����
        jf[0].setContentPane(panel);

        // 5. ��ʾ���ڣ�ǰ�洴������Ϣ�����ڴ��У�ͨ�� jf.setVisible(true) ���ڴ��еĴ�����ʾ����Ļ�ϡ�
        jf[0].setVisible(true);

    }
}




