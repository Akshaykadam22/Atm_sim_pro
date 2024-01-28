package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

     JComboBox religntx,catgytx,incometx,edutx,occupationtx ;
    JTextField  pantx, aadhartx;
    JRadioButton yes, no, eyes, eno;
    JButton next;
    String formno;

    SignupTwo(String formno) {
          this.formno=formno;
        setLayout(null);

        JLabel PersonDt2 =new JLabel("Page2: Additional Details");
        PersonDt2.setBounds(250, 50, 400, 40);
        PersonDt2.setFont(new Font("Raleway", Font.BOLD, 21));
        add(PersonDt2);

        JLabel Relign = new JLabel("Religion:");
        Relign.setBounds(100, 120, 100, 30);
        Relign.setFont(new Font("Raleway", Font.BOLD, 20));
        add(Relign);
        
        String valrelign[]={"Hindu","Muslim","Christan","Shikh","other"};
        religntx =new JComboBox(valrelign);
        religntx.setBounds(350, 120, 300, 30);
        religntx.setBackground(Color.white);
        add(religntx);
        
        JLabel catgy = new JLabel("Category: ");
        catgy.setBounds(100, 170, 200, 30);
        catgy.setFont(new Font("Raleway", Font.BOLD, 20));
        add(catgy);
        
        String valcatgy[]={"General","OBC","SC","NT","other"};
         catgytx =new JComboBox(valcatgy);
        catgytx.setBounds(350, 170, 300, 30);
        catgytx.setBackground(Color.white);
        add(catgytx);
        

        JLabel income = new JLabel("Income: ");
        income.setBounds(100, 230, 200, 30);
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        add(income);

        String valincome[]={"NULL","<1,50,000","<2,50,000","<5,50,000","Upto <1,00,000"};
         incometx =new JComboBox(valincome);
        incometx.setBounds(350, 230, 300, 30);
        incometx.setBackground(Color.white);
        add(incometx);
        
        JLabel edu = new JLabel("Educational ");
        edu.setBounds(100, 285, 200, 40);
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        add(edu);
        
        JLabel quli = new JLabel("Qualification: ");
        quli.setBounds(100, 310, 200, 30);
        quli.setFont(new Font("Raleway", Font.BOLD, 20));
        add(quli);
       
        String valedu[]={"Non-Graduate","Graduate","Post-Graduate","under-Graduate","other"};
         edutx =new JComboBox(valedu);
        edutx.setBounds(350, 300, 300, 30);
        edutx.setBackground(Color.white);
        add(edutx);
       
       
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setBounds(100, 350, 200, 30);
       occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        add(occupation);

        String valoccup[]={"Salaried","self-employed","Business","Student","Retired"};
         occupationtx =new JComboBox(valoccup);
        occupationtx.setBounds(350, 350, 300, 30);
        occupationtx.setBackground(Color.white);
        add(occupationtx);
        

        JLabel pan = new JLabel("PAN Number: ");
        pan.setBounds(100, 400, 200, 30);
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pan);

        pantx = new JTextField();
        pantx.setFont(new Font("Raleway", Font.BOLD, 14));
        pantx.setBounds(350, 400, 300, 30);
        add(pantx);

        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setBounds(100, 450, 200, 30);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        add(aadhar);

        aadhartx = new JTextField();
        aadhartx.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhartx.setBounds(350, 450, 300, 30);
        add(aadhartx);
       
        JLabel senior = new JLabel("Senior Citizen: ");
        senior.setBounds(100, 500, 200, 30);
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        add(senior);

        yes = new JRadioButton("Yes");
        yes.setBounds(350, 500, 60, 40);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(430, 500, 90, 40);
        add(no);
       
        ButtonGroup seniorg = new ButtonGroup();
        seniorg.add(yes);
        seniorg.add(no);
        
         JLabel exist = new JLabel("Existing Account: ");
        exist.setBounds(100, 550, 200, 30);
        exist.setFont(new Font("Raleway", Font.BOLD, 20));
        add(exist);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(350, 550, 70, 40);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(430, 550, 90, 40);
        add(eno);

        ButtonGroup martialstatus = new ButtonGroup();
        martialstatus.add(eyes);
        martialstatus.add(eno);


        next = new JButton("Next->");
        next.setBounds(640, 580, 90, 30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        //getContentPane().setBackground(Color.white);
        setSize(800, 750);
        setVisible(true);
        setLocation(300, 10);

    }

    public void actionPerformed(ActionEvent ac) {
      
        String relign = (String)religntx.getSelectedItem();
        String category = (String)catgytx.getSelectedItem();
        String income =(String)incometx.getSelectedItem();
        String education=(String)edutx.getSelectedItem();
        String occupation =(String)occupationtx.getSelectedItem();
        String panNumber=pantx.getText();
        String aadharNumber=aadhartx.getText();
        String seniorCitizen = null;
        if (yes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (no.isSelected()) {
            seniorCitizen = "No";
        }
        String existingAccount= null;
        if (eyes.isSelected()) {
          existingAccount = "Yes";
        } else if (eyes.isSelected()) {
            existingAccount = "No";
        }
    
        try {
                Conn c = new Conn();
                String query = "INSERT INTO signupTwo VALUES('" + formno + "','" + relign+ "','" + category + "','" + income+ "','" + education + "','" + occupation + "','" + panNumber + "','" + aadharNumber + "','" + seniorCitizen + "','" + existingAccount+ "')";

                c.s.executeUpdate(query);
                
                new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        new SignupTwo("");
    }
}
