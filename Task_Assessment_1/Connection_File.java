package Task_Assessment_1;

// Importing Required Libraries for Program
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Connection_File {
    Connection con;

    public Connect(){
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=Railway.mdb;DriverID=22" );            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Connection Failed:" + e.getMessage());
        }
    }
}
