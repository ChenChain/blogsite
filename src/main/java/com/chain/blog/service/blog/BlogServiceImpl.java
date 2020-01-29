package com.chain.blog.service.blog;

import com.chain.blog.cond.BlogCond;
import com.chain.blog.dao.BlogDao;
import com.chain.blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/23
 **/
@Service
public class BlogServiceImpl implements  BlogServce {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog getBlog(int id) {
        return blogDao.getBlog(id);
    }

    @Override
    public List<BlogCond> blogs(int page, int size, String search1, String s2) {
        return blogDao.blogs(page,size,search1,s2);
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(blog.getCreateTime());
        blog.setViewed(0);
        return blogDao.saveBlog(blog);
    }

    @Override
    public int updateBlog(int id, Blog blog) {
        blog.setUpdateTime(new Date());
        return blogDao.updateBlog(id, blog);
    }

    @Override
    public int deleteBlog(int id) {
        return blogDao.deleteBlog(id);
    }
}