package com.market.service;

import com.market.daoimpl.UserDaoImpl;
import com.market.pojo.User;

import java.util.List;

public class UserService {
    public static void main(String args[]){
        UserDaoImpl daoImpl = new UserDaoImpl();
        /**
         * 查询所有的用户
         */
//        try {
//            List<User> list = daoImpl.findAllUsers();
//            if (list == null){
//                System.out.println("用户为空");
//            }else {
//                for (User user:list) {
//                    System.out.println(user.toString());
//                }
//                System.out.println(list.size());
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
        /**
         * 插入用户
         */

//        User user = new User("Lulu",22,"Taizhou");
//        try {
//            daoImpl.insertUser(user);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        /**
         * 查询单个用户
         */
        User user = null;
        try {
            user = daoImpl.findUserByID(2);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(user.toString());

        /**
         * 更新用户信息
         */

//        User user = new User("Image",25,"Wenzhou");
//        try {
//            Boolean isSuccess = daoImpl.updateUser(user,2);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }
}
