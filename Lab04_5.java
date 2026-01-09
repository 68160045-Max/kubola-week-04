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

	public class Lab04_5 {
	    public static void main(String[] args) {
	       
	        int n1 = (int) (Math.random() * 10);
	        int n2 = (int) (Math.random() * 10);
	        int ans = n1 + n2;

	    
	        JFrame win = new JFrame("Easy Math Quiz");
	        win.setBounds(100, 100, 600, 300);
	        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	   
	        JPanel subwin = new JPanel();
	        subwin.setBackground(new Color(102, 224, 255));
	        
	       
	        Font myFont = new Font("Serif", Font.PLAIN, 40);

	       
	        JLabel label1 = new JLabel("" + n1);
	        label1.setFont(myFont);
	        
	        JLabel labelPlus = new JLabel(" + ");
	        labelPlus.setFont(myFont);
	        
	        JLabel label2 = new JLabel("" + n2);
	        label2.setFont(myFont);
	        
	        JLabel labelEqual = new JLabel(" = ");
	        labelEqual.setFont(myFont);

	        
	        JTextField inputField = new JTextField(3);
	        inputField.setFont(myFont);

	       
	        JButton checkBtn = new JButton("Check");
	        
	        
	        JLabel resultLabel = new JLabel("");
	        resultLabel.setFont(myFont);

	       
	        checkBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    int userAns = Integer.parseInt(inputField.getText());
	                    if (userAns == ans) {
	                        resultLabel.setText("Excellent!");
	                        resultLabel.setForeground(Color.BLACK);
	                    } else {
	                        resultLabel.setText("Wrong!");
	                        resultLabel.setForeground(Color.RED);
	                    }
	                } catch (NumberFormatException ex) {
	                    resultLabel.setText("Enter Number!");
	                    resultLabel.setForeground(Color.ORANGE);
	                }
	            }
	        });

	     
	        subwin.add(label1);
	        subwin.add(labelPlus);
	        subwin.add(label2);
	        subwin.add(labelEqual);
	        subwin.add(inputField);
	        subwin.add(checkBtn);
	        subwin.add(resultLabel);

	       
	        win.add(subwin);
	        win.setVisible(true);
	    }
	}

