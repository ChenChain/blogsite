package com.chain.blog.service.user;

import com.chain.blog.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User checkUser(String username, String password);
    User checkUser();

}
