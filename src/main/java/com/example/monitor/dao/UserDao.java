package com.example.monitor.dao;

import com.example.monitor.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    User login(@Param("user") User user);
    User getByTelephone(String telephone);
    void register(@Param("user") User user);
}
