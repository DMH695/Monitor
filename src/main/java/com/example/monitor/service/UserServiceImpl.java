package com.example.monitor.service;

import com.example.monitor.dao.UserDao;
import com.example.monitor.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public User getByTelephone(String telephone) {
        return userDao.getByTelephone(telephone);
    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }
}
