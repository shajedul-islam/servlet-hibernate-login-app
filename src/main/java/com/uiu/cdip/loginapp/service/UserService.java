package com.uiu.cdip.loginapp.service;

import com.uiu.cdip.loginapp.model.User;

public interface UserService {
    public boolean login(String username, String password);
    public String registration(User user);
}
