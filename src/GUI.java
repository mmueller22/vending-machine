import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame {

    private JPanel panel;
    private Database database;

    public GUI() {
        this.database = new Database();
    }

    public GUI(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        panel = new JPanel();
        add(panel);
    }

    private void access() {
        GUI newGUI = new GUI("register", 500, 250);
        JLabel lblInfo = new JLabel("Please Login or register");
        JButton btnLogin = new JButton("Login");
        JButton btnRegister = new JButton("Register");
        JLabel lblUsername = new JLabel("username:");
        JTextField txtUsername = new JTextField();
        JLabel lblPassword = new JLabel("password:");
        JTextField txtPassword = new JTextField();
        JLabel lblPasswordConfirm = new JLabel("confirm password:");
        JTextField txtPasswordConfirm = new JTextField();
        JButton btnConfirm = new JButton("Confirm");

        lblInfo.setBounds(10, 10, 450, 20);
        btnLogin.setBounds(10, 40, 100, 20);
        btnRegister.setBounds(120, 40, 100, 20);
        lblUsername.setBounds(10, 10, 100, 20);
        txtUsername.setBounds(130, 10, 100, 20);
        lblPassword.setBounds(10, 40, 100, 20);
        txtPassword.setBounds(130, 40, 100, 20);
        lblPasswordConfirm.setBounds(10, 70, 120, 20);
        txtPasswordConfirm.setBounds(130, 70, 100, 20);
        btnConfirm.setBounds(130, 100, 100, 20);

        newGUI.add(lblInfo);
        newGUI.add(btnLogin);
        newGUI.add(btnRegister);
        newGUI.add(lblUsername);
        newGUI.add(txtUsername);
        newGUI.add(lblPassword);
        newGUI.add(txtPassword);
        newGUI.add(lblPasswordConfirm);
        newGUI.add(txtPasswordConfirm);
        newGUI.add(btnConfirm);

        JLabel error = new JLabel("passwords dont match");
        error.setForeground(Color.red);
        error.setBounds(250, 40, 150, 20);
        error.setVisible(false);
        newGUI.add(error);
        JLabel error2 = new JLabel("passwords dont match");
        error2.setForeground(Color.red);
        error2.setBounds(250, 70, 150, 20);
        error2.setVisible(false);
        newGUI.add(error2);

        lblUsername.setVisible(false);
        txtUsername.setVisible(false);
        lblPassword.setVisible(false);
        txtPassword.setVisible(false);
        lblPasswordConfirm.setVisible(false);
        txtPasswordConfirm.setVisible(false);
        btnConfirm.setVisible(false);

        newGUI.setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblInfo.setVisible(false);
                btnLogin.setVisible(false);
                btnRegister.setVisible(false);
                lblUsername.setVisible(true);
                txtUsername.setVisible(true);
                lblPassword.setVisible(true);
                txtPassword.setVisible(true);
                btnConfirm.setVisible(true);
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblInfo.setVisible(false);
                btnLogin.setVisible(false);
                btnRegister.setVisible(false);
                lblUsername.setVisible(true);
                txtUsername.setVisible(true);
                lblPassword.setVisible(true);
                txtPassword.setVisible(true);
                lblPasswordConfirm.setVisible(true);
                txtPasswordConfirm.setVisible(true);
                btnConfirm.setVisible(true);
            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtPasswordConfirm.isVisible()) {
                    if (txtPassword.getText().equals(txtPasswordConfirm.getText())) {
                        Account newAccount = new Account();
                        newAccount.setUsername(txtUsername.getText());
                        newAccount.setPassword(txtPassword.getText());
                        //newAccount.setAmount(Integer.parseInt(txtPassword.getText()));
                        database.addEntry(newAccount);
                    } else {
                        error.setVisible(true);
                        error2.setVisible(true);
                    }
                } else {
                    database.getUserList();
                    if (database.checkUserLogin(txtUsername.getText(), txtPassword.getText())) {
                        //continue
                    } else {
                        JOptionPane.showMessageDialog(panel, "username or password wrong");
                        //add option to get back to registering
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        new GUI().access();
    }
}