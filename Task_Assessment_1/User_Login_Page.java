package Task_Assessment_1;

// Importing Required Libraries for Program
import java.awt.*;
import java.awt.event.*;
import java.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class User_Login_Page implements ActionListener {
    JFrame Front_Side;
    JLabel First_Lable, Second_Lable;
    JTextField User_Name;
    JPasswordField User_Pass;
    JButton First_Button, Second_Button;
    Main_Content Main_Content_Program;

    User_Login_Page() {
        Front_Side = new JFrame("Login Portal");
        Front_Side.getContentPane().setLayout(null);
        Front_Side.getContentPane().setBackground(Color.WHITE);
        First_Lable = new JLabel("Enter Your User Name");
        First_Lable.setForeground(Color.RED);
        First_Lable.setBounds(50, 50, 100, 30);
        Second_Lable = new JLabel("Enter Your PassWord");
        Second_Lable.setForeground(Color.RED);
        Second_Lable.setBounds(50, 80, 100, 30);
        User_Name = new JTextField(10);
        User_Name.setForeground(Color.YELLOW);
        User_Name.setBounds(150, 50, 100, 30);
        User_Name.addActionListener(this);
        User_Pass = new JPasswordField(10);
        User_Pass.setEchoChar("-");
        User_Pass.addActionListener(this);
        User_Pass.setBounds(50, 120, 100, 30);
        First_Button = new JButton("Proceed");
        First_Button.setForeground(Color.GRAY);
        First_Button.addActionListener(this);
        First_Button.setBounds(50, 120, 100, 30);
        Second_Button = new JButton("Abort");
        Second_Button.setForeground(Color.GRAY);
        Second_Button.addActionListener(this);
        Second_Button.setBounds(180, 120, 100, 30);

        First_Button.setMnemonic('P');
        Second_Button.setMnemonic('C');

        Front_Side.getContentPane().add(First_Lable);
        Front_Side.getContentPane().add(Second_Lable);
        Front_Side.getContentPane().add(Second_Button);
        Front_Side.getContentPane().add(User_Name);
        Front_Side.getContentPane().add(User_Pass);
        Front_Side.getContentPane().add(First_Button);
        Front_Side.setBounds(300, 300, 300, 200);
        Front_Side.setResizable(false);
        Front_Side.setVisible(true);
    }

    public void Action_ToPerformed(ActionEvent event) {
        if (event.getSource() == First_Button) {
            if (User_Name.getText().length() == 0 || User_Pass.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Some Input Fields are Missing !!");
            } else if (User_Name.getText().equals("Railway_Admin") && User_Pass.getText().equals("Rail_Admin_12345")) {
                Front_Side.setVisible(false);
                Main_Content_Program = new Main_Content();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong User Name OR Password Which has Entered");
            }
        } else {
            Front_Side.setVisible(false);
            System.exit(0);
        }
    }
}
