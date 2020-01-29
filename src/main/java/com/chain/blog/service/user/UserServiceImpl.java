package com.chain.blog.service.user;

import com.chain.blog.dao.UserDao;
import com.chain.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * @author: chain
 * @create: 2020/01/20
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User checkUser(String username, String password) {
        User user=userDao.checkUser(username,password);
        return user;
    }

    @Override
    public User checkUser() {
        User user=userDao.checkUser();
        return user;

    }
}
