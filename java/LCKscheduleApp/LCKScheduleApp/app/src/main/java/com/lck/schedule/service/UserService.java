
package com.lck.schedule.service;

import com.lck.schedule.dao.UserDAO;
import com.lck.schedule.dto.User;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public void register(String userId, String password, String email, String favoriteTeam) {
        User user = new User(userId, password, email, favoriteTeam);
        userDAO.save(user);
    }

    public User findUserById(String userId) {
        return userDAO.findById(userId);
    }
}
