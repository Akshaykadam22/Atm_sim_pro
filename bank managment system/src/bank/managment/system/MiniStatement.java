package bank.managment.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pinnumber;
   
    MiniStatement(String pinnumber) { 
        
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 120, 400, 400);
        add(mini);

        JLabel bank = new JLabel("(^$)_Kadam's_Bank");
        bank.setFont(new Font("System", Font.BOLD, 19));
        bank.setBounds(100, 20, 400, 20);
        add(bank);

        JLabel name = new JLabel();
        name.setBounds(100, 20, 400, 20);
        add(name);

        JLabel card = new JLabel();
        card.setBounds(40, 50, 900, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 500, 300, 20);
        add(balance);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinNumber='" + pinnumber + "'");
            while (rs.next()) {
                card.setText("CardNumber :" + rs.getString("cardNumber").substring(0, 4) + "-XXXX-XXXX-" + rs.getString("cardNumber").substring(10, 14));
            }
        } catch (Exception e) {
            System.out.print(e);
        }

        try {
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pinNumber='" + pinnumber + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance Is Rs." + bal);

        } catch (Exception e) {
            System.out.print(e);
        }

        setSize(400, 600);
        setLocation(20, 30);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {

        new MiniStatement("");
    }
}
