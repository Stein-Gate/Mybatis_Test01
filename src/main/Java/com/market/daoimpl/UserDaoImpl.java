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

    /**
     * 显示所有用户
     * @return List<User>
     * @throws Exception
     */
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

    /**
     * 根据用户ID查找用户
     * @param id
     * @return User
     * @throws Exception
     */
    @Override
    public User findUserByID(int id) throws Exception {
        User user = null;
        SqlSession session = DBToolsUtil.getSession();
        UserDao dao = session.getMapper(UserDao.class);
        try {
            user = dao.findUserByID(id);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return user;
    }

    /**
     * 插入用户
     * @param user
     * @throws Exception
     */
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

    /**
     * 删除用户
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession session = DBToolsUtil.getSession();
        UserDao dao = session.getMapper(UserDao.class);
        try {
            dao.deleteUser(id);
            session.commit();
            System.out.println("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("删除失败");
            session.rollback();
        }finally {
            session.close();
        }
    }

    /**
     * 更新用户
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateUser(User user, int id) throws Exception {
        Boolean isSuccess = false;
        SqlSession session = DBToolsUtil.getSession();
        UserDao dao = session.getMapper(UserDao.class);
        try {
            dao.updateUser(user,id);
            session.commit();
            System.out.println("更新失败");
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("更新成功");
            session.rollback();
        }finally {
            session.close();
        }

        return false;
    }
}
