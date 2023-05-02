package Task_Assessment_1;

// Importing Required Libraries for Program
import java.awt.*;
import java.awt.Taskbar.State;
import java.awt.desktop.UserSessionListener;
import java.awt.event.*;
import java.beans.Statement;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class Cancellation_Detail {
    JFrame Front_Side;
    JLabel First_Lable, Second_Lable, Third_Lable, Fourth_Lable, Fifth_Lable, Sixth_Lable, Seventh_Lable, Eighth_Lable,
            Nineth_Lable, Tenth_Lable, Eleveth_Lable;
    JTextField First_Text, Second_Text, Third_Text, Fourth_Text, Fifth_Text, Sixth_Text, Seventh_Text;
    JButton First_Button, Second_Button;
    Choice User_Choice;
    List Collection_List;
    PreparedStatement Preapre_Statement;
    ResultSet Result_Set;
    Statement State_Ment;

    Cancellation_Detail() {
        Front_Side = new JFrame("Cancellation Form");
        Front_Side.getContentPane().setLayout(null);
        Front_Side.getContentPane().setBackground(Color.WHITE);
        First_Lable = new JLabel("Enter P-N-R No :");
        First_Lable.setBounds(130, 50, 50, 30);
        Second_Lable = new JLabel("Enter Train No :");
        Second_Lable.setBounds(50, 90, 100, 30);
        Third_Lable = new JLabel("Enter Train Name :");
        Third_Lable.setBounds(130, 120, 100, 30);
        Fourth_Lable = new JLabel("Enter Class of Seat :");
        Fourth_Lable.setBounds(50, 150, 100, 30);
        Fifth_Lable = new JLabel("Enter Date of Journey :");
        Fifth_Lable.setBounds(50, 180, 100, 30);
        Sixth_Lable = new JLabel("Enter Source Station of Train :");
        Sixth_Lable.setBounds(50, 210, 100, 30);
        Seventh_Lable = new JLabel("Enter Destination :");
        Seventh_Lable.setBounds(250, 210, 50, 30);
        Eighth_Lable = new JLabel("Enter Boarding Station :");
        Eighth_Lable.setBounds(50, 240, 100, 30);
        Nineth_Lable = new JLabel("Enter Name of Passenger :");
        Nineth_Lable.setBounds(90, 290, 120, 30);
        Tenth_Lable = new JLabel("Enter Passenger's Age :");
        Tenth_Lable.setBounds(240, 290, 30, 30);
        Eleveth_Lable = new JLabel("Enter Passenger's Gender :");
        Eleveth_Lable.setBounds(290, 290, 100, 30);
        First_Button = new JButton("Done");
        First_Button.setBounds(50, 480, 100, 30);
        First_Button.addActionListener(this);
        First_Button.setBackground(Color.RED);
        Second_Button = new JButton("Go Back");
        Second_Button.addActionListener(this);
        Second_Button.setBackground(Color.RED);
        Second_Button.setBounds(200, 480, 100, 30);

        User_Choice = new Choice();
        User_Choice.setBounds(230, 50, 140, 30);
        User_Choice.addItemListener(this);
        First_Text = new JTextField(10);
        First_Text.setBounds(150, 90, 100, 30);
        First_Text.addActionListener(this);
        Second_Text = new JTextField(10);
        Second_Text.setBounds(150, 120, 100, 30);
        Second_Text.addActionListener(this);
        Third_Text = new JTextField(10);
        Third_Text.setBounds(150, 150, 100, 30);
        Third_Text.addActionListener(this);
        Fourth_Text = new JTextField(10);
        Fourth_Text.setBounds(150, 180, 100, 30);
        Fourth_Text.addActionListener(this);
        Fifth_Text = new JTextField(10);
        Fifth_Text.setBounds(150, 210, 100, 30);
        Fifth_Text.addActionListener(this);
        Sixth_Text = new JTextField(10);
        Sixth_Text.setBounds(300, 90, 100, 30);
        Sixth_Text.addActionListener(this);
        Seventh_Text = new JTextField(10);
        Seventh_Text.setBounds(150, 240, 100, 30);
        Seventh_Text.addActionListener(this);
        Collection_List = new List(5,true)
        Collection_List.setBounds(80,320,320,100);
        Front_Side.getContentPane().add(First_Lable);
        Front_Side.getContentPane().add(Second_Lable);
        Front_Side.getContentPane().add(Third_Lable);
        Front_Side.getContentPane().add(Fourth_Lable);
        Front_Side.getContentPane().add(Fifth_Lable);
        Front_Side.getContentPane().add(Sixth_Lable);
        Front_Side.getContentPane().add(Seventh_Lable);
        Front_Side.getContentPane().add(Eighth_Lable);
        Front_Side.getContentPane().add(Nineth_Lable);
        Front_Side.getContentPane().add(Tenth_Lable);
        Front_Side.getContentPane().add(Eleveth_Lable);
        Front_Side.getContentPane().add(First_Button);
        Front_Side.getContentPane().add(Second_Button);
        Front_Side.getContentPane().add(User_Choice);
        Front_Side.getContentPane().add(First_Text);
        Front_Side.getContentPane().add(Second_Text);
        Front_Side.getContentPane().add(Third_Text);
        Front_Side.getContentPane().add(Fourth_Text);
        Front_Side.getContentPane().add(Fifth_Text);
        Front_Side.getContentPane().add(Sixth_Text);
        Front_Side.getContentPane().add(Seventh_Text);
        Front_Side.getContentPane().add(Collection_List);
        Front_Side.setVisible(true);
        Front_Side.setSize(1300,1000);
        Start_Program();
    }

    private void Start_Program() {
        try {
            State_Ment = con.createStatement();
            Result_Set = State_Ment.executeQuery("SELECT  * FROM Reservation");
            while (Result_Set.next()) {
                User_Choice.add(Result_Set.getString(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Connection Failed :" + e.getMessage());
        }

    }

    public void Item_State_Changed(ItemEvent event) {
        System.out.println((String) User_Choice.getSelectedItem());
        try {
            Collection_List.removeAll();
            Preapre_Statement = con.prepareStatement("SELECT * FROM Reservation WHERE PNR_No=?")
            Preapre_Statement.setString(1, User_Choice.getSelectedItem());
            Result_Set = Preapre_Statement.executeQuery();
            Result_Set.next();
            First_Text.setText(Result_Set.getString(2));
            Second_Text.setText(Result_Set.getString(3));
            Third_Text.setText(Result_Set.getString(4));
            Fourth_Text.setText(Result_Set.getString(5));
            Fifth_Text.setText(Result_Set.getString(6));
            Sixth_Text.setText(Result_Set.getString(7));
            Seventh_Text.setText(Result_Set.getString(8));
            Preapre_Statement = con.prepareStatement("SELECT * FROM Passenger WHERE PNR_No=?")
            Preapre_Statement.setString(1, User_Choice.getSelectedItem());
            Result_Set = Preapre_Statement.executeQuery();
            while (Result_Set.next()) {
                Collection_List.add(Result_Set.getString(2) + "       " + Result_Set.getString(3) + "       " + Result_Set.getString(4));                
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Connection Failed : " + e.getMessage());
        }
    }

    public void On_ActionPerformed(ActionEvent event) {
        if (event.getSource() == First_Button) {
            try {
                Preapre_Statement = con.prepareStatement("DELETE FROM Reservation WHERE PNR_No=?");
                Preapre_Statement.setString(1, User_Choice.getSelectedIndex());
                Preapre_Statement.executeUpdate();

                Preapre_Statement = con.prepareStatement("DELETE FROM Passenger WHERE PNR_No=?");
                Preapre_Statement.setString(1, User_Choice.getSelectedItem());
                Preapre_Statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Reservation Successfully Cancelled", null, 0);
                Front_Side.setVisible(false);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Connection Failed :" + e.getMessage());
            }
        }

        if (event.getSource() == Second_Button) {
            Front_Side.setVisible(false);
            new Main_Content();
        }
    }

    public static void main(String[] args) {
        new Cancellation_Detail();
    }
}
