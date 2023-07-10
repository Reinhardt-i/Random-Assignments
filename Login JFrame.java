package project.brainstorm;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Login extends JFrame {

    public Login() {
        initializeUI();
    }

    private void initializeUI() {
      
        setTitle("Storm Your Brain");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(null); // Use absolute positioning

        // Load and add image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("images/two.jpg"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 400, 400);
        add(imageLabel);

        // Heading label
        JLabel headingLabel = new JLabel("Storm Your Brain");
        headingLabel.setBounds(430, 60, 300, 45);
        headingLabel.setFont(new Font("Mongolian Balti", Font.BOLD, 30));
        add(headingLabel);

        // Name label and text field
        JLabel nameLabel = new JLabel("Enter Your Name");
        nameLabel.setBounds(430, 150, 200, 20);
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        nameLabel.setForeground(Color.RED);
        add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(430, 200, 300, 25);
        nameTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(nameTextField);

        // Rules button
        JButton rulesButton = new JButton("Rules");
        rulesButton.setBounds(430, 270, 120, 25);
        rulesButton.setBackground(new Color(30, 144, 254));
        rulesButton.setForeground(Color.BLUE);
        add(rulesButton);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(610, 270, 120, 25);
        backButton.setBackground(new Color(30, 144, 254));
        backButton.setForeground(Color.BLUE);
        add(backButton);

        getContentPane().setBackground(Color.CYAN);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
