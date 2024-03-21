package com.wzj.service;

import com.wzj.mapper.UserMapper;
import com.wzj.pojo.User;
import com.wzj.utils.Sqlsession;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {
    SqlSessionFactory factory = Sqlsession.getSqlsession();
    public  User getUser(String username,String password) {

        SqlSession sqlsession = factory.openSession();

        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);

        User user = userMapper.select(password,username);

        sqlsession.close();

        return user;

    }

    public boolean register(User user) {

        SqlSession sqlsession = factory.openSession();

        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);

        User u = userMapper.selectByusername(user.getUsername());

        if(u==null){
            userMapper.add(user);
            sqlsession.commit();
        }
        sqlsession.close();

        return u==null;

    }

}
