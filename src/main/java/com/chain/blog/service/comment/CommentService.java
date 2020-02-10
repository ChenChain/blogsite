package com.chain.blog.service.comment;

import com.chain.blog.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author: chain
 * @create: 2020/01/31
 **/
@Service
public interface CommentService {
    List<Comment> listCommentByBlogId(int blogId);

    int saveComment(Comment comment);

    /**
     * 评论级别分层
     * 取出博客对应的所有的最顶级的父级评论 即parentCommentId=0的评论
     *
     */
    public List<Comment> firstParentComment(int blogId);
}
