package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
         JButton deposit,cashw,cashf,mini,pinchange,enquiry,exit;
         String pinnumber;
       Transactions(String pinno) {
               
        this.pinnumber=pinno;
        setLayout(null);

        
            ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm1.jpg"));
            
            
            Image i2 = i1.getImage().getScaledInstance(900, 850, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(0, 0, 900, 700); // Set bounds of the label
            add(label);
         
        
            JLabel text=new JLabel("Please select your Transaction");
            text.setBounds(210,230, 700, 35);
            text.setFont(new Font("System",Font.BOLD,17));
            text.setForeground(Color.WHITE);
            label.add(text);
            
            deposit=new JButton("Deposit");
            deposit.setBounds(180, 310, 130, 28);
            deposit.addActionListener(this);
            add(deposit);
            
            cashw=new JButton("Cash Wthdraw");
            cashw.setBounds(360, 310, 130, 28);
            cashw.addActionListener(this);
            add(cashw);
            
            cashf=new JButton("Fast Cash");
            cashf.setBounds(180, 345, 130, 28);
            cashf.addActionListener(this);
            add(cashf);
            
            mini=new JButton("Mini Statment");
            mini.setBounds(360, 345, 130, 28);
            mini.addActionListener(this);
            add(mini);
            
            pinchange=new JButton("Pin Change");
            pinchange.setBounds(180, 380, 130, 28);
            pinchange.addActionListener(this);
            add(pinchange);
            
            enquiry=new JButton("Balance Enquiry");
            enquiry.setBounds(360, 380 ,130, 28);
            enquiry.addActionListener(this);
            add(enquiry);
            
            exit=new JButton("Exit");
            exit.setBounds(360, 415 ,130, 28);
            exit.addActionListener(this);
            add(exit);
            
            
            
            setSize(850, 900);
            setLocation(250, 0);
            setUndecorated(true);
            setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
             if(ae.getSource()==exit){
                 System.exit(0);
             }else if(ae.getSource()== deposit){
                   setVisible(false);
                   new Deposit(pinnumber).setVisible(true);
             }else if(ae.getSource()==cashw){
                 setVisible(false);
                   new Withdrawl(pinnumber).setVisible(true);
             }else if(ae.getSource()== cashf){
                  setVisible(false);
                    new  FastCash(pinnumber).setVisible(true);
             }else if(ae.getSource()==pinchange){
                 setVisible(false);
                 new PinChange(pinnumber).setVisible(true);
             }else if(ae.getSource()==enquiry){
                 setVisible(false);
                 new BalanceEnquiry(pinnumber).setVisible(true);
             }else if (ae.getSource()==mini){
                 new MiniStatement( pinnumber).setVisible(true);
             }
               
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}

