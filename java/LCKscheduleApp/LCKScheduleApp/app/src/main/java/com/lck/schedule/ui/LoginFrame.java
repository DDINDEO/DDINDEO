package com.lck.schedule.ui;

import com.lck.schedule.service.LoginManager;
import com.lck.schedule.dto.User;
import com.lck.schedule.dto.Admin;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField userIdField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("로그인");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("아이디:"));
        userIdField = new JTextField();
        panel.add(userIdField);

        panel.add(new JLabel("비밀번호:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("로그인");
        loginButton.addActionListener(e -> login());
        panel.add(loginButton);

        JButton registerButton = new JButton("회원가입");
        registerButton.addActionListener(e -> openRegisterFrame());
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    private void login() {
        String userId = userIdField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        LoginManager manager = LoginManager.getInstance();
        boolean success = manager.authenticate(userId, password);

        if (success) {
            User user = manager.getCurrentUser();
            JOptionPane.showMessageDialog(this, "로그인 성공!");

            if (user instanceof Admin) {
                new AdminPanelFrame();
            } else {
                new MatchListFrame(user);
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "로그인 실패. 아이디 또는 비밀번호를 확인하세요.");
        }
    }

    private void openRegisterFrame() {
        new RegisterFrame();
    }
}
