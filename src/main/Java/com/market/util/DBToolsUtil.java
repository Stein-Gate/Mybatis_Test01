package com.market.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class DBToolsUtil {
    public static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用Mybatis提供的Resources类加载mybatis配置文件
            Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
            //
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //创建能执行映射文件中sql的sqlSession
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
