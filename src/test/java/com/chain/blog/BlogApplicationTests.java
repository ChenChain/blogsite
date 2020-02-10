package com.chain.blog;

import com.chain.blog.dao.BlogDao;
import com.chain.blog.dao.CommentDao;
import com.chain.blog.dao.TypeDao;
import com.chain.blog.entity.Comment;
import com.chain.blog.entity.Type;
import com.chain.blog.entity.User;
import com.chain.blog.service.blog.BlogServce;
import com.chain.blog.service.comment.CommentServiceImpl;
import com.chain.blog.service.type.TypeService;
import com.chain.blog.service.type.TypeServiceImpl;
import com.chain.blog.service.user.UserService;
import com.chain.blog.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private BlogServce blogServce;
    @Test
    void contextLoads() {
        System.out.println(blogServce.getBlog(45).getUpdateTime());
        System.out.println(blogServce.getBlogIndexCond(45).getUpdateTime());
    }

}
