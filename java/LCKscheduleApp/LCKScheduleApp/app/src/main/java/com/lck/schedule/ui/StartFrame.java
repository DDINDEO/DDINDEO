package com.lck.schedule.ui;

import com.lck.schedule.dto.User;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartFrame extends JFrame {

    public StartFrame() {
        setTitle("LCK 일정 앱 시작");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton loginBtn = new JButton("로그인");
        JButton guestBtn = new JButton("비회원으로 시작");

        loginBtn.addActionListener((ActionEvent e) -> {
            dispose();
            new LoginFrame();
        });

        guestBtn.addActionListener((ActionEvent e) -> {
            dispose();
            new MatchListFrame(null); // userId 없이 시작
        });

        JPanel panel = new JPanel();
        panel.add(loginBtn);
        panel.add(guestBtn);
        add(panel);

        setVisible(true);
    }
}
