package Task_Assessment_1;

// Importing Required Libraries for Program
import java.awt.*;
import java.awt.Taskbar.State;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.*;
import java.swing.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.PresentationDirection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.stream.events.StartElement;

public class Reservation_Detail implements ActionListener, FocusListener {
    JFrame Front_Side;
    JLabel First_Lable, Second_Lable, Third_Lable, Fourth_Lable, Fifth_Lable, Sixth_Lable, Seventh_Lable, Eight_Lable,
            Nine_Lable, Ten_Lable, Eleven_Lable, Twelve_Lable, Thirteen_Lable;
    JTextField First_Text, Second_Text, Third_Text, Fourth_Text, Fifth_Text, Sixth_Text, Seventh_Text;
    Choice User_Choice;
    JTextArea Description_Detail;
    JButton First_Button, Second_Button, Third_Button;
    PreparedStatement Prepare_Statement;
    Statement State_Ment;
    ResultSet Result_Set;
    JLabel Image_Lable;
    ImageIcon Image;

    void Disable_Elements() {
        First_Text.setEnabled(false);
        Second_Text.setEnabled(false);
        Third_Text.setEnabled(false);
        Fourth_Text.setEnabled(false);
        Fifth_Text.setEnabled(false);
        Sixth_Text.setEnabled(false);
        Seventh_Text.setEnabled(false);
        User_Choice.setEnabled(false);
        Second_Button.setEnabled(false);
    }

    void Enable_Elements() {
        First_Text.setEnabled(true);
        Second_Text.setEnabled(true);
        Third_Text.setEnabled(true);
        Fourth_Text.setEnabled(true);
        Fifth_Text.setEnabled(true);
        Sixth_Text.setEnabled(true);
        Seventh_Text.setEnabled(true);
        User_Choice.setEnabled(true);
        Second_Button.setEnabled(true);
    }

    Reservation_Detail() {
        Image = new ImageIcon("First_Logo.png");
        Image_Lable = new JLabel(Image);
        Image_Lable.setBounds(0, 320, 500, 250);
        Front_Side = new JFrame("Reservation Form Details");
        Front_Side.getContentPane().setLayout(null);
        Front_Side.getContentPane().setBackground(Color.blue);
        First_Lable = new JLabel("Enter PNR No");
        First_Lable.setBorder(130, 50, 100, 30);
        Second_Lable = new JLabel("Enter Train No");
        Second_Lable.setBorder(50, 80, 100, 30);
        Third_Lable = new JLabel("Enter Train Name");
        Third_Lable.setBorder(50, 110, 100, 30);
        Fourth_Lable = new JLabel("Enter Date of Journey");
        Fourth_Lable.setBounds(50, 170, 100, 30);
        Fifth_Lable = new JLabel("Enter Class of Your Seat");
        Fifth_Lable.setBounds(50, 140, 100, 30);
        Sixth_Lable = new JLabel("Enter The Arrival Station");
        Sixth_Lable.setBounds(50, 200, 100, 30);
        Seventh_Lable = new JLabel("Enter The Destination Station");
        Seventh_Lable.setBounds(250, 200, 50, 30);
        User_Choice = new Choice();
        User_Choice.setBackground(150, 140, 100, 30);
        User_Choice.add("Air Contidioned Class");
        User_Choice.add("Sleeper Class");
        First_Button = new JButton("Enter The Record");
        First_Button.setBackground(50, 270, 100, 30);
        First_Button.addActionListener(this);
        Second_Button = new JButton("Proceed Further");
        Second_Button.setBounds(160, 270, 100, 30);
        Second_Button.addActionListener(this);
        Third_Button = new JButton("Head To Main Window Panel");
        Third_Button.setBackground(270, 270, 100, 30);
        Third_Button.addActionListener(this);
        First_Text = new JTextField(10);
        First_Text.setBounds(230, 50, 120, 30);
        Second_Text = new JTextField(10);
        Second_Text.addFocusListener(this);
        Second_Text.setBounds(150, 80, 100, 30);
        Third_Text = new JTextField(10);
        Third_Text.setBounds(150, 170, 100, 30);
        Fourth_Text = new JTextField(10);
        Fourth_Text.setBounds(150, 170, 100, 30);
        Fifth_Text = new JTextField(10);
        Fifth_Text.setBounds(150, 200, 100, 30);
        Sixth_Text = new JTextField(10);
        Sixth_Text.setBorder(300, 200, 100, 30);
        Seventh_Text = new JTextField(10);
        Seventh_Text.setBounds(150, 230, 100, 30);

        Front_Side.getContentPane().add(First_Lable);
        Front_Side.getContentPane().add(Second_Lable);
        Front_Side.getContentPane().add(Third_Lable);
        Front_Side.getContentPane().add(Fourth_Lable);
        Front_Side.getContentPane().add(Fifth_Lable);
        Front_Side.getContentPane().add(Sixth_Lable);
        Front_Side.getContentPane().add(Seventh_Lable);
        Front_Side.getContentPane().add(First_Text);
        Front_Side.getContentPane().add(Second_Text);
        Front_Side.getContentPane().add(Third_Text);
        Front_Side.getContentPane().add(Fourth_Text);
        Front_Side.getContentPane().add(Fifth_Text);
        Front_Side.getContentPane().add(Sixth_Text);
        Front_Side.getContentPane().add(Seventh_Text);
        Front_Side.getContentPane().add(User_Choice);
        Front_Side.getContentPane().add(First_Button);
        Front_Side.getContentPane().add(Second_Button);
        Front_Side.getContentPane().add(Third_Button);
        Front_Side.getContentPane().add(Image_Lable);
        Front_Side.setSize(1300, 1000);
        Front_Side.setVisible(true);
        Disable_Elements();
    }

