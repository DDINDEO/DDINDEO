package com.lck.schedule;

import javax.swing.UIManager;

import com.lck.schedule.dao.UserDAO;
import com.lck.schedule.dto.Admin;
import com.lck.schedule.ui.StartFrame;


public class Main {
    public static void main(String[] args) {
            UserDAO dao = new UserDAO();
       

        // 관리자 계정 생성 및 등록
        Admin admin = new Admin("admin01", "admin1234", "admin01@example.com", "T1");
        dao.save(admin);

        new StartFrame(); // 선택 화면 시작
    }
}
