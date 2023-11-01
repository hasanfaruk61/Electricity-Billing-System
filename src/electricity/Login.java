package electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField userText, passwordText;
    Choice loginChoice;
    JButton loginButton, signupButton, cancelButton;

    String[] loginAs = {"Admin", "Customer"};

    Login(){
        super("Login");
        getContentPane().setBackground(Color.CYAN);

        JLabel username = new JLabel("Username");
        username.setBounds(300, 60, 100, 20);
        add(username);

        userText = new JTextField();
        userText.setBounds(400, 60, 150, 20);
        add(userText);

        JLabel password = new JLabel("Password");
        password.setBounds(300, 100, 100, 20);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(400, 100, 150, 20);
        add(passwordText);

        JLabel login = new JLabel("Login in As");
        login.setBounds(300, 140, 100, 20);
        add(login);

        loginChoice = new Choice();
        for (String s : loginAs) {
            loginChoice.add(s);
        }

        loginChoice.setBounds(400, 140, 150, 20);
        add(loginChoice);

        loginButton = new JButton("Login");
        loginButton.setBounds(330, 180, 100, 20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(460, 180, 100, 20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton = new JButton("Signup");
        signupButton.setBounds(400, 220, 100, 20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileTwo = profileOne.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon profileThree = new ImageIcon(profileTwo);
        JLabel profileLabel = new JLabel(profileThree);
        profileLabel.setBounds(5,5, 250, 250);
        add(profileLabel);

        setSize(640, 300);
        setLocation(500, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String susername = userText.getText();
            String spassword = passwordText.getText();
            String suser = loginChoice.getSelectedItem();


            try{
             Database c = new Database();
             String query = "select * from Signup where username = '"+susername+"' and password = '"+spassword+"'and usertype ='"+suser+"'";

             ResultSet resultSet = c.statement.executeQuery(query);

             if (resultSet.next()) {
                 setVisible(false);
                 new Main_class();
             }else {
                 JOptionPane.showMessageDialog(null, "Invalid Login");
             }
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancelButton) {
            System.exit(0);
        } else if (e.getSource() == signupButton) {
            this.setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}