
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
         JButton tnhun,hun,fhun,thun,tthun,fthun,back;
         String pinnumber;
    FastCash(String pinno) {
        this.pinnumber=pinno;
        setLayout(null);

        
            ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm1.jpg"));
            
            
            Image i2 = i1.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(0, 0, 900, 700); // Set bounds of the label
            add(label);
         
        
            JLabel text=new JLabel("SELECT WITHDRAWAL AMOUNT");
            text.setBounds(210,230, 700, 35);
            text.setFont(new Font("System",Font.BOLD,17));
            text.setForeground(Color.WHITE);
            label.add(text);
            
            hun=new JButton("Rs 100");
            hun.setBounds(180, 310, 130, 28);
            hun.addActionListener(this);
            add(hun);
            
            fhun=new JButton("Rs 500");
            fhun.setBounds(360, 310, 130, 28);
            fhun.addActionListener(this);
            add(fhun);
            
            thun=new JButton("Rs 1000");
            thun.setBounds(180, 345, 130, 28);
            thun.addActionListener(this);
            add(thun);
            
            tthun=new JButton("Rs 2000");
            tthun.setBounds(360, 345, 130, 28);
            tthun.addActionListener(this);
            add(tthun);
            
            fthun=new JButton("Rs 5000");
            fthun.setBounds(180, 380, 130, 28);
            fthun.addActionListener(this);
            add(fthun);
            
            tnhun=new JButton("Rs 10000");
            tnhun.setBounds(360, 380 ,130, 28);
            tnhun.addActionListener(this);
            add(tnhun);
            
            back=new JButton("Back");
            back.setBounds(360, 415 ,130, 28);
            back.addActionListener(this);
            add(back);
            
            
            
            setSize(850, 900);
            setLocation(250, 0);
            setUndecorated(true);
            setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
             if(ae.getSource()==back){
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
             }else{
                 String Famount=((JButton)ae.getSource()).getText().substring(3);
                 Conn c=new Conn();
                 try{
                     ResultSet rs=c.s.executeQuery("select * from bank where pinNumber= '"+pinnumber+"'");
                     int balance=0;
                     while(rs.next()){
                         if(rs.getString("type").equals("Deposit")){
                              balance+=Integer.parseInt(rs.getString("amount"));
                        }else{
                             balance-=Integer.parseInt(rs.getString("amount")); 
                         }
                     }
                     if(ae.getSource() != back && balance < Integer.parseInt(Famount)){
                         JOptionPane.showMessageDialog(null,"Insufficent Balance");
                         return;
                     }
                     
                       Date date=new Date();
                       String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+Famount+"')";
                       c.s.executeUpdate(query);
                       JOptionPane.showMessageDialog(null,"Rs "+Famount+"Debited Sucessfully..");
                      
                      setVisible(false);
                      new Transactions(pinnumber).setVisible(true);
                 } catch(Exception e){
                     System.out.println(e);
                 }
             }
             
               
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}

