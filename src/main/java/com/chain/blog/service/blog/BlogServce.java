package com.chain.blog.service.blog;

import com.chain.blog.cond.BlogCond;
import com.chain.blog.cond.BlogIndexCond;
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
    List<Blog> listBlogTop(Integer size);

    List<BlogIndexCond> indexBlog(int page,  int size,  String search1, String s2);

    //返回markdown的html代码
    Blog htmlIndexBlog(int blogId);
    void  addOnce(int blogId);

    /**
     * 根据类型id 获取该类型下的所有博客
     */
    List<BlogIndexCond> typeBlogs(int typeId);

    BlogIndexCond getBlogIndexCond(int id);


}
