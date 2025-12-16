package com.lck.schedule.dto;

public class Admin extends User {

    public Admin(String userId, String password, String email, String favoriteTeam) {
        super(userId, password, email, favoriteTeam);
    }

    // 향후 관리자 전용 메서드를 여기에 추가 가능
    public void manage() {
        System.out.println("관리자 권한으로 시스템을 관리합니다.");
    }
}
