package com.lck.schedule.ui;

import com.lck.schedule.dao.MatchDAO;
import com.lck.schedule.dto.Match;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MatchEditFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField dateField, timeField, teamAField, teamBField, locationField, scoreAField, scoreBField;
    private MatchDAO matchDAO = new MatchDAO();

    public MatchEditFrame() {
        setTitle("경기 정보 수정");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // 테이블 구성
        tableModel = new DefaultTableModel(new Object[]{"ID", "날짜", "시간", "팀 A", "팀 B", "장소", "점수 A", "점수 B"}, 0);
        table = new JTable(tableModel);
        loadMatches();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // 테이블 클릭 시 입력 필드에 값 채우기
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    dateField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    timeField.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    teamAField.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    teamBField.setText(tableModel.getValueAt(selectedRow, 4).toString());
                    locationField.setText(tableModel.getValueAt(selectedRow, 5).toString());
                    scoreAField.setText(tableModel.getValueAt(selectedRow, 6).toString());
                    scoreBField.setText(tableModel.getValueAt(selectedRow, 7).toString());
                }
            }
        });

        // 입력 필드 패널
        JPanel inputPanel = new JPanel(new GridLayout(2, 7, 5, 5));
        dateField = new JTextField();
        timeField = new JTextField();
        teamAField = new JTextField();
        teamBField = new JTextField();
        locationField = new JTextField();
        scoreAField = new JTextField();
        scoreBField = new JTextField();

        inputPanel.add(new JLabel("날짜 (yyyy-MM-dd)"));
        inputPanel.add(new JLabel("시간 (HH:mm)"));
        inputPanel.add(new JLabel("팀 A"));
        inputPanel.add(new JLabel("팀 B"));
        inputPanel.add(new JLabel("장소"));
        inputPanel.add(new JLabel("점수 A"));
        inputPanel.add(new JLabel("점수 B"));

        inputPanel.add(dateField);
        inputPanel.add(timeField);
        inputPanel.add(teamAField);
        inputPanel.add(teamBField);
        inputPanel.add(locationField);
        inputPanel.add(scoreAField);
        inputPanel.add(scoreBField);

        add(inputPanel, BorderLayout.NORTH);

        // 버튼 추가
        JButton updateButton = new JButton("수정");
        updateButton.addActionListener((ActionEvent e) -> updateMatch());
        add(updateButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadMatches() {
        List<Match> matches = matchDAO.findAll();
        tableModel.setRowCount(0);
        for (Match match : matches) {
            tableModel.addRow(new Object[]{
                    match.getMatchId(),
                    match.getMatchDate(),
                    match.getStartTime(),
                    match.getTeamA(),
                    match.getTeamB(),
                    match.getLocation(),
                    match.getScoreA(),
                    match.getScoreB()
            });
        }
    }

    private void updateMatch() {
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "수정할 경기를 선택하세요.");
                return;
            }

            String matchId = (String) tableModel.getValueAt(selectedRow, 0);
            String dateText = dateField.getText().trim();
            String timeText = timeField.getText().trim();

            if (dateText.isEmpty() || timeText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "날짜와 시간을 입력해주세요.");
                return;
            }

            LocalDate matchDate = LocalDate.parse(dateText);
            LocalTime startTime = LocalTime.parse(timeText);
            String teamA = teamAField.getText().trim();
            String teamB = teamBField.getText().trim();
            String location = locationField.getText().trim();
            int scoreA = Integer.parseInt(scoreAField.getText().trim());
            int scoreB = Integer.parseInt(scoreBField.getText().trim());

            Match match = new Match();
            match.setMatchId(matchId);
            match.setMatchDate(matchDate);
            match.setStartTime(startTime);
            match.setTeamA(teamA);
            match.setTeamB(teamB);
            match.setLocation(location);
            match.setScoreA(scoreA);
            match.setScoreB(scoreB);

            matchDAO.updateMatch(match);
            JOptionPane.showMessageDialog(this, "경기 정보가 수정되었습니다.");
            loadMatches();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "입력값을 확인해주세요. 날짜값은 yyyy-MM-dd, 시간 형식은 HH:mm 이어야 합니다.");
        }
    }
}
