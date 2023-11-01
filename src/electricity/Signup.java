package electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {

    JLabel createAccountAs, meterNo, employer, userName, name, password;
    TextField meterText, employerText, userNameText, nameText, passwordText;
    Choice signUpChoice;
    JButton createButton, backButton;
    String[] signUpAs = {"Admin", "Customer"};

    Signup(){
        super("Signup Page");
        getContentPane().setBackground(Color.CYAN);

        JLabel createAs = new JLabel("Create Account");
        createAs.setBounds(10,10,125,20);
        add(createAs);

        createAccountAs = new JLabel("Create Account As");
        createAccountAs.setBounds(25, 50, 150, 20);
        add(createAccountAs);

        signUpChoice = new Choice();
        for (String s : signUpAs) {
            signUpChoice.add(s);
        }
        signUpChoice.setBounds(200, 50, 150, 20);
        add(signUpChoice);

        meterNo = new JLabel("Meter Number");
        meterNo.setBounds(25, 100, 150, 20);
        meterNo.setVisible(true);
        add(meterNo);

        meterText = new TextField();
        meterText.setBounds(200, 100, 150, 20);
        meterText.setVisible(true);
        add(meterText);

        employer = new JLabel("Employer ID");
        employer.setBounds(25, 100, 150, 20);
        employer.setVisible(false);
        add(employer);

        employerText = new TextField();
        employerText.setBounds(200, 100, 150, 20);
        employerText.setVisible(false);
        add(employerText);

        userName = new JLabel("User Name");
        userName.setBounds(25, 150, 150, 20);
        add(userName);

        userNameText = new TextField();
        userNameText.setBounds(200, 150, 150, 20);
        add(userNameText);

        name = new JLabel("Name");
        name.setBounds(25, 200, 150, 20);
        add(name);

        nameText = new TextField();
        nameText.setBounds(200, 200, 150, 20);
        add(nameText);

        password = new JLabel("Password");
        password.setBounds(25, 250, 150, 20);
        add(password);

        passwordText = new TextField();
        passwordText.setBounds(200, 250, 150, 22);
        add(passwordText);

        createButton = new JButton("Create");
        createButton.setBackground(new Color(66, 127, 219));
        createButton.setForeground(Color.BLACK);
        createButton.setBounds(70, 350, 100, 20);
        createButton.addActionListener(this);
        add(createButton);

        backButton = new JButton("Back");
        backButton.setBackground(new Color(66, 127, 219));
        backButton.setForeground(Color.BLACK);
        backButton.setBounds(200, 350, 100, 20);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon boyIcon = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image boyImage = boyIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon boyIcon2 = new ImageIcon(boyImage);
        JLabel boyLabel = new JLabel(boyIcon2);
        boyLabel.setBounds(350, 20, 250, 250);
        add(boyLabel);

        setSize(600, 480);
        setLocation(500, 200);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            String ssignupAs = signUpChoice.getSelectedItem();
            String susername = userNameText.getText();
            String sname = nameText.getText();
            String spassword = passwordText.getText();
            String smeterNo = meterText.getText();

            try {
                Database c = new Database();
                String query;
                query = "insert into Signup value('" + ssignupAs + "','" + susername + "','" + sname + "','" + spassword + "','" + smeterNo + "')";

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "User Account Created Successfully");
                setVisible(false);
                new Login();
            }catch (Exception exception) {
                exception.printStackTrace();
            }

        }else if (e.getSource() == backButton) {
            setVisible(false);
            new Login();
        }

    }
    public static void main(String[] args) {
        new Signup();
    }
}
