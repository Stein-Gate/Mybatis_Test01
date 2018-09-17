package com.market.dao;

import com.market.pojo.User;

import java.util.List;

public interface UserDao {
    //查询所有的用户
    public List<User> findAllUsers() throws Exception;

    //根据用户ID查询
    public User findUserByID(int id) throws Exception;

    //添加用户
    public void insertUser(User user) throws Exception;

    //删除用户
    public void deleteUser(int id) throws Exception;

    //更新用户
    public boolean updateUser(User user,int id) throws Exception;

    //查找最顶尖的五个用户
}
