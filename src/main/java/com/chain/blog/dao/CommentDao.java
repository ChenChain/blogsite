package com.chain.blog.dao;

import com.chain.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/31
 **/
@Mapper
public interface CommentDao {
    List<Comment> listCommentByBlogId(int blogId);

    int saveComment(Comment comment);


    public List<Comment> firstParentComment(int blogId);

    /**
     *根据父级id找到所有的子评论
     * @param parentId 父id
     * @return 子评论列表
     */
    public List<Comment> getSonComment(int parentId);

    /**
     * 根据博客id 得到该博客的所有子评论
     * @param blogId
     * @return 所有子评论
     */
    public List<Comment> getAllBlogSonComment(int blogId);

    /**
     * 根据id值找到comment
     * @param id
     * @return
     */
    public Comment getCommentById(int id);

}
