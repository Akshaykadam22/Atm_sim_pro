
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignOne extends JFrame implements ActionListener{
          long random;
          JTextField nametx,fnametx,emailtx,addresstx,citytx,statetx,pintx;
          JDateChooser dateChooser;
          JRadioButton male,female,married,unmarried,other;
          JButton next;
          SignOne(){
           
              setLayout(null);
              
           Random ran=new Random();
           random=ran.nextInt(1000,100000);
           
           JLabel fromno=new JLabel("APPLICATION FORM NO. "+random);
           fromno.setBounds(140,9,600,40);
           fromno.setFont(new Font("Raleway", Font.BOLD,30 ));
           add(fromno);
           
           JLabel PersonDt =new JLabel("Page1: Personal Details");
           PersonDt.setBounds(250,50,400,40);
           PersonDt.setFont(new Font("Raleway", Font.BOLD,21 ));
           add(PersonDt);
           
           JLabel name=new JLabel("Name:");
           name.setBounds(100,120,100,30);
           name.setFont(new Font("Raleway", Font.BOLD,20 ));
           add(name);
           
           nametx=new JTextField();
           nametx.setFont(new Font("Raleway",Font.BOLD,14));
           nametx.setBounds(300,120,300,30);
           add(nametx);
           
           JLabel FatherName =new JLabel("Father's Name: ");
           FatherName.setBounds(100,160,200,30);
           FatherName.setFont(new Font("Raleway", Font.BOLD,20 ));
           add(FatherName);
          
           fnametx=new JTextField();
           fnametx.setFont(new Font("Raleway",Font.BOLD,14));
           fnametx.setBounds(300,160,300,30);
           add(fnametx);
          
           JLabel Dob=new JLabel("Date of Birth: ");
           Dob.setBounds(100,210,200,30);
           Dob.setFont(new Font("Raleway", Font.BOLD,20 ));
           add(Dob);
           
           dateChooser=new JDateChooser();
           dateChooser.setBounds(300,210,300,30);
           dateChooser.setForeground(new Color(105,105,105));
           add(dateChooser);
           
           JLabel gender =new JLabel("Gender:");
           gender.setBounds(100,260,200,30);
           gender.setFont(new Font("Raleway", Font.BOLD,20 ));
           add(gender);
           
           male=new JRadioButton("Male");
           male.setBounds(300, 260, 60, 40);
           add(male);   
          
           female=new JRadioButton("Female");
           female.setBounds(370, 260, 90, 40);
           add(female);
          
           ButtonGroup gendergroup=new ButtonGroup();
          gendergroup.add(male);
          gendergroup.add(female);
           
           JLabel email=new JLabel("Email Address: ");
           email.setBounds(100,310,200,30);
           email.setFont(new Font("Raleway", Font.BOLD,20 ));
           add(email);
           
          emailtx=new JTextField();
          emailtx.setFont(new Font("Raleway",Font.BOLD,14));
          emailtx.setBounds(300,310,300,30);
          add(emailtx);
           
            JLabel marital=new JLabel("Marital Status: ");
           marital.setBounds(100,360,200,30);
           marital.setFont(new Font("Raleway", Font.BOLD,20 ));
           add(marital);
           
           married=new JRadioButton("Married");
           married.setBounds(300, 360, 90, 40);
           add(married);
          
           unmarried=new JRadioButton("Unmarried");
           unmarried.setBounds(400, 360, 90, 40);
           add(unmarried);
            
           other=new JRadioButton("Other");
           other.setBounds(500, 360, 90, 40);
           add(other);
          
          ButtonGroup martialstatus=new ButtonGroup();
          martialstatus.add(married);
          martialstatus.add(unmarried);
          martialstatus.add(other);
          
           JLabel address=new JLabel("Address: ");
           address.setBounds(100,410,200,30);
           address.setFont(new Font("Raleway", Font.BOLD,20 ));
           add(address);
           
          addresstx=new JTextField();
          addresstx.setFont(new Font("Raleway",Font.BOLD,14));
          addresstx.setBounds(300,410,300,30);
          add(addresstx);
           
          JLabel city=new JLabel("City: ");
          city.setBounds(100,460,100,30);
          city.setFont(new Font("Raleway", Font.BOLD,20 ));
          add(city);
             
          citytx=new JTextField();
          citytx.setFont(new Font("Raleway",Font.BOLD,14));
          citytx.setBounds(300,460,300,30);
          add(citytx);
          
           JLabel state=new JLabel("State: ");
           state.setBounds(100,510,100,30);
           state.setFont(new Font("Raleway", Font.BOLD,20 ));
           add(state);
          
          statetx=new JTextField();
          statetx.setFont(new Font("Raleway",Font.BOLD,14));
          statetx.setBounds(300,510,300,30);
          add(statetx);
           
           JLabel pin=new JLabel("Pin Code: ");
           pin.setFont(new Font("Raleway",Font.BOLD,20));
           pin.setBounds(100,560,200,30);
           add(pin);
           
          pintx=new JTextField();
          pintx.setFont(new Font("Raleway",Font.BOLD,14));
          pintx.setBounds(300,560,300,30);
          add(pintx);
           
          next=new JButton("Next->");
          next.setBounds(650, 600, 90, 30);
          next.setBackground(Color.black);
          next.setForeground(Color.white);
          next.addActionListener(this);
          add(next);
          
          
          
           //getContentPane().setBackground(Color.white);
           setUndecorated(true);
           setSize(800,750);
           setVisible(true);
           setLocation(300,10);
           
     }
          public void actionPerformed(ActionEvent ac){
                String formno= ""+ random;
                String name=nametx.getText();
                String fname=fnametx.getText();  
                String dob=((JTextField)(dateChooser.getDateEditor().getUiComponent())).getText();
                String gender=null;
                if(male.isSelected()){
                      gender="Male";
                }else if(female.isSelected()){
                       gender="Female";
                }
                
                String email=emailtx.getText();
                String marital=null;
                if(married.isSelected()){
                      marital="Married";
                }else if(unmarried.isSelected()){
                       marital="Unmarried";
                }else if(other.isSelected()){
                        marital="Other";        
                }
                String address=addresstx.getText();
                String city=citytx.getText();
                String state=statetx.getText();
                String pin=""+pintx.getText();
                
                
               try{
                   if(name.equals("")){
                       JOptionPane.showMessageDialog(null, "Name Is Required");
                   }else{
                        Conn c=new Conn();
                       String query = "INSERT INTO signup VALUES('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state + "','" + pin + "')";

                        c.s.executeUpdate(query); 
                        setVisible(false);
                        new SignupTwo(formno).setVisible(true);
                   }
               }catch (Exception e){
                   System.out.println(e);
               }  
          }
             
     
         public static void main(String[]args){
             
             new SignOne();
         }
}

