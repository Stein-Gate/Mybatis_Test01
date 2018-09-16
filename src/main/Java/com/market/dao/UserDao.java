package com.market.dao;

import com.market.pojo.User;

import java.util.List;

public interface UserDao {
    public List<User> findAllUsers() throws Exception;
}
