
package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JRadioButton r1,r2,r3,r4;
    JButton submit,cancel;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    SignupThree(String formno){
           setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
    
       
        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        
        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        
        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
    
        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
    
        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
         
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);
        
        setLayout(null);
        
        l11.setBounds(686,10,70,30);
        add(l11);
        
        l12.setBounds(750,10,40,30);
        add(l12);
        
        l1.setBounds(280,20,400,40);
        add(l1); 
        
        l2.setBounds(100,90,200,30);
        add(l2);
        
        r1.setBounds(100,120,150,30);
        add(r1);
        
        r2.setBounds(350,120,300,30);
        add(r2);
        
        r3.setBounds(100,150,250,30);
        add(r3);
        
        r4.setBounds(350,150 ,250,30);
        add(r4);
        
        l3.setBounds(100,200,200,30);
        add(l3);
        
        l4.setBounds(330,200,250,30);
        add(l4);
        
        l5.setBounds(100,230,200,20);
        add(l5);
        
        l6.setBounds(330,230,500,20);
        add(l6);
        
        l7.setBounds(100,270,200,30);
        add(l7);
        
        l8.setBounds(330,280,200,30);
        add(l8);
        
        l9.setBounds(100,300,200,20);
        add(l9);
        
        l10.setBounds(100,340,200,30);
        add(l10);
        
        c1.setBounds(100,370,200,30);
        add(c1);
        
        c2.setBounds(350,370,200,30);
        add(c2);
        
        c3.setBounds(100,410,200,30);
        add(c3);
        
        c4.setBounds(350,410,200,30);
        add(c4);
        
        c5.setBounds(100,450,200,30);
        add(c5);
        
        c6.setBounds(350,450,200,30);
        add(c6);
        
        c7.setBounds(100,490,600,20);
        add(c7);
        
        submit.setBounds(460,550,100,30);
        add(submit);
        
        cancel.setBounds(230,550,100,30);
        add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(840,750);
        setLocation(300,30);
        setVisible(true);
        
      submit.addActionListener(this);
      cancel.addActionListener(this);
        
    }
     public void actionPerformed(ActionEvent ac){
            if(ac.getSource()==submit){
                
                 String accounttype="";
                 if(r1.isSelected()){
                      accounttype="Saving account";
                 }else if(r2.isSelected()){
                     accounttype="Fixed Deposit Account";
                 }else if(r3.isSelected()){
                       accounttype="Current Account";
                 }else if(r4.isSelected()){
                       accounttype="Recurring Deposit Account";
                 }
               Random random=new Random(); 
                
              
                String cardNumber = 5000L+(String.format("%010d", Math.abs(random.nextLong() % 10000000000L))); 
        
                String pinNumber=""+Math.abs(random.nextInt(1000, 9000));
                
                String facuilty="";
                if(c1.isSelected()){
                     facuilty=facuilty+"ATM CARD";
                }else if(c2.isSelected()){
                        
                       facuilty=facuilty+"Internet Banking";
                }else if(c3.isSelected()){
                     facuilty=facuilty+"Mobile Banking";
                }else if(c4.isSelected()){
                     facuilty=facuilty+"EMAIL Alerts";
                }else if(c5.isSelected()){
                     facuilty=facuilty+"Cheque Book";
                }else if(c6.isSelected()){
                      facuilty=facuilty+"E-Statement";
                }
                
                try{
                    if(accounttype.equals("")){
                        JOptionPane.showMessageDialog(null, "Account Type Is Required");
                        
                    }else{
                        
                        Conn c=new Conn();
                        String query1= "INSERT INTO signupThree VALUES('" + formno + "','" + accounttype+ "','" + cardNumber + "','" + pinNumber+ "','" + facuilty+"')";
                        String query2="INSERT INTO login VALUES('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                        
                        c.s.executeUpdate(query1);
                        c.s.executeUpdate(query2);
                        
                       JOptionPane.showMessageDialog(null,"Card Number: "+cardNumber+"\n PIN: "+pinNumber);
                        
                        setVisible(false);
                        new Login().setVisible(true);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
                
                
            }else if(ac.getSource()==cancel){
                  setVisible(false);
            }
     }
    
    
    public static void main(String[] args){
           new SignupThree("");
    }
}
