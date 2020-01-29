package com.chain.blog.service.blog;

import com.chain.blog.cond.BlogCond;
import com.chain.blog.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogServce {

    Blog getBlog(int id);

    List<BlogCond> blogs(int page, int size, String search1, String s2);

    int saveBlog(Blog blog);

    int updateBlog(int id,Blog blog);

    int  deleteBlog(int id);
}
