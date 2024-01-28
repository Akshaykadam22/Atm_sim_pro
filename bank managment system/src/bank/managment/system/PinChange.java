
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin,repin;
    JLabel retext,pintext,text;
    JButton back,change;
    String pinnumber;
    
    PinChange(String pinnumber){
            this.pinnumber=pinnumber;
                           
            ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm1.jpg"));
            Image i2=i1.getImage().getScaledInstance(900,780 ,Image.SCALE_DEFAULT );
            ImageIcon i3=new ImageIcon(i2);
            JLabel label=new JLabel(i3);
            add(label);
            
             text=new JLabel("CHANGE YOUR PIN");
            text.setBounds(197,260, 500, 35);
            text.setFont(new Font("System",Font.BOLD,17));
            text.setForeground(Color.WHITE);
            label.add(text);
            
            pintext=new JLabel("NEW PIN: ");
            pintext.setBounds(120,310, 180, 25);
            pintext.setFont(new Font("System",Font.BOLD,17));
            pintext.setForeground(Color.WHITE);
            label.add(pintext);
            
            pin =new JPasswordField();
            pin.setBounds(260,310, 180, 25);
            pin.setFont(new Font("System",Font.BOLD,17));
            pin.setForeground(Color.black);
            label.add(pin);
            
            
             retext=new JLabel("RE-ENTER PIN: ");
            retext.setBounds(120,350, 180, 16);
            retext.setFont(new Font("System",Font.BOLD,17));
            retext.setForeground(Color.WHITE);
            label.add(retext);
            
            repin =new JPasswordField();
            repin.setBounds(260,340, 180, 25);
            repin.setFont(new Font("System",Font.BOLD,17));
            repin.setForeground(Color.black);
            label.add(repin);
            
            change=new JButton("CHANGE");
            change.setBounds(330,410, 130, 28);
           // change.setFont(new Font("System",Font.BOLD,17));
          //  change.setForeground(Color.WHITE);
            change.addActionListener(this);
            label.add(change);
            
            back=new JButton("BACK");
            back.setBounds(330,450, 130, 28);
           back.addActionListener(this);
            label.add(back);
                    
            setUndecorated(true);
            setLocation(300,0);        
            setSize(800,800);
            setVisible(true);
                    
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
          try{
              String opin=pin.getText();
              String rpin=repin.getText();
              
              if(!opin.equals(rpin)){
                   JOptionPane.showMessageDialog(null, "Entered Pin Does Not Match");
                   return;
              }
              if(opin.equals("")||rpin.equals("")){
                   JOptionPane.showMessageDialog(null, "Please Enter Pin ");
                   return;             
              }
              Conn c=new Conn();
              String query1="update bank set pinNumber= '"+rpin+"' where pinNumber='"+pinnumber+"'";
              String query2="update login set pinNumber= '"+rpin+"' where pinNumber='"+pinnumber+"'";
              String query3="update  signupThree set pinNumber= '"+rpin+"' where pinNumber='"+pinnumber+"'";
              
              c.s.executeUpdate(query1);
              c.s.executeUpdate(query2);
              c.s.executeUpdate(query3);
              
              JOptionPane.showMessageDialog(null, "PIN changed Sucessfully ");
              
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
         }catch(Exception e){
             System.out.println(e);
         }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    } 
    
    
      public static void main(String[] args){
           
          new PinChange("");  
      }
    
}

