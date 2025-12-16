package com.lck.schedule.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminPanelFrame extends JFrame {

    public AdminPanelFrame() {
        setTitle("관리자 패널");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton manageCommentsButton = new JButton("댓글 관리");
        manageCommentsButton.addActionListener((ActionEvent e) -> {
            new CommentListFrame();
        });

        JButton editMatchButton = new JButton("경기 정보 수정");
        editMatchButton.addActionListener((ActionEvent e) -> {
            new MatchEditFrame();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        panel.add(manageCommentsButton);
        panel.add(editMatchButton);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}

