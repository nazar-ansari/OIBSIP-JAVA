package Task_Assessment_1;

// Importing Required Libraries for Program
import java.awt.*;
import java.awt.Taskbar.State;
import java.awt.event.*;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.swing.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Passenger_Section extends Connection_File implements ActionListener {
    JFrame Front_Side;
    JLabel First_Lable, Second_Lable, Third_Lable, Fourth_Lable, Fifth_Lable, Sixth_Lable;
    JTextField First_Text, Second_Text, Third_Text;
    JButton First_Button, Second_Button, Third_Button;
    Checkbox FIrst_Check, Second_Check, Third_Check, Fourth_Check, Fifth_Check;
    CheckboxGroup CheckBox_Group;
    JTextArea Text_Area;
    PreparedStatement Prepare_Statement;
    Statement State_Ment;
    ResultSet Result_Set;
    int Passenger_No;
    JLabel Image_Lable;
    ImageIcon Image;

    Passenger_Section(int Passenger) {
        Passenger_No = Passenger;
        Image = new ImageIcon("Passenger_Logo.jpg");
        Image_Lable = new JLabel(Image);
        Image_Lable.setBounds(0, 400, 400, 200);
        Front_Side = new JFrame("Passenger Detail Section");
        Front_Side.getContentPane().setLayout(null);
        Front_Side.getContentPane().setBackground(Color.ORANGE);
        First_Lable = new JLabel("Enter Passenter ID");
        First_Lable.setBounds(50, 50, 100, 30);
        First_Text = new JTextField(10);
        First_Text.setBounds(170, 80, 100, 30);
        Second_Text = new JTextField(10);
        Second_Text.setBounds(170, 80, 100, 30);
        Third_Lable = new JLabel("Enter The Age of Passenger");
        Third_Lable.setBounds(50, 130, 100, 30);
        Third_Text = new JTextField(10);
        Third_Text.setBounds(150, 130, 50, 30);
        Fourth_Lable = new JLabel("Enter Gender of Passenger");
        Fourth_Lable.setBounds(250, 130, 50, 30);
        Text_Area = new JTextArea(5, 10);
        Text_Area.setBounds(150, 170, 130, 70);
        Fifth_Lable = new JLabel("Enter The Address of Resident");
        Fifth_Lable.setBounds(50, 170, 100, 30);
        Sixth_Lable = new JLabel("Enter the Category");
        Sixth_Lable.setBounds(50, 240, 100, 30);
        First_Button = new JButton("Add More Details");
        First_Button.setBounds(50, 330, 100, 30);
        Second_Button = new JButton("Save The Details");
        Second_Button.setBounds(170, 330, 100, 30);
        Second_Button.setBackground(Color.GREEN);
        Second_Button.addActionListener(this);
        Third_Button = new JButton("Go Back To Previous ->");
        Third_Button.setBounds(290, 330, 100, 30);
        Third_Button.setBackground(Color.RED);
        Third_Button.addActionListener(this);

        CheckBox_Group = new CheckboxGroup();
        FIrst_Check = new Checkbox("Male", CheckBox_Group, true);
        FIrst_Check.setBounds(300, 130, 100, 30);
        Second_Check = new Checkbox("Female", CheckBox_Group, true);
        Second_Check.setBounds(300, 160, 100, 30);
        Third_Check = new Checkbox("General Bogi");
        Third_Check.setBounds(150, 240, 100, 30);
        Fourth_Check = new Checkbox("is Senior Citizen");
        Fourth_Check.setBounds(150, 270, 100, 30);
        Fifth_Check = new Checkbox("Ex- Servicemen Officer");
        Fifth_Check.setBounds(150, 300, 100, 30);

        Front_Side.getContentPane().add(First_Lable);
        Front_Side.getContentPane().add(Second_Lable);
        Front_Side.getContentPane().add(Third_Lable);
        Front_Side.getContentPane().add(Fourth_Lable);
        Front_Side.getContentPane().add(Fifth_Lable);
        Front_Side.getContentPane().add(Sixth_Lable);
        Front_Side.getContentPane().add(First_Text);
        Front_Side.getContentPane().add(Second_Text);
        Front_Side.getContentPane().add(Third_Text);
        Front_Side.getContentPane().add(Text_Area);
        Front_Side.getContentPane().add(First_Button);
        Front_Side.getContentPane().add(First_Button);
        Front_Side.getContentPane().add(First_Button);
        Front_Side.getContentPane().add(FIrst_Check);
        Front_Side.getContentPane().add(Second_Check);
        Front_Side.getContentPane().add(Third_Check);
        Front_Side.getContentPane().add(Fourth_Check);
        Front_Side.getContentPane().add(Fifth_Check);
        Front_Side.getContentPane().add(Image_Lable);
        Front_Side.setSize(1300, 1000);
        Front_Side.setVisible(true);
    }

    public void On_ActionPerformed(ActionEvent event) {
        if (event.getSource() == First_Button){
            try {
                String Concatenate_String =  "";
                Prepare_Statement = con.prepareStatement("INSERT INTO Temporary_Passenger VALUES (?,?,?,?,?,?,?)")
                Prepare_Statement.setString(1, First_Text.getText());
                Prepare_Statement.setString(2, First_Text.getText());
                Prepare_Statement.setString(3, First_Text.getText());
                Prepare_Statement.setString(4, CheckBox_Group.getSelectedCheckbox().getLabel());
                Prepare_Statement.setString(5, Text_Area.getText());

                if (Third_Check.getState()){
                    Concatenate_String += Third_Check.getLabel() +',';
                }
                else if(Fourth_Check.getState()){
                    Concatenate_String += Fourth_Check.getLabel() + ',';
                }
                else if ( Fifth_Check.getState()){
                    Concatenate_String += Fifth_Check.getLabel() + ',';
                }
                else{
                    System.out.println("Didn't Find Anything");
                }
                Prepare_Statement.setString(6, Concatenate_String);
                Prepare_Statement.setString(7, Passenger_No);
                Prepare_Statement.executeUpdate();
                Prepare_Statement.close();

                Passenger_Section New_Passenger = new Passenger_Section(Passenger_No)
                State_Ment = con.createStatement();
                Result_Set = State_Ment.executeQuery("SELECT * FROM PassengerID");
                Result_Set.next();
                int Result = Result_Set.getInt(1)
                New_Passenger.First_Text.setText(String.valueOf(Result));
                Prepare_Statement = con.prepareStatement("UPDATE PassengerID SET Passenger_ID=? WHERE Passenger_ID=?");
                Prepare_Statement.setInt(1, Result+1);
                Prepare_Statement.setInt(2, Result);
                Prepare_Statement.executeUpdate();
                Prepare_Statement.close();

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Connection Failed" + e.getMessage());
            }            
        }
        if (event.getSource() == Second_Button){
            try {
                String Concatenate_String =  "";
                Prepare_Statement = con.prepareStatement("INSERT INTO Temporary_Passenger VALUES (?,?,?,?,?,?,?)")
                Prepare_Statement.setString(1, First_Text.getText());
                Prepare_Statement.setString(2, First_Text.getText());
                Prepare_Statement.setString(3, First_Text.getText());
                Prepare_Statement.setString(4, CheckBox_Group.getSelectedCheckbox().getLabel());
                Prepare_Statement.setString(5, Text_Area.getText());

                if (Third_Check.getState()){
                    Concatenate_String += Third_Check.getLabel() +',';
                }
                else if(Fourth_Check.getState()){
                    Concatenate_String += Fourth_Check.getLabel() + ',';
                }
                else if ( Fifth_Check.getState()){
                    Concatenate_String += Fifth_Check.getLabel() + ',';
                }
                else{
                    System.out.println("Didn't Find Anything");
                }
                Prepare_Statement.setString(6, Concatenate_String);
                Prepare_Statement.setString(7, Passenger_No);
                Prepare_Statement.executeUpdate();
                Prepare_Statement.close();

                State_Ment = con.createStatement();
                Result_Set = State_Ment.executeQuery("SELECT * FROM Temporary_Passenger");
                while ( Result_Set.next()){
                    Prepare_Statement = con.prepareStatement("INSERT INTO Passenger_ID VALUES (?,?,?,?,?,?,?)")
                    Prepare_Statement.setString(1, Result_Set.getString(1));
                    Prepare_Statement.setString(2, Result_Set.getString(2));
                    Prepare_Statement.setString(3, Result_Set.getString(3));
                    Prepare_Statement.setString(4, Result_Set.getString(4));
                    Prepare_Statement.setString(5, Result_Set.getString(5));
                    Prepare_Statement.setString(6, Result_Set.getString(6));
                    Prepare_Statement.setString(7, Result_Set.getString(7));
                    Prepare_Statement.executeUpdate();
                    Prepare_Statement.close();
                }

                State_Ment = con.createStatement();
                State_Ment.executeUpdate("DELETE * FROM Temporary_Passenger");
                JOptionPane.showMessageDialog(null, "Sucessfully Saved The Record");
                Second_Button.setEnabled(false);
                First_Button.setEnabled(false);
                Prepare_Statement.close();

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Connection Failed" + e.getMessage());
            }
        }
        if (event.getSource() == Third_Button){
            Front_Side.setVisible(false);
            new Reservation_Detail();
        }
    }

    public static void main(String[] args) {
        new Passenger_Section(0)
    }
}
