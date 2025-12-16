package com.lck.schedule.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Match {
    private String matchId;
    private LocalDate matchDate;
    private LocalTime startTime;
    private String teamA;
    private String teamB;
    private String location;
    private int scoreA;
    private int scoreB;

    public Match() {}

    public Match(String matchId, LocalDate matchDate, LocalTime startTime,
                 String teamA, String teamB, String location, int scoreA, int scoreB) {
        this.matchId = matchId;
        this.matchDate = matchDate;
        this.startTime = startTime;
        this.teamA = teamA;
        this.teamB = teamB;
        this.location = location;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
    if (scoreA < 0) {
        throw new IllegalArgumentException("음수 점수는 허용되지 않습니다.");
    }
    this.scoreA = scoreA;
}

    public int getScoreB() {
        return scoreB;
    }

   public void setScoreB(int scoreB) {
    if (scoreB < 0) {
        throw new IllegalArgumentException("음수 점수는 허용되지 않습니다.");
    }
    this.scoreB = scoreB;
}
}
