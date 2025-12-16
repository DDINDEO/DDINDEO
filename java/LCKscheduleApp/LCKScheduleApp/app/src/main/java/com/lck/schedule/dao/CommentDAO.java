package com.lck.schedule.dao;

import com.lck.schedule.dto.Comment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/matchdb";
    private final String dbUser = "root";
    private final String dbPassword = "9043";

    public void save(Comment comment) {
        String sql = "INSERT INTO comments (user_id, match_id, content, timestamp) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, comment.getUserId());
            stmt.setString(2, comment.getMatchId());
            stmt.setString(3, comment.getContent());
            stmt.setTimestamp(4, Timestamp.valueOf(comment.getTimestamp())); // ✔ 수정된 부분

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("댓글 저장 오류: " + e.getMessage());
        }
    }

    public List<Comment> findByMatchId(String matchId) {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM comments WHERE match_id = ? ORDER BY timestamp DESC";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matchId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Comment comment = new Comment();
                comment.setCommentId(rs.getInt("comment_id"));
                comment.setUserId(rs.getString("user_id"));
                comment.setMatchId(rs.getString("match_id"));
                comment.setContent(rs.getString("content"));
                comment.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime()); // ✔ 수정된 부분
                comments.add(comment);
            }
        } catch (SQLException e) {
            System.err.println("댓글 조회 오류: " + e.getMessage());
        }

        return comments;
    }

    public void delete(int commentId) {
        String sql = "DELETE FROM comments WHERE comment_id = ?";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, commentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("댓글 삭제 오류: " + e.getMessage());
        }
    }

    public void update(int commentId, String newContent) {
        String sql = "UPDATE comments SET content = ?, timestamp = CURRENT_TIMESTAMP WHERE comment_id = ?";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newContent);
            stmt.setInt(2, commentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("댓글 수정 오류: " + e.getMessage());
        }
    }

    public List<Comment> findAll() {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM comments ORDER BY timestamp DESC";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Comment comment = new Comment();
                comment.setCommentId(rs.getInt("comment_id"));
                comment.setUserId(rs.getString("user_id"));
                comment.setMatchId(rs.getString("match_id"));
                comment.setContent(rs.getString("content"));
                comment.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime()); // ✔ 수정된 부분
                comments.add(comment);
            }
        } catch (SQLException e) {
            System.err.println("댓글 전체 조회 오류: " + e.getMessage());
        }

        return comments;
    }
}
