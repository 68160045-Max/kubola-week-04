import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab04_2 {
    public static void main(String[] args) {
        
        // สร้าง JLabel สำหรับแสดงผลลัพธ์คำทักทาย
        JLabel label2 = new JLabel();

        JFrame f = new JFrame();
        f.setTitle("Hello Program: Wutthiphat Angsri 68160045 n20");
        
        JLabel label1 = new JLabel();
        label1.setText("Enter name: ");

        f.setSize(500, 300);
        f.setLayout(new FlowLayout());
        
        // เพิ่ม Component เข้าไปใน Frame
        f.add(label1);

        JTextField nameBox = new JTextField(5);
        f.add(nameBox);

        JButton b1 = new JButton();
        b1.setText("send");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameBox.getText();
                // แสดงชื่อที่รับมาลงใน label2
                label2.setText("Hello " + name);
                
                
            }
        });

        f.add(b1);
        f.add(label2); // เพิ่ม label2 เข้าไปในหน้าจอเพื่อให้แสดงผล

        // ตั้งค่าให้ปิดโปรแกรมเมื่อกดปุ่ม X และแสดงหน้าต่าง
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
