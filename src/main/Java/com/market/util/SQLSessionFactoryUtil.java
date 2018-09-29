package com.market.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SQLSessionFactoryUtil {
    //类线程锁
    private static final Class CLASS_LOCK = SQLSessionFactoryUtil.class;
    //私有化构造参数
    //防止使用者使用new的方式创建多个对象
    private SQLSessionFactoryUtil(){}

    //构建SQLSessionFactory  实现单例
    static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory initSqlSessionFactory(){
        InputStream inputStream = null;
        //SqlSessionFactory对象
        SqlSession sqlSession = null;

        //读入配置流文件 加载核心配置文件

        try{
            inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        }catch (IOException e){
            System.out.println("----- "+e);
           e.printStackTrace();
        }

        //避免在多线程环境中，多次初始化造成对象的不唯一
        synchronized (CLASS_LOCK){
            if (sqlSessionFactory == null){
                //获取SQLSessionFactory
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }

        return sqlSessionFactory;
    }

    //打开SqlSession
    public static SqlSession openSqlSession(){
        if (sqlSessionFactory == null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
