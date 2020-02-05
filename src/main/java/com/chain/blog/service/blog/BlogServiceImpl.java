package com.chain.blog.service.blog;

import com.chain.blog.cond.BlogCond;
import com.chain.blog.cond.BlogIndexCond;
import com.chain.blog.dao.BlogDao;
import com.chain.blog.entity.Blog;
import com.chain.blog.utils.MarkdownUtil;
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
    public List<Blog> listBlogTop(Integer size) {
        return blogDao.listBlogTop(size);
    }

    @Override
    public List<BlogIndexCond> indexBlog(int page, int size, String search1, String s2) {
        return blogDao.indexBlog(page,size,search1,s2);
    }

    @Override
    public Blog htmlIndexBlog(int id) {
        Blog blog=blogDao.getBlog(id);
        blog.setContent(MarkdownUtil.markdownToHtmlExtensions(blog.getContent()));
        return blog;
    }

    @Override
    public void addOnce(int blogId) {
        blogDao.addOnce(blogId);
    }

    @Override
    public List<BlogIndexCond> typeBlogs(int typeId) {
        return blogDao.typeBlogs(typeId);
    }

    @Override
    public BlogIndexCond getBlogIndexCond(int id) {
        return blogDao.getBlogIndexCond(id);
    }

    @Override
    public int deleteBlog(int id) {
        return blogDao.deleteBlog(id);
    }
}
