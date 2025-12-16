
package com.lck.schedule.dao;

import com.lck.schedule.dto.User;
import com.lck.schedule.dto.Admin;

import java.sql.*;

public class UserDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/matchdb";
    private final String dbUser = "root";
    private final String dbPassword = "9043"; // 비밀번호는 환경에 맞게 수정하세요

    public void save(User user) {
        String sql = "INSERT INTO users (user_id, email, password, favorite_team) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUserId());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getFavoriteTeam());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findById(String userId) {
    String sql = "SELECT * FROM users WHERE user_id = ?";

    try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, userId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String id = rs.getString("user_id");
            String email = rs.getString("email");
            String password = rs.getString("password"); 
            String team = rs.getString("favorite_team");

            if ("admin01".equals(id)) {
                return new Admin(id, password, email, team);
            } else {
                return new User(id, password, email, team);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
}
