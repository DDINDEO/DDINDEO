package com.lck.schedule;

import com.lck.schedule.dto.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    // 이메일 형식 정규식 검사 함수 (RegisterFrame과 동일하게 사용)
    private boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    @Test
    public void testInvalidEmailFormat() {
        User user = new User("u1", "pw123", "abcedfg", "T1");
        assertFalse(isValidEmail(user.getEmail()));
    }

    @Test
    public void testValidEmailFormat() {
        User user = new User("u1", "pw123", "example@naver.com", "T1");
        assertTrue(isValidEmail(user.getEmail()));
    }

    @Test
    public void testFavoriteTeamSetCorrectly() {
        User user = new User("u1", "pw123", "test@naver.com", "T1");
        assertEquals("T1", user.getFavoriteTeam());
    }
}