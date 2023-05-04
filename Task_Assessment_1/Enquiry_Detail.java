package Task_Assessment_1;

// Importing Required Libraries for Program
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.swing.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Enquiry_Detail extends Connection_File implements ActionListener {
    JFrame Front_Side;
    JLabel First_Lable, Second_Lable;
    JTextField Text_Field;
    List Collection_List;
    JButton First_Button, Second_Button;
    PreparedStatement Prepare_Statement;
    ResultSet Result_Set;
    JLabel Image_Lable;
    ImageIcon Image;

    Enquiry_Detail() {
        Image = new ImageIcon("Basic_Image.jpg");
        Image_Lable = new JLabel(Image);
        Image_Lable.setBounds(0, 340, 500, 200);
        Front_Side = new JFrame("Enquiry Detail Form");
        Front_Side.getContentPane().setLayout(null);
        Front_Side.getContentPane().setBackground(Color.GREEN);
        First_Lable = new JLabel("Enter P-N-R No :");
        First_Lable.setBounds(50, 50, 60, 30);
        Second_Lable = new JLabel("Enter P-N-R Detail :");
        Second_Lable.setBounds(50, 80, 100, 30);
        Text_Field = new JTextField(10);
        Text_Field.setBounds(110, 50, 150, 30);
        Text_Field.addActionListener(this);
        Collection_List = new List();
        Collection_List.setBounds(50, 110, 390, 180);
        First_Button = new JButton("Check The Detail");
        First_Button.setBackground(Color.BLACK);
        First_Button.addActionListener(this);
        First_Button.setBounds(70, 300, 100, 30);
        Second_Button = new JButton("Go Back");
        Second_Button.setBackground(Color.BLACK);
        Second_Button.addActionListener(this);
        Second_Button.setBounds(210, 300, 100, 30);

        Front_Side.getContentPane().add(First_Lable);
        Front_Side.getContentPane().add(Second_Lable);
        Front_Side.getContentPane().add(Text_Field);
        Front_Side.getContentPane().add(Collection_List);
        Front_Side.getContentPane().add(First_Button);
        Front_Side.getContentPane().add(Second_Button);
        Front_Side.getContentPane().add(Image_Lable);
        Front_Side.setSize(1300, 1000);
        Front_Side.setVisible(true);

    }

    public void On_ActionPerformed(ActionEvent event) {
        if (event.getSource() == First_Button){
            try {
                Prepare_Statement = con.prepareStatement("SELECT * FROM Reservation WHERE PNR_No=?")
                Prepare_Statement.setString(1, Text_Field.getText());
                Result_Set = Prepare_Statement.executeQuery();
                Result_Set.next();
                Collection_List.clear();;
                Collection_List.add("Train No:" + Result_Set.getString(2) );
                Collection_List.add("Train Name :" + Result_Set.getString(3) );
                Collection_List.add("Class Type :" + Result_Set.getString(4) );
                Collection_List.add("Date of Journey :" + Result_Set.getString(5) );
                Collection_List.add("From :" + Result_Set.getString(6) );
                Collection_List.add("Destination :" + Result_Set.getString(7) );
                Collection_List.add("Boarding At :" + Result_Set.getString(8) );

                Prepare_Statement = con.prepareStatement("SELECT * FROM Passenger WHERE PNR_N0=?")
                Prepare_Statement.setString(1, Text_Field.getText());
                Result_Set = Prepare_Statement.executeQuery();

                while( Result_Set.next()){
                    Collection_List.add("Passenger Name :" + Result_Set.getString(2));
                    Collection_List.add("Passenger Age :" + Result_Set.getString(3));
                    Collection_List.add("Passenger Gender :" + Result_Set.getString(4));
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Connection Failed :" + e.getMessage());
            }
        }
        if (event.getSource() == Second_Button){
            Front_Side.setVisible(false);
            new Main_Content();
        }
    }

    public static void main(String[] args) {
        new Enquiry_Detail();
    }
}
