package electricity;

import javax.swing.*;
import java.awt.*;

public class Main_class extends JFrame {

    Main_class(){
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1530, 830);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
        Image image = imageIcon.getImage().getScaledInstance(1530, 830, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        add(imageLabel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

            //Menu
        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif", Font.PLAIN, 14));
        menu.setForeground(Color.BLUE);
        menuBar.add(menu);

        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setForeground(Color.BLUE);
        newCustomer.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon customerImg = new ImageIcon(ClassLoader.getSystemResource("icon/newCustomer.png"));
        Image customerImg2 = customerImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newCustomer.setIcon(new ImageIcon(customerImg2));
        menu.add(newCustomer);

        JMenuItem customerDetails = new JMenuItem("Customer Details");
        customerDetails.setForeground(Color.BLUE);
        customerDetails.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon customerDetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image customerDetailsImg2 = customerDetailsImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerDetailsImg2));
        menu.add(customerDetails);

        JMenuItem depositDetails = new JMenuItem("Deposit Details");
        depositDetails.setForeground(Color.BLUE);
        depositDetails.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon depositDetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/depositDetails.png"));
        Image depositDetailsImg2 = depositDetailsImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(depositDetailsImg2));
        menu.add(depositDetails);

        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setForeground(Color.BLUE);
        calculateBill.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon calculateBillImg = new ImageIcon(ClassLoader.getSystemResource("icon/calculatorBills.png"));
        Image calculateBill2 = calculateBillImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateBill2));
        menu.add(calculateBill);

            //Info
        JMenu info = new JMenu("Information");
        info.setFont(new Font("serif", Font.PLAIN, 14));
        info.setForeground(Color.BLUE);
        menuBar.add(info);

        JMenuItem upInfo = new JMenuItem("Update Information");
        upInfo.setForeground(Color.BLUE);
        upInfo.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon upInfoImg = new ImageIcon(ClassLoader.getSystemResource("icon/refresh.png"));
        Image upInfoImg2 = upInfoImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        upInfo.setIcon(new ImageIcon(upInfoImg2));
        info.add(upInfo);

        JMenuItem viewInfo = new JMenuItem("View Information");
        viewInfo.setForeground(Color.BLUE);
        viewInfo.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon viewInfoImg = new ImageIcon(ClassLoader.getSystemResource("icon/information.png"));
        Image viewInfoImg2 = viewInfoImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(viewInfoImg2));
        info.add(viewInfo);

             //User
        JMenu user = new JMenu("User");
        user.setFont(new Font("serif", Font.PLAIN, 14));
        user.setForeground(Color.BLUE);
        menuBar.add(user);

        JMenuItem payBill = new JMenuItem("Pay Bill");
        payBill.setForeground(Color.BLUE);
        payBill.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon payBillImg = new ImageIcon(ClassLoader.getSystemResource("icon/pay.png"));
        Image payBillImg2 = payBillImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        payBill.setIcon(new ImageIcon(payBillImg2));
        user.add(payBill);

        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.setForeground(Color.BLUE);
        billDetails.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon billDetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/detail.png"));
        Image billDetailsImg2 = billDetailsImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(billDetailsImg2));
        user.add(billDetails);

            //Bill
        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("serif", Font.PLAIN, 14));
        bill.setForeground(Color.BLUE);
        menuBar.add(bill);

        JMenuItem genBill = new JMenuItem("Generate Bill");
        genBill.setForeground(Color.BLUE);
        genBill.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon genBillImg = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image genBillImg2 = genBillImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(genBillImg2));
        bill.add(billDetails);

            //Utility
        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("serif", Font.PLAIN, 14));
        utility.setForeground(Color.BLUE);
        menuBar.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setForeground(Color.BLUE);
        notepad.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon notepadImg = new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image notepadImg2 = notepadImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImg2));
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setForeground(Color.BLUE);
        calculator.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon calculatorImg = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image calculatorImg2 = calculatorImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorImg2));
        utility.add(calculator);

             //Exit
        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("serif", Font.PLAIN, 14));
        exit.setForeground(Color.BLUE);
        menuBar.add(exit);

        JMenuItem eexit = new JMenuItem("Exit");
        eexit.setForeground(Color.BLUE);
        eexit.setFont(new Font("monospaced", Font.PLAIN, 13));
        ImageIcon eexitImg = new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
        Image eexitImg2 = eexitImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(eexitImg2));
        exit.add(eexit);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
