package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    @SuppressWarnings("LeakingThisInConstructor")
   

    Login() {

        setTitle("Automatic Tailor Machine");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        add(label);
        label.setBounds(70, 20, 100, 100);

        //addding text on Screen
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("osward", Font.BOLD, 40));
        text.setBounds(200, 55, 400, 40);
        add(text);

        //addding text on Screen for CardNO.
        JLabel card = new JLabel("CardNO: ");
        card.setFont(new Font("Raleway", Font.BOLD, 28));
        card.setBounds(120, 170, 150, 30);
        add(card);

        cardTextField = new JTextField();
        cardTextField.setBounds(270, 170, 250, 30);
        cardTextField.setBackground(Color.lightGray);
        add(cardTextField);

        //addding text on Screen for PIN
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 230, 150, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(270, 230, 250, 30);
        pinTextField.setBackground(Color.lightGray);
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(270, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLAER");
        clear.setBounds(400, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(270, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);

        setSize(700, 480);

        setVisible(true);
        setLocation(300, 150);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == login) {
            Conn c = new Conn();
            String cardno = cardTextField.getText();
            String pinno = pinTextField.getText();

            String query = "select * from login where cardnumber ='" + cardno + "' and pinnumber='" + pinno + "'";        

            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Cardnumber or Pin Number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ac.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ac.getSource() == signup) {
            setVisible(false);
            new SignOne().setVisible(true);
        }

    }

    public static void main(String[] args) {

        new Login();
    }
}
