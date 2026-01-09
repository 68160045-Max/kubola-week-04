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

	public class Lab04_6 {
	    public static void main(String[] args) {
	       
	        int n1 = (int) (Math.random() * 10);
	        int n2 = (int) (Math.random() * 10);
	        
	        
	        int opRand = (int) (Math.random() * 3);
	        char op = ' ';
	        int ans = 0;

	        if (opRand == 0) {
	            op = '+';
	            ans = n1 + n2;
	        } else if (opRand == 1) {
	            op = '-';
	            ans = n1 - n2;
	        } else {
	            op = '*';
	            ans = n1 * n2;
	        }

	      
	        JFrame win = new JFrame("Easy Math Quiz");
	        win.setBounds(100, 100, 600, 300);
	        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JPanel subwin = new JPanel();
	        subwin.setBackground(new Color(102, 224, 255));
	        Font myFont = new Font("Serif", Font.PLAIN, 40);

	        // แสดงโจทย์
	        JLabel label1 = new JLabel("" + n1);
	        label1.setFont(myFont);
	        
	        JLabel labelOp = new JLabel(" " + op + " ");
	        labelOp.setFont(myFont);
	        
	        JLabel label2 = new JLabel("" + n2);
	        label2.setFont(myFont);
	        
	        JLabel labelEqual = new JLabel(" = ");
	        labelEqual.setFont(myFont);

	        // ช่องกรอกคำตอบและปุ่ม
	        JTextField inputField = new JTextField(3);
	        inputField.setFont(myFont);

	        JButton checkBtn = new JButton("Check");
	        JLabel resultLabel = new JLabel("");
	        resultLabel.setFont(myFont);

	        // ดึงค่า ans มาใช้งานใน ActionEvent (ต้องประกาศเป็น final หรือใช้ตัวแปรช่วย)
	        final int finalAns = ans; 

	        checkBtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    int userAns = Integer.parseInt(inputField.getText());
	                    if (userAns == finalAns) {
	                        resultLabel.setText("Excellent!");
	                        resultLabel.setForeground(Color.BLACK);
	                    } else {
	                        resultLabel.setText("Wrong!");
	                        resultLabel.setForeground(Color.RED);
	                    }
	                } catch (Exception ex) {
	                    resultLabel.setText("Error!");
	                }
	            }
	        });

	        // นำทุกอย่างใส่ในจอ
	        subwin.add(label1);
	        subwin.add(labelOp);
	        subwin.add(label2);
	        subwin.add(labelEqual);
	        subwin.add(inputField);
	        subwin.add(checkBtn);
	        subwin.add(resultLabel);

	        win.add(subwin);
	        win.setVisible(true);
	    }
	}

