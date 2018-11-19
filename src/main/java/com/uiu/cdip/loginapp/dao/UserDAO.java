package com.uiu.cdip.loginapp.dao;

import com.uiu.cdip.loginapp.model.User;

public interface UserDAO {
    public boolean login(String username, String password);
    public String register(User user);
}