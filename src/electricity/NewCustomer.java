package electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener {

    JLabel heading, customerName, meterNumText, meterNumber, address, city, state, email, phone;
    JButton next, cancel;
    JTextField nameText, addressText, cityText, stateText, emailText, phoneText;


    NewCustomer(){
        super("New Customer");
        setSize(700, 500);
        setLocation(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        add(panel);

        heading = new JLabel("New Customer");
        heading.setBounds(200, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(heading);

            //Customer Details
        customerName = new JLabel("Customer Name");
        customerName.setBounds(50, 80, 100, 20);
        panel.add(customerName);

        nameText = new JTextField();
        nameText.setBounds(200, 80, 200, 20);

        panel.add(nameText);

        meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(50, 120, 100, 20);
        panel.add(meterNumber);

        meterNumText = new JLabel("");
        meterNumText.setBounds(200, 120, 200, 20);
        panel.add(meterNumText);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        meterNumText.setText("" + Math.abs(number));

        address = new JLabel("Address");
        address.setBounds(50, 160, 100, 20);
        panel.add(address);

        addressText = new JTextField();
        addressText.setBounds(200, 160, 200, 20);
        panel.add(addressText);

        city = new JLabel("City");
        city.setBounds(50, 200, 100, 20);
        panel.add(city);

        cityText = new JTextField();
        cityText.setBounds(200, 200, 200, 20);
        panel.add(cityText);

        state = new JLabel("State");
        state.setBounds(50, 240, 100, 20);
        panel.add(state);

        stateText = new JTextField();
        stateText.setBounds(200, 240, 200, 20);
        panel.add(stateText);

        email = new JLabel("Email");
        email.setBounds(50, 280, 100, 20);
        panel.add(email);

        emailText = new JTextField();
        emailText.setBounds(200, 280, 200, 20);
        panel.add(emailText);

        phone = new JLabel("Phone");
        phone.setBounds(50, 320, 100, 20);
        panel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(200, 320, 200, 20);
        panel.add(phoneText);

        next = new JButton("Next");
        next.setBounds(120, 390, 100, 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        panel.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(245, 390, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel, "Center");

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image image2 = image1.getImage().getScaledInstance(230, 200, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel imageLabel = new JLabel(image3);
        add(imageLabel, "West");
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            String sname = nameText.getText();
            String smeterNumber = meterNumText.getText();
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String semail = emailText.getText();
            String sphone = phoneText.getText();

            String query_customer = "insert into new_customer values('"+sname+"','"+smeterNumber+"','"+saddress+"','"+scity+"','"+sstate+"','"+semail+"','"+sphone+"')";
            String query_signup = "insert into Signup values('"+smeterNumber+"','','"+sname+"','','')";

            try {
                Database c = new Database();
                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
                new MeterInfo(smeterNumber);
            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }



    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
