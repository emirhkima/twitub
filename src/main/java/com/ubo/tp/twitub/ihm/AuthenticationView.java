package com.ubo.tp.twitub.ihm;

import com.ubo.tp.twitub.datamodel.User;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AuthenticationView extends JFrame implements ActionListener {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private User model;

    public AuthenticationView() {
        super("Login");

        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);
        txtPassword.setEchoChar('*');
        btnLogin = new JButton("Login");

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Username:"));
        content.add(txtUsername);
        content.add(new JLabel("Password:"));
        content.add(txtPassword);
        content.add(btnLogin);

        btnLogin.addActionListener(this);

        this.setContentPane(content);
        this.pack();

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
    }

    public User getUser() {
        User newUser = new User(UUID.randomUUID(), txtUsername.getText(), txtPassword.getText(), txtUsername.getText(), new HashSet<String>(), "");

        return newUser;
    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void addLoginListener(ActionListener log) {
        btnLogin.addActionListener(log);
    }
}