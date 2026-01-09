package lab04;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab04_8 {

    public static void main(String[] args) {
        // 1. Create the main window (Frame)
        JFrame win = new JFrame("BMI Calculator Tool");
        win.setBounds(100, 100, 450, 420);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setLayout(new BorderLayout());

        // 2. Header Section
        JLabel headerLabel = new JLabel("BMI CALCULATOR", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 28));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        win.add(headerLabel, BorderLayout.NORTH);

        // 3. Input Section (Center Panel)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 10, 15));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        
        JLabel lblWeight = new JLabel("Weight (kg):");
        lblWeight.setFont(labelFont);
        JTextField txtWeight = new JTextField();
        txtWeight.setFont(labelFont);
        
        JLabel lblHeight = new JLabel("Height (cm):");
        lblHeight.setFont(labelFont);
        JTextField txtHeight = new JTextField();
        txtHeight.setFont(labelFont);

        JButton btnCalc = new JButton("Calculate");
        btnCalc.setFont(new Font("Arial", Font.BOLD, 16));
        btnCalc.setBackground(new Color(40, 167, 69)); // Green color
        btnCalc.setForeground(Color.WHITE);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Arial", Font.BOLD, 16));

        centerPanel.add(lblWeight);
        centerPanel.add(txtWeight);
        centerPanel.add(lblHeight);
        centerPanel.add(txtHeight);
        centerPanel.add(btnReset);
        centerPanel.add(btnCalc);

        win.add(centerPanel, BorderLayout.CENTER);

        // 4. Result Section (Bottom Panel)
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));

        JLabel lblBmiValue = new JLabel("Your BMI: - ", JLabel.CENTER);
        lblBmiValue.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblBmiValue.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel lblBmiStatus = new JLabel("Status: - ", JLabel.CENTER);
        lblBmiStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblBmiStatus.setFont(new Font("Arial", Font.ITALIC, 18));

        resultPanel.add(lblBmiValue);
        resultPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Spacer
        resultPanel.add(lblBmiStatus);
        win.add(resultPanel, BorderLayout.SOUTH);

        // --- Action Listeners ---

        // Calculate Logic
        btnCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(txtWeight.getText());
                    double heightCm = Double.parseDouble(txtHeight.getText());
                    
                    // BMI Formula: weight (kg) / [height (m)]^2
                    double heightM = heightCm / 100;
                    double bmi = weight / (heightM * heightM);

                    lblBmiValue.setText(String.format("Your BMI: %.2f", bmi));

                    // Interpretation based on International standards
                    String status;
                    Color statusColor;

                    if (bmi < 18.5) {
                        status = "Underweight";
                        statusColor = Color.BLUE;
                    } else if (bmi < 25.0) {
                        status = "Normal weight";
                        statusColor = new Color(0, 128, 0); // Dark Green
                    } else if (bmi < 30.0) {
                        status = "Overweight";
                        statusColor = Color.ORANGE;
                    } else {
                        status = "Obese";
                        statusColor = Color.RED;
                    }

                    lblBmiStatus.setText("Status: " + status);
                    lblBmiStatus.setForeground(statusColor);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(win, 
                        "Invalid input! Please enter numeric values.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Reset Button
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtWeight.setText("");
                txtHeight.setText("");
                lblBmiValue.setText("Your BMI: - ");
                lblBmiStatus.setText("Status: - ");
                lblBmiStatus.setForeground(Color.BLACK);
            }
        });

        win.setVisible(true);
    }
}