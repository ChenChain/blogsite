package com.chain.blog;

import com.chain.blog.dao.BlogDao;
import com.chain.blog.dao.CommentDao;
import com.chain.blog.dao.TypeDao;
import com.chain.blog.entity.Comment;
import com.chain.blog.entity.Type;
import com.chain.blog.entity.User;
import com.chain.blog.service.comment.CommentServiceImpl;
import com.chain.blog.service.type.TypeService;
import com.chain.blog.service.type.TypeServiceImpl;
import com.chain.blog.service.user.UserService;
import com.chain.blog.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CommentServiceImpl commentService;
    @Test
    void contextLoads() {
        List<Comment> allComments=commentDao.listCommentByBlogId(37);
        List<Comment> allFC=commentDao.firstParentComment(37);
        List<Comment> allSC=commentDao.getAllBlogSonComment(37);
        System.out.println(allComments.size() + " "+allFC.size()+"  "+ allSC.size());
        //   System.out.println( commentService.getCommentTree(allFC.get(0),allSC));
//
//        commentService.getVoidSingleTreeComment(allFC.get(0),allComments);
        System.out.println(
            commentService.getWholeCommentTreeAdvanced(allComments)
        );

    }

}
