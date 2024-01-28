
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
      Deposit(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        
            ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm1.jpg"));
            
            
            Image i2 = i1.getImage().getScaledInstance(900, 850, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(0, 0, 900, 700); // Set bounds of the label
            add(label);
         
        
            JLabel text=new JLabel("Enter Amount to Deposit.");
            text.setBounds(210,230, 700, 35);
            text.setFont(new Font("System",Font.BOLD,17));
            text.setForeground(Color.WHITE);
            label.add(text);
            
            amount=new JTextField();
            amount.setBounds(200,280, 250,28);
            amount.setFont(new Font("System",Font.BOLD,17));
           // amount.setForeground(Color.WHITE);
            label.add(amount);
            
             
            deposit=new JButton("Deposit");
            deposit.setBounds(360, 350, 130, 28);
            deposit.addActionListener(this);
            add(deposit);
            
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
           }else if(ae.getSource()== deposit){
               String number=amount.getText();
               Date date=new Date();
                if(number.equals("")){
                     JOptionPane.showMessageDialog(null,"Please enter amount you want to deposite");    
                }else{
                    try{
                     Conn c=new Conn();
                     
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs."+number+" Desposited Sucessfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
               
           }
           
      }
      
      public static void main(String[] args){
           
          new Deposit("");
      }
}
