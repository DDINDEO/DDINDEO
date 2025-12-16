
package com.lck.schedule.service;

import com.lck.schedule.dto.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    private static AdminService instance = new AdminService();
    private List<Admin> admins = new ArrayList<>();


    public static AdminService getInstance() {
        return instance;
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public boolean authenticate(String id, String password) {
        for (Admin admin : admins) {
            if (admin.getUserId().equals(id) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
