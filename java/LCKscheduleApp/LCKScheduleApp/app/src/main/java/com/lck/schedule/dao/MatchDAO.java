
package com.lck.schedule.dao;

import com.lck.schedule.dto.Match;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatchDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/matchdb";
    private final String dbUser = "root";
    private final String dbPassword = "9043";

    public Match findById(String matchId) {
        Match match = null;
        String sql = "SELECT * FROM match_schedule WHERE match_id = ?";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matchId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                match = new Match();
                match.setMatchId(rs.getString("match_id"));
                match.setMatchDate(rs.getDate("match_date").toLocalDate());
                match.setStartTime(rs.getTime("start_time").toLocalTime());
                match.setTeamA(rs.getString("team_a"));
                match.setTeamB(rs.getString("team_b"));
                match.setLocation(rs.getString("location"));
                match.setScoreA(rs.getInt("score_a"));
                match.setScoreB(rs.getInt("score_b"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return match;
    }

    public List<Match> findAll() {
        List<Match> matches = new ArrayList<>();
        String sql = "SELECT * FROM match_schedule";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Match match = new Match();
                match.setMatchId(rs.getString("match_id"));
                match.setMatchDate(rs.getDate("match_date").toLocalDate());
                match.setStartTime(rs.getTime("start_time").toLocalTime());
                match.setTeamA(rs.getString("team_a"));
                match.setTeamB(rs.getString("team_b"));
                match.setLocation(rs.getString("location"));
                match.setScoreA(rs.getInt("score_a"));
                match.setScoreB(rs.getInt("score_b"));
                matches.add(match);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matches;
    }

    public void insert(Match match) {
        String sql = "INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, match.getMatchId());
            stmt.setDate(2, java.sql.Date.valueOf(match.getMatchDate()));
            stmt.setTime(3, java.sql.Time.valueOf(match.getStartTime()));
            stmt.setString(4, match.getTeamA());
            stmt.setString(5, match.getTeamB());
            stmt.setString(6, match.getLocation());
            stmt.setInt(7, match.getScoreA());
            stmt.setInt(8, match.getScoreB());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMatch(Match match) {
        String sql = "UPDATE match_schedule SET match_date = ?, start_time = ?, team_a = ?, team_b = ?, location = ?, score_a = ?, score_b = ? WHERE match_id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(match.getMatchDate()));
            stmt.setTime(2, java.sql.Time.valueOf(match.getStartTime()));
            stmt.setString(3, match.getTeamA());
            stmt.setString(4, match.getTeamB());
            stmt.setString(5, match.getLocation());
            stmt.setInt(6, match.getScoreA());
            stmt.setInt(7, match.getScoreB());
            stmt.setString(8, match.getMatchId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMatch(String matchId) {
        String sql = "DELETE FROM match_schedule WHERE match_id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, matchId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
