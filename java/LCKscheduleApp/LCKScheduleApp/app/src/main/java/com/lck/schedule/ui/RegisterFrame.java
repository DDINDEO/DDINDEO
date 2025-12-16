package com.lck.schedule.ui;

import com.lck.schedule.dto.User;
import com.lck.schedule.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {
    private JTextField userIdField, emailField;
    private JPasswordField passwordField;
    private JComboBox<String> teamBox;
    private UserService userService = new UserService();

    public RegisterFrame() {
        setTitle("회원가입");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel userIdLabel = new JLabel("사용자 ID:");
        JLabel emailLabel = new JLabel("이메일:");
        JLabel passwordLabel = new JLabel("비밀번호:");
        JLabel teamLabel = new JLabel("선호 팀:");

        userIdField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        String[] teams = {"", "T1", "GEN", "KT", "HLE", "DK", "DRX", "NS", "BRO"};
        teamBox = new JComboBox<>(teams);

        JButton registerBtn = new JButton("가입");
        registerBtn.addActionListener((ActionEvent e) -> register());

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(userIdLabel);
        panel.add(userIdField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(teamLabel);
        panel.add(teamBox);
        panel.add(new JLabel());
        panel.add(registerBtn);

        add(panel);
        setVisible(true);
    }

    private void register() {
        String userId = userIdField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String favoriteTeam = (String) teamBox.getSelectedItem();

        if (!userId.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                JOptionPane.showMessageDialog(this, "유요한 이메일 주소를 입력해주세요.");
                return;
            }

            userService.register(userId, password, email, favoriteTeam);
            JOptionPane.showMessageDialog(this, "회원가입 성공!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "모든 필드를 입력해주세요.");
        }
    }
}
