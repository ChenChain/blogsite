package com.chain.blog.dao;

import com.chain.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    User checkUser(@Param("username") String username, @Param("password") String password);
    User checkUser();
}