    public void On_Focus_Move(FocusEvent event) {
        if (Second_Text.getText().length() != 0) {
            try {
                Prepare_Statement = con.prepareStatement("SELECT Train_Name FROM Train WHERE Train_No=?");
                Prepare_Statement.setString(1, Second_Text.getText());
                Result_Set = Prepare_Statement.executeQuery();
                if (Result_Set.next()) {
                    Third_Text.setText(Result_Set.getString(1));
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Connection Error" + e.getMessage());
            }
        }
    }

    public void On_Focus(FocusEvent event) {

    }

    public void On_Action_Performed(ActionEvent event) {
        if ( event.getSource() == First_Button){
            Enable_Elements();
            First_Button.setEnabled(false);
            try {
                State_Ment = con.createStatement();
                Result_Set = Statement.executeQuery("SELECT * FROM PNR_TABLE");
                Result_Set.next();
                int Result = Result_Set.getInt(1);
                First_Text.setText(String.valueOf(Result));
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Connection Failed" + e.getMessage());
            }
        }
        else ( event.getSource() == Second_Button){
            try {
                Prepare_Statement = con.prepareStatement("INSERT INTO Reservation_Table VALUES (?,?,?,?,?,?,?)")
                Prepare_Statement.setString(1, First_Text.getText());
                Prepare_Statement.setString(2, Second_Text.getText());
                Prepare_Statement.setString(3, Third_Text.getText());
                Prepare_Statement.setString(4, User_Choice.getSelectedItem());
                Prepare_Statement.setString(5, Fourth_Text.getText());
                Prepare_Statement.setString(6, Fifth_Text.getText());
                Prepare_Statement.setString(7, Sixth_Text.getText());
                Prepare_Statement.executeUpdate();

                Prepare_Statement = con.prepareStatement("UPDATE PNR_TABLE SET PNR_NO=? WHERE PNR_NO=?");
                Prepare_Statement.setInt(1, Result+1);
                Prepare_Statement.setInt(2, Result);
                Prepare_Statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Successfully Updated The Existing Record");

                First_Button.setEnabled(true);
                Second_Button.setEnabled(false);
                Front_Side.setVisible(false);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Connection Failed" + e.getMessage());
            }

            try {
                State_Ment = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
                Result_Set = State_Ment.executeQuery("SELECT * FROM Reservation_Detail")
                Result_Set.last();
                Result = Result_Set.getInt(1);
                Passenger_Section Passenger = new Passenger_Section(Result);
                State_Ment = con.createStatement();
                Result_Set = State_Ment.executeQuery("SELECT * FROM Passenger_ID")
                Result = Result_Set.getInt(1);
                Prepare_Statement = prepareStatement("UPDATE Passenger_ID SET PassengerID=? WHERE PassengerID=?");
                Prepare_Statement.setInt(1, Result+1);
                Prepare_Statement.setInt(2, Result);
                Prepare_Statement.executeUpdate();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Connection Fail !" + e.getMessage());
            }            
        }
        else if {event.getSource() == Third_Button}{
            Front_Side.setVisible(false);
            new Main_Content();
        }
    }

    public static void main(String[] args) {
        new Reservation_Detail();
    }
}
