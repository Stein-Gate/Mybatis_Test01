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
}
