package com.lck.schedule.dto;

import java.time.LocalDateTime;
import java.sql.Timestamp;

public class Comment {
    private int commentId;
    private String userId;
    private String matchId;
    private String content;
    private LocalDateTime timestamp;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // 기존 LocalDateTime 버전
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Timestamp 버전 추가
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp.toLocalDateTime();
    }
}
