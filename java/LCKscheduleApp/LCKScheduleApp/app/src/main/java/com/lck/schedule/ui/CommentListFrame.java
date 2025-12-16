
package com.lck.schedule.ui;

import com.lck.schedule.dao.CommentDAO;
import com.lck.schedule.dto.Comment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class CommentListFrame extends JFrame {
    private JTable commentTable;
    private DefaultTableModel tableModel;
    private CommentDAO commentDAO = new CommentDAO();

    public CommentListFrame() {
        setTitle("전체 댓글 목록");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"ID", "User ID", "Match ID", "내용", "작성 시각"}, 0);
        commentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(commentTable);

        JButton deleteButton = new JButton("선택된 댓글 삭제");
        deleteButton.addActionListener(this::deleteSelectedComment);

        add(scrollPane, BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);

        loadComments();

        setVisible(true);
    }

    private void loadComments() {
        tableModel.setRowCount(0); // 기존 행 삭제
        List<Comment> comments = commentDAO.findAll();

        for (Comment c : comments) {
            tableModel.addRow(new Object[]{
                    c.getCommentId(),
                    c.getUserId(),
                    c.getMatchId(),
                    c.getContent(),
                    c.getTimestamp()
            });
        }
    }

    private void deleteSelectedComment(ActionEvent e) {
        int row = commentTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "삭제할 댓글을 선택하세요.");
            return;
        }

        int commentId = (int) tableModel.getValueAt(row, 0);
        int result = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            commentDAO.delete(commentId);
            loadComments();
        }
    }
}
