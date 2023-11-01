package electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateBill extends JFrame implements ActionListener {

    JLabel heading, name, nameText, address, addressText, unitConsumed, month;
    TextField unitText;
    Choice meterNumberChoice, monthChoice;
    JButton submit, cancel;
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                        "October", "November", "December"};

    CalculateBill(){
        super("Calculate Bill");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        add(panel);

        heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(60, 10, 250, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(heading);

        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(50, 80, 100, 20);
        panel.add(meterNumber);

        meterNumberChoice = new Choice();
        try {
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer");

            while (resultSet.next()){
                meterNumberChoice.add(resultSet.getString("meter_no"));
            }
        }catch (Exception E) {
            E.printStackTrace();
        }
        meterNumberChoice.setBounds(200, 80, 150, 20);
        panel.add(meterNumberChoice);

        name = new JLabel("Name");
        name.setBounds(50, 120, 100, 20);
        panel.add(name);

        nameText = new JLabel("");
        nameText.setBounds(200, 120, 150, 20);
        panel.add(nameText);

        address = new JLabel("Address");
        address.setBounds(50, 160, 100, 20);
        panel.add(address);

        addressText = new JLabel("");
        addressText.setBounds(200, 160, 150, 20);
        panel.add(addressText);

        try {
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meter_no = '" + meterNumberChoice.getSelectedItem() + "'");

            while (resultSet.next()) {
                nameText.setText(resultSet.getString("name"));
                addressText.setText(resultSet.getString("address"));
        }

        }catch (Exception E) {
            E.printStackTrace();
        }
        meterNumberChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Database c = new Database();
                    ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meter_no = '" + meterNumberChoice.getSelectedItem() + "'");

                    while (resultSet.next()) {
                        nameText.setText(resultSet.getString("name"));
                        addressText.setText(resultSet.getString("address"));
                    }
                }catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        unitConsumed = new JLabel("Unit Consumed");
        unitConsumed.setBounds(50, 200, 100, 20);
        panel.add(unitConsumed);

        unitText = new TextField();
        unitText.setBounds(200, 200, 150, 20);
        panel.add(unitText);

        month = new JLabel("Month");
        month.setBounds(50, 240, 100, 20);
        panel.add(month);

        monthChoice = new Choice();
        for (String month : months) {
            monthChoice.add(month);
        }
        monthChoice.setBounds(200, 240, 150, 20);
        panel.add(monthChoice);

        submit = new JButton("Submit");
        submit.setBounds(100, 300, 100, 20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 300, 100, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel, "Center");
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/budget.png"));
        Image image = imageIcon.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon1);
        add(imageLabel, "East");


        setSize(650, 400);
        setLocation(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit) {
            String smeterNumber = meterNumberChoice.getSelectedItem();
            String sunitConsumed = unitText.getText();
            String smonth = monthChoice.getSelectedItem();

            int totalBill = 0;
            int units = Integer.parseInt(sunitConsumed);

            String query_tax = "Select * from tax";

            try {

                Database c = new Database();
                ResultSet resultSet = c.statement.executeQuery(query_tax);

                while(resultSet.next()) {
                    totalBill += units * Integer.parseInt(resultSet.getString("cost_per_unit"));
                    totalBill += Integer.parseInt(resultSet.getString("meter_rent"));
                    totalBill += Integer.parseInt(resultSet.getString("service_charge"));
                    totalBill += Integer.parseInt(resultSet.getString("swacch_bharat"));
                    totalBill += Integer.parseInt(resultSet.getString("fixed_tax"));

                }
            }catch (Exception E) {
                E.printStackTrace();
            }
            String query_total_bill = "insert into bill values('"+smeterNumber+"','"+smonth+"','"+sunitConsumed+"','"+totalBill+"', 'Not Paid')";
            try {
                Database c = new Database();
                c.statement.executeUpdate(query_total_bill);

                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
            } catch (Exception E) {
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new CalculateBill();
    }
}
