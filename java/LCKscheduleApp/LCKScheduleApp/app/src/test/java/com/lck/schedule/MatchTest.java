package com.lck.schedule;

import com.lck.schedule.dto.Match;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    private Match createBaseMatch() {
        return new Match("M001", LocalDate.now(), LocalTime.now(), "T1", "GEN", "서울", 0, 0);
    }

    // Testcase 1: 정상 점수 입력
    @Test
    public void testSetValidScores() {
        Match match = createBaseMatch();
        match.setScoreA(2);
        match.setScoreB(1);
        assertEquals(2, match.getScoreA());
        assertEquals(1, match.getScoreB());
    }

    // Testcase 2: 음수 점수 입력 시 예외 발생 여부
    @Test
    public void testNegativeScore() {
        Match match = createBaseMatch();
        assertThrows(IllegalArgumentException.class, () -> match.setScoreA(-1));
    }

    // Testcase 3: 과도한 점수 입력 (9999)
    @Test
    public void testTooHighScore() {
        Match match = createBaseMatch();
        match.setScoreB(9999); // 허용은 되지만 경고용 테스트
        assertEquals(9999, match.getScoreB());
    }

    // Testcase 4: 점수 미입력(null)은 허용되지 않으므로 테스트 생략
}
