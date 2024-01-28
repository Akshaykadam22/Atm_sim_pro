
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JLabel text;
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
            this.pinnumber=pinnumber;
                           
            ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm1.jpg"));
            Image i2=i1.getImage().getScaledInstance(900,780 ,Image.SCALE_DEFAULT );
            ImageIcon i3=new ImageIcon(i2);
            JLabel label=new JLabel(i3);
            add(label);
            
            back=new JButton("BACK");
            back.setBounds(330,450, 130, 28);
            back.addActionListener(this);
            label.add(back);
            int balance=0;        
            try{
                     Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery("select * from bank where pinNumber= '"+pinnumber+"'");
                     
                      while(rs.next()){
                         if(rs.getString("type").equals("Deposit")){
                              balance+=Integer.parseInt(rs.getString("amount"));                             
                        }else{
                              balance-=Integer.parseInt(rs.getString("amount"));
                         }
                      }
                    }catch(Exception e){
                        System.out.println(e);
                    }
            text=new JLabel("Your Current Account Balance is Rs "+balance);
            text.setFont(new Font("System",Font.BOLD,16));
            text.setForeground(Color.white);
            text.setBounds(130,300,400,30);
            label.add(text);
            
            setUndecorated(true);
            setLocation(300,0);        
            setSize(800,800);
            setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    } 
    
    
      public static void main(String[] args){
           
          new BalanceEnquiry("");  
      }
    
}

