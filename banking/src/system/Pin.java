//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Pin extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;
    JPasswordField p1;
    JPasswordField p2;
    String pin;

    Pin(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        this.add(l3);
        JLabel label1 = new JLabel("비밀번호를 변경하시겠습니까?");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", 1, 16));
        label1.setBounds(430, 180, 400, 35);
        l3.add(label1);
        JLabel label2 = new JLabel("새로운 비밀번호: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", 1, 16));
        label2.setBounds(430, 220, 150, 35);
        l3.add(label2);
        this.p1 = new JPasswordField();
        this.p1.setBackground(new Color(65, 125, 128));
        this.p1.setForeground(Color.WHITE);
        this.p1.setBounds(600, 220, 180, 25);
        this.p1.setFont(new Font("Raleway", 1, 22));
        l3.add(this.p1);
        JLabel label3 = new JLabel("비밀번호 확인: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", 1, 16));
        label3.setBounds(430, 250, 400, 35);
        l3.add(label3);
        this.p2 = new JPasswordField();
        this.p2.setBackground(new Color(65, 125, 128));
        this.p2.setForeground(Color.WHITE);
        this.p2.setBounds(600, 255, 180, 25);
        this.p2.setFont(new Font("Raleway", 1, 22));
        l3.add(this.p2);
        this.b1 = new JButton("변경하기");
        this.b1.setBounds(700, 362, 150, 35);
        this.b1.setBackground(new Color(65, 125, 128));
        this.b1.setForeground(Color.BLACK);
        this.b1.addActionListener(this);
        l3.add(this.b1);
        this.b2 = new JButton("이전으로");
        this.b2.setBounds(700, 406, 150, 35);
        this.b2.setBackground(new Color(65, 125, 128));
        this.b2.setForeground(Color.black);
        this.b2.addActionListener(this);
        l3.add(this.b2);
        this.setSize(1550, 1080);
        this.setLayout((LayoutManager)null);
        this.setLocation(0, 0);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = this.p1.getText();
            String pin2 = this.p2.getText();
            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog((Component)null, "Entered PIN does not match");
                return;
            }

            if (e.getSource() == this.b1) {
                if (this.p1.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Enter New PIN");
                    return;
                }

                if (this.p2.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Re-Enter New PIN");
                    return;
                }

                Connn c = new Connn();
                String q1 = "update bank set pin = '" + pin1 + "' where pin = '" + this.pin + "'";
                String q2 = "update login set pin = '" + pin1 + "' where pin = '" + this.pin + "'";
                String q3 = "update signupthree set pin = '" + pin1 + "' where pin = '" + this.pin + "'";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);
                JOptionPane.showMessageDialog(this, "PIN changed successfully");
                this.setVisible(false);
                new main_Class(this.pin);
            } else if (e.getSource() == this.b2) {
                new main_Class(this.pin);
                this.setVisible(false);
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Pin("");
    }
}
