package com.lck.schedule.service;

import com.lck.schedule.dao.UserDAO;
import com.lck.schedule.dto.User;

public class LoginManager {
    private static User loggedInUser;

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void logout() {
        loggedInUser = null;
    }

    private static LoginManager instance = new LoginManager();
    private User currentUser;

    private LoginManager() {}

    public static LoginManager getInstance() {
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void login(User user) {
        this.currentUser = user;
        setLoggedInUser(user); // 여기도 동기화
    }

    public boolean authenticate(String userId, String password) {
    System.out.println("▶ 입력 ID: " + userId);
    System.out.println("▶ 입력 PW: " + password);

    UserDAO dao = new UserDAO();
    User user = dao.findById(userId);

    if (user == null) {
        System.out.println("⚠ DB에서 유저를 찾을 수 없습니다.");
    } else {
        System.out.println("✔ DB 유저 ID: " + user.getUserId());
        System.out.println("✔ DB 유저 PW: " + user.getPassword());
        System.out.println("✔ PW 일치 여부: " + user.getPassword().equals(password));
    }

    if (user != null && user.getPassword().equals(password)) {
        this.currentUser = user;
        setLoggedInUser(user);
        return true;
    }

    return false;
}
}