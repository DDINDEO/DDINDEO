
package com.lck.schedule.ui;

import com.lck.schedule.dao.CommentDAO;
import com.lck.schedule.dto.Comment;
import com.lck.schedule.dto.Match;
import com.lck.schedule.dto.User;
import com.lck.schedule.service.LoginManager;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

public class MatchDetailFrame extends JFrame {
    private CommentDAO commentDAO = new CommentDAO();
    private JTextArea commentArea;
    private JPanel commentPanel;
    private Match match;

    public MatchDetailFrame(String matchId) {   
    setTitle("경기 상세 - " + matchId);
        setSize(400, 300);
     setLocationRelativeTo(null);

    JLabel label = new JLabel("선택한 경기 ID: " + matchId);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    add(label);

    setVisible(true);
}
    public MatchDetailFrame(Match match) {
        this.match = match;

        setTitle("경기 상세 정보");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel matchInfoPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        matchInfoPanel.setBorder(BorderFactory.createTitledBorder("경기 정보"));
        Font infoFont = new Font("SansSerif", Font.BOLD, 16);

        matchInfoPanel.add(createLabeledValue("Match ID:", match.getMatchId(), infoFont));
        matchInfoPanel.add(createLabeledValue("Date:", match.getMatchDate().toString(), infoFont));
        matchInfoPanel.add(createLabeledValue("Start Time:", match.getStartTime().toString(), infoFont));
        matchInfoPanel.add(createLabeledValue("Team A vs Team B:", match.getTeamA() + " vs " + match.getTeamB(), infoFont));
        matchInfoPanel.add(createLabeledValue("Location:", match.getLocation(), infoFont));

        String scoreText = match.getTeamA() + " " + match.getScoreA() + " : " + match.getScoreB() + " " + match.getTeamB();
        matchInfoPanel.add(createLabeledValue("Score:", scoreText, infoFont));

        add(matchInfoPanel, BorderLayout.NORTH);

        commentPanel = new JPanel();
        commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(commentPanel);
        scrollPane.setPreferredSize(new Dimension(680, 250));
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        commentArea = new JTextArea(2, 20);
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        inputPanel.add(new JScrollPane(commentArea), BorderLayout.CENTER);
        JButton submitButton = new JButton("댓글 작성");
        submitButton.addActionListener(e -> submitComment());
        inputPanel.add(submitButton, BorderLayout.EAST);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(inputPanel, BorderLayout.SOUTH);

        loadComments();
        setVisible(true);
    }

    private JPanel createLabeledValue(String label, String value, Font font) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel labelComponent = new JLabel(label);
        JLabel valueComponent = new JLabel(value);
        labelComponent.setFont(font);
        valueComponent.setFont(font);
        panel.add(labelComponent, BorderLayout.WEST);
        panel.add(valueComponent, BorderLayout.CENTER);
        return panel;
    }

    private void loadComments() {
        commentPanel.removeAll();
        List<Comment> comments = commentDAO.findByMatchId(match.getMatchId());

        for (Comment comment : comments) {
            JTextArea commentText = new JTextArea(comment.getUserId() + ": " + comment.getContent());
            commentText.setLineWrap(true);
            commentText.setWrapStyleWord(true);
            commentText.setEditable(false);
            commentText.setFont(new Font("Serif", Font.PLAIN, 14));
            commentText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            commentPanel.add(commentText);
        }

        commentPanel.revalidate();
        commentPanel.repaint();
    }

    private void submitComment() {
        String content = commentArea.getText().trim();
        if (content.isEmpty()) {
            JOptionPane.showMessageDialog(this, "댓글을 입력해주세요.");
            return;
        }

        User user = LoginManager.getLoggedInUser();
        if (user == null) {
            JOptionPane.showMessageDialog(this, "로그인이 필요합니다.");
            return;
        }

        Comment comment = new Comment();
        comment.setMatchId(match.getMatchId());
        comment.setUserId(user.getUserId());
        comment.setContent(content);
        comment.setTimestamp(java.sql.Timestamp.valueOf(LocalDateTime.now()));

        commentDAO.save(comment);
        commentArea.setText("");
        loadComments();
    }
}
