package Task_Assessment_1;

// Importing Required Libraries for Program
import java.awt.*;
import java.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Welcome_Banner implements Runnable {
    JFrame Front_Side;
    JLabel First_Lable, Second_Lable, Third_Lable;
    Thread Execution_Thred;
    User_Login_Page Login_Data;
    ImageIcon Image_Icon;

    Welcome_Banner() {
        Image_Icon = new ImageIcon("Railway_Reservation_Icon.jpg");
        Execution_Thred = new Thread(this);
        Front_Side = new JFrame("Welcom To Railway Reservation Portal");
        Front_Side.getContentPane().setLayout(null);
        Front_Side.getContentPane().setBackground(Color.MAGENTA);
        First_Lable = new JLabel("Reservation via Online");
        First_Lable.setBounds(250, 300, 900, 50);
        First_Lable.setFont(new Font("Courier new", Font.BOLD, 60));
        First_Lable.setForeground(Color.BLACK);
        Second_Lable = new JLabel("By GuidLine Community of Railway");
        Second_Lable.setBounds(350, 380, 800, 40);
        Second_Lable.setFont(new Font("Courier new", Font.BOLD, 35));
        Second_Lable.setForeground(Color.BLACK);
        Third_Lable = new JLabel(Image_Icon);
        Third_Lable.setBounds(0, 0, 1300, 1000);
        Front_Side.getContentPane().add(First_Lable, Execution_Thred);
        Front_Side.getContentPane().add(Second_Lable, Execution_Thred);
        Front_Side.getContentPane().add(Third_Lable, Execution_Thred);
        Front_Side.setSize(1300, 1000);
        Front_Side.setVisible(true);
        Execution_Thred.start();
    }

    // Method to Display The Welcome Banner For Particualr Duration
    public void Total_Duration() {
        int Duration = 1;
        while (Duration <= 3) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
            Duration++;
        }
        Front_Side.setVisible(false);
        Login_Data = new User_Login_Page();
    }

}
