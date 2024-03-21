package com.wzj.mapper;

import com.wzj.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where password = #{password} and username = #{username}")
    User select(@Param("password") String password, @Param("username") String username);

    @Select("select * from user where username = #{username}")
    User selectByusername(@Param("username")String username);

    @Insert("insert into user(username, password) values(#{username},#{password})")
    void add(User user);
}
