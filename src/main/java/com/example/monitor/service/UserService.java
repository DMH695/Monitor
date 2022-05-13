package com.example.monitor.service;

import com.example.monitor.entity.User;

public interface UserService {
    User login(User user);
    User getByTelephone(String telephone);
    void register(User user);
}
