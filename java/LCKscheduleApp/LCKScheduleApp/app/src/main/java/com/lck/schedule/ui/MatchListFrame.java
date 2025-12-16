package com.lck.schedule.ui;

import com.lck.schedule.dao.MatchDAO;
import com.lck.schedule.dto.Match;
import com.lck.schedule.dto.User;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MatchListFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private MatchDAO matchDAO = new MatchDAO();
    private int currentPage = 1;
    private final int pageSize = 10;
    private JButton prevButton, nextButton, detailButton;
    private User user;
    private List<Match> allMatches;

    public MatchListFrame(User user) {
        this.user = user;

        setTitle("경기 목록");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 테이블 설정
        tableModel = new DefaultTableModel(new Object[]{"경기 ID", "날짜", "팀 A", "팀 B"}, 0);
        table = new JTable(tableModel);
        table.setRowHeight(30); // 행 높이 증가
        table.setFont(new Font("SansSerif", Font.PLAIN, 16));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        add(new JScrollPane(table), BorderLayout.CENTER);

        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        prevButton = new JButton("이전");
        nextButton = new JButton("다음");
        detailButton = new JButton("상세보기");
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(detailButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // 버튼 이벤트
        prevButton.addActionListener(e -> {
            if (currentPage > 1) {
                currentPage--;
                loadMatches();
            }
        });

        nextButton.addActionListener(e -> {
            currentPage++;
            loadMatches();
        });

        detailButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int matchIndex = (currentPage - 1) * pageSize + selectedRow;
                if (matchIndex < allMatches.size()) {
                    Match selectedMatch = allMatches.get(matchIndex);
                    new MatchDetailFrame(selectedMatch);
                }
            } else {
                JOptionPane.showMessageDialog(this, "상세보기를 할 경기를 선택해주세요.");
            }
        });

        loadAllMatches();
        loadMatches();
        setVisible(true);
    }

    private void loadAllMatches() {
        allMatches = matchDAO.findAll();
    }

    private void loadMatches() {
        tableModel.setRowCount(0);

        int start = (currentPage - 1) * pageSize;
        int end = Math.min(start + pageSize, allMatches.size());

        for (int i = start; i < end; i++) {
            Match match = allMatches.get(i);
            tableModel.addRow(new Object[]{
                match.getMatchId(),
                match.getMatchDate(),
                match.getTeamA(),
                match.getTeamB()
            });
        }
    }
}
