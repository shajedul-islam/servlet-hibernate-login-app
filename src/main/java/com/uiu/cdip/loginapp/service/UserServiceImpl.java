package com.uiu.cdip.loginapp.service;

import com.uiu.cdip.loginapp.dao.UserDAO;
import com.uiu.cdip.loginapp.dao.UserDAOImpl;
import com.uiu.cdip.loginapp.model.User;

public class UserServiceImpl implements UserService {
    private UserDAO loginDao = new UserDAOImpl();

    @Override
    public boolean login(String username, String password) {
        return loginDao.login(username, password);
    }

    @Override
    public String registration(User user) {
        return loginDao.register(user);
    }
}
