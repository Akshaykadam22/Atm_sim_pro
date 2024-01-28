
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;


public class Withdrawl extends JFrame implements ActionListener{
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
      Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        
            ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm1.jpg"));
            
            
            Image i2 = i1.getImage().getScaledInstance(900, 850, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(0, 0, 900, 700); // Set bounds of the label
            add(label);
         
        
            JLabel text=new JLabel("Enter Amount to Withdraw.");
            text.setBounds(210,230, 700, 35);
            text.setFont(new Font("System",Font.BOLD,17));
            text.setForeground(Color.WHITE);
            label.add(text);
            
            amount=new JTextField();
            amount.setBounds(200,280, 250,28);
            amount.setFont(new Font("System",Font.BOLD,17));
           // amount.setForeground(Color.WHITE);
            label.add(amount);
            
             
            withdraw=new JButton("Withdraw");
            withdraw.setBounds(360, 350, 130, 28);
            withdraw.addActionListener(this);
            add(withdraw);
            
            back=new JButton("Back");
            back.setBounds(360, 400, 130, 28);
            back.addActionListener(this);
            add(back);
            
            setSize(850, 900);
            setLocation(250, 0);
            setUndecorated(true);
            setVisible(true);
        
            
      }
      public void actionPerformed(ActionEvent ae){
           if(ae.getSource()== back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
           }else if(ae.getSource()== withdraw){
               String wamount=amount.getText();
               Date date=new Date();
                if(wamount.equals("")||Integer.parseInt(wamount)<=0){
                     JOptionPane.showMessageDialog(null,"Please enter Valid amount to withdraw");    
                }else{
                    try{
                     Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery("select * from bank where pinNumber= '"+pinnumber+"'");
                     int balance=0;
                      while(rs.next()){
                         if(rs.getString("type").equals("Deposit")){
                              balance+=Integer.parseInt(rs.getString("amount"));                             
                        }else{
                              balance-=Integer.parseInt(rs.getString("amount"));
                         }
                     }
                      if(ae.getSource() != back && balance < Integer.parseInt(wamount)){
                         JOptionPane.showMessageDialog(null,"Insufficent Balance");
                         return;
                     }
                    String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+wamount+"')";
                    c.s.executeUpdate(query);
                 
                     JOptionPane.showMessageDialog(null,"Rs. "+wamount+" withdrawed Sucessfully");
                     
                                 
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
               
           }
           
      }
      
      public static void main(String[] args){
           
          new Withdrawl("");
      }
}
