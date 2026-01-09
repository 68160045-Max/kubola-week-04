package lab04;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab04_7 {
    
    static int n1, n2, ans, score = 0, count = 1;
    static char op;
    
    public static void main(String[] args) {
       
        JFrame win = new JFrame("Easy Math Quiz - 10 Questions");
        win.setBounds(100, 100, 700, 350);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel subwin = new JPanel();
        subwin.setBackground(new Color(102, 224, 255));
        Font myFont = new Font("Serif", Font.PLAIN, 40);

        // ส่วนแสดงลำดับข้อ
        JLabel labelCount = new JLabel(count + "/10  ");
        labelCount.setFont(new Font("Serif", Font.BOLD, 25));

        // ส่วนแสดงโจทย์
        JLabel labelQuiz = new JLabel("");
        labelQuiz.setFont(myFont);

        // ช่องกรอกคำตอบ
        JTextField inputField = new JTextField(3);
        inputField.setFont(myFont);

        JButton checkBtn = new JButton("Check");
        JLabel resultLabel = new JLabel("");
        resultLabel.setFont(myFont);

        // สุ่มโจทย์ข้อแรก
        generateQuiz(labelQuiz);

        checkBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (count <= 10) {
                    try {
                        int userAns = Integer.parseInt(inputField.getText());
                        
                        // ตรวจคำตอบ
                        if (userAns == ans) {
                            score++;
                            resultLabel.setText("Correct!");
                            resultLabel.setForeground(Color.BLUE);
                        } else {
                            resultLabel.setText("Wrong!");
                            resultLabel.setForeground(Color.RED);
                        }

                        // เลื่อนไปข้อถัดไป
                        count++;
                        inputField.setText(""); // ล้างช่องกรอก
                        
                        if (count <= 10) {
                            labelCount.setText(count + "/10  ");
                            generateQuiz(labelQuiz); // สุ่มโจทย์ใหม่
                        } else {
                            // เมื่อทำครบ 10 ข้อ
                            labelQuiz.setText("จบการทดสอบ");
                            labelCount.setText("สรุปผลคะแนน");
                            inputField.setVisible(false);
                            checkBtn.setEnabled(false);
                            resultLabel.setText(score + "/10");
                            resultLabel.setForeground(Color.BLACK);
                        }
                    } catch (Exception ex) {
                        resultLabel.setText("กรุณาใส่ตัวเลข!");
                    }
                }
            }
        });

        // นำอุปกรณ์ใส่ลงหน้าจอ
        subwin.add(labelCount);
        subwin.add(labelQuiz);
        subwin.add(inputField);
        subwin.add(checkBtn);
        subwin.add(resultLabel);

        win.add(subwin);
        win.setVisible(true);
    }

    // Method สำหรับสุ่มโจทย์ใหม่
    public static void generateQuiz(JLabel label) {
        n1 = (int) (Math.random() * 10);
        n2 = (int) (Math.random() * 10);
        int opRand = (int) (Math.random() * 3);

        if (opRand == 0) {
            op = '+'; ans = n1 + n2;
        } else if (opRand == 1) {
            op = '-'; ans = n1 - n2;
        } else {
            op = '*'; ans = n1 * n2;
        }
        label.setText(n1 + " " + op + " " + n2 + " = ");
    }
}