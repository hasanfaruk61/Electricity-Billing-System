package electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeterInfo extends JFrame implements ActionListener {

    Choice meterLocChoice, meterTypeChoice, phaseCodeChoice, billTypeChoice;
    String[] meterLocs = {"Outside", "Inside"};
    String[] meterTypes = {"Electric Meter", "Solar Meter", "Smart Meter"};
    String[] phaseCodes = {"011", "022", "033", "044", "055", "066", "077", "088", "099"};
    String[] billTypes = {"Normal", "Industrial"};
    JButton submit, cancel;

    String meternumber;

    MeterInfo(String meternumber) {
        this.meternumber = meternumber;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(heading);

        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(50, 80, 100, 20);
        panel.add(meterNumber);

        JLabel meterNumText = new JLabel(meternumber);
        meterNumText.setBounds(200, 80, 200, 20);
        panel.add(meterNumText);

        JLabel meterLoc = new JLabel("Meter Location");
        meterLoc.setBounds(50, 120, 100, 20);
        panel.add(meterLoc);

        meterLocChoice = new Choice();
        for (String s : meterLocs) {
            meterLocChoice.add(s);
        }
        meterLocChoice.setBounds(200, 120, 150, 20);
        panel.add(meterLocChoice);

        JLabel meterType = new JLabel("Meter Type");
        meterType.setBounds(50, 160, 100, 20);
        panel.add(meterType);

        meterTypeChoice = new Choice();
        for (String s : meterTypes) {
            meterTypeChoice.add(s);
        }
        meterTypeChoice.setBounds(200, 160, 150, 20);
        panel.add(meterTypeChoice);

        JLabel phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(50, 200, 100, 20);
        panel.add(phaseCode);

        phaseCodeChoice = new Choice();
        for (String s : phaseCodes) {
            phaseCodeChoice.add(s);
        }
        phaseCodeChoice.setBounds(200, 200, 150, 20);
        panel.add(phaseCodeChoice);

        JLabel billType = new JLabel("Bill Type");
        billType.setBounds(50, 240, 100, 20);
        panel.add(billType);

        billTypeChoice = new Choice();
        for (String s : billTypes) {
            billTypeChoice.add(s);
        }
        billTypeChoice.setBounds(200, 240, 150, 20);
        panel.add(billTypeChoice);

        JLabel day = new JLabel("30 Days Billing Time...");
        day.setBounds(50, 280, 100, 20);
        panel.add(billType);

        JLabel note = new JLabel("Note:-");
        note.setBounds(50, 320, 100, 20);
        panel.add(note);

        JLabel note1 = new JLabel("*By default bill is calculated for 30 days only");
        note1.setBounds(50, 340, 300, 20);
        panel.add(note1);

        submit = new JButton("Submit");
        submit.setBounds(150, 380, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(270, 380, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel, "Center");

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
        Image image1 = image.getImage().getScaledInstance(230, 200, Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel imageLabel = new JLabel(image2);
        imageLabel.setBounds(400, 50, 150, 300);
        add(imageLabel, "East");

        setSize(700, 500);
        setLocation(400, 200);
        setVisible(true);;


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {
            String smeterNumber = meternumber;
            String smeterLocation = meterLocChoice.getSelectedItem();
            String smeterType = meterTypeChoice.getSelectedItem();
            String sphaseCode = phaseCodeChoice.getSelectedItem();
            String sbillType = billTypeChoice.getSelectedItem();
            String sday = "30";

            String query_meterInfo = "insert into meter_info values('" + smeterNumber + "','" + smeterLocation + "','" + smeterType + "','" + sphaseCode + "','" + sbillType + "','" + sday + "')";

            try {
                Database c = new Database();
                c.statement.executeUpdate(query_meterInfo);

                JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new MeterInfo("");
    }
}
