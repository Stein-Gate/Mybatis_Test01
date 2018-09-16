package com.market.service;

import com.market.daoimpl.UserDaoImpl;
import com.market.pojo.User;

import java.util.List;

public class UserService {
    public static void main(String args[]){
        UserDaoImpl daoImpl = new UserDaoImpl();
        try {
            List<User> list = daoImpl.findAllUsers();
            System.out.println(list.size());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
