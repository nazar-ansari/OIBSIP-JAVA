package Task_Assessment_1;

// Importing Required Libraries for Program
import java.awt.*;
import java.awt.event.*;
import java.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main_Content implements ActionListener {
    JFrame Front_Side;
    JButton First_Button, Second_Button, Third_Button, Fourth_Button;
    JLabel Image_Lable;
    ImageIcon Main_Content_Icon_Img;
    Reservation_Detail User_Reservation;
    Enquiry_Detail User_Enquiry;
    Cancellation_Detail User_Cancellation;

    Main_Content() {
        Main_Content_Icon_Img = new ImageIcon("Railway_Network_Image.jpg");
        Image_Lable = new JLabel(Main_Content_Icon_Img);
        Image_Lable.setBounds(0, 0, 1300, 1000);
        Front_Side = new JFrame("Reservation Detail Form");
        Front_Side.getContentPane().setLayout(null);
        Front_Side.getContentPane().setBackground(Color.LIGHT_GRAY);
        First_Button = new JButton("Request For Reservation");
        First_Button.addActionListener(this);
        First_Button.setBounds(150, 390, 210, 60);
        Second_Button = new JButton("Request For PNR-Enquiry");
        Second_Button.addActionListener(this);
        Second_Button.setBounds(150, 490, 210, 60);
        Third_Button = new JButton("Request For Cancellation");
        Third_Button.addActionListener(this);
        Third_Button.setBounds(580, 390, 210, 60);
        Fourth_Button = new JButton("Exit From ApplicationF");
        Fourth_Button.addActionListener(this);
        Fourth_Button.setBounds(580, 490, 210, 60);

        First_Button.setBackground(new Color(255, 255, 255));
        First_Button.setForeground(new Color(100, 200, 0));
        Second_Button.setBackground(new Color(255, 255, 255));
        Second_Button.setForeground(new Color(100, 200, 0));
        Third_Button.setBackground(new Color(255, 255, 255));
        Third_Button.setForeground(new Color(100, 200, 0));
        Fourth_Button.setBackground(new Color(255, 255, 255));
        Fourth_Button.setForeground(new Color(100, 200, 0));

        Front_Side.getContentPane().add(First_Button);
        Front_Side.getContentPane().add(Second_Button);
        Front_Side.getContentPane().add(Third_Button);
        Front_Side.getContentPane().add(Fourth_Button);

        Front_Side.setSize(1300, 1000);
        Front_Side.setVisible(true);
    }

    public void Action_To_Performed(ActionEvent event) {
        if (event.getSource() == First_Button) {
            Front_Side.setVisible(false);
            User_Reservation = new Reservation_Detail();
        } else if (event.getSource() == Second_Button) {
            Front_Side.setVisible(false);
            User_Enquiry = new Enquiry_Detail();
        } else if (event.getSource() == Third_Button) {
            Front_Side.setVisible(false);
            User_Cancellation = new Cancellation_Detail();
        } else {
            Front_Side.setVisible(false);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Main_Content();
    }
}
