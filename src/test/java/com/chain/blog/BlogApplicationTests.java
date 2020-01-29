package com.chain.blog;

import com.chain.blog.dao.BlogDao;
import com.chain.blog.dao.TypeDao;
import com.chain.blog.entity.Type;
import com.chain.blog.entity.User;
import com.chain.blog.service.type.TypeService;
import com.chain.blog.service.type.TypeServiceImpl;
import com.chain.blog.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private TypeService typeService;
    @Autowired
    private TypeDao typeDao;
    @Autowired
    private BlogDao blogDao;
    @Test
    void contextLoads() {
        Type type=new Type(76,"a");


         System.out.println(blogDao.blogs(1,3,"1","1"));
    }

}
