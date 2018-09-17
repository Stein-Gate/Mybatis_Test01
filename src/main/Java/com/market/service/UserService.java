package com.market.service;

import com.market.daoimpl.UserDaoImpl;
import com.market.pojo.User;

import java.util.List;

public class UserService {
    public static void main(String args[]){
        UserDaoImpl daoImpl = new UserDaoImpl();
        try {
            List<User> list = daoImpl.findAllUsers();
            if (list == null){
                System.out.println("用户为空");
            }else {
                for (User user:list) {
                    System.out.println(user.toString());
                }
                System.out.println(list.size());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

//        User user = new User("Lulu",22,"Taizhou");
//        try {
//            daoImpl.insertUser(user);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
