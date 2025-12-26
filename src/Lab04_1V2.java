import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab04_1V2 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Hello Program: Wutthiphat Angsri 68160045 n20");
        JLabel label1 = new JLabel();
        label1.setText("Enter name: ");

        f.setSize(500,300);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.add(label1);

        JTextField nameBox = new JTextField(5);
        f.add(nameBox);

        JButton b1 = new JButton();
        b1.setText("send");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameBox.getText();
                JOptionPane.showMessageDialog(null,"Hello "+ name);
            }
        });
        f.add(b1);

        f.setVisible(true);
    }
}
