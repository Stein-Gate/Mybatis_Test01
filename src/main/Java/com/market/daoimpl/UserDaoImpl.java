package com.market.daoimpl;

import com.market.dao.UserDao;
import com.market.pojo.User;
import com.market.util.DBToolsUtil;
import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAllUsers() throws Exception {
        List<User> list = null;
        SqlSession session = DBToolsUtil.getSession();
        //--------------------
        try{
            UserDao dao = session.getMapper(UserDao.class);
            list = dao.findAllUsers();
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public User findUserByID(int id) throws Exception {
        return null;
    }

    @Override
    public void insertUser(User user) throws Exception {
        SqlSession session = DBToolsUtil.getSession();
        UserDao dao = session.getMapper(UserDao.class);
        try {
            dao.insertUser(user);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(User user) throws Exception {

    }
}
