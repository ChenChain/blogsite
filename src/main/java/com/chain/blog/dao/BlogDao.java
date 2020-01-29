package com.chain.blog.dao;

import com.chain.blog.cond.BlogCond;
import com.chain.blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogDao {
    Blog getBlog(int id);

    List<BlogCond> blogs(@Param("page") int page, @Param("size") int size, @Param("search1") String search1, @Param("s2") String s2);

    int saveBlog(Blog blog);

    int updateBlog(int id, Blog blog);

    int deleteBlog(int id);
}
