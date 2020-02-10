package com.chain.blog.dao;

import com.chain.blog.cond.BlogCond;
import com.chain.blog.cond.BlogIndexCond;
import com.chain.blog.entity.Blog;
import com.chain.blog.entity.Type;
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

    //获得最新推荐处的blog
    List<BlogCond> listBlogTop(Integer size);

    //获得首页处的blogIndexCond
    List<BlogIndexCond> indexBlog(@Param("page") int page, @Param("size") int size, @Param("search1") String search1, @Param("s2") String s2);

    //浏览次数+1
    void  addOnce(int blogId);

    /**
     * 根据类型id 获取该类型下的所有博客
     */
    List<BlogIndexCond> typeBlogs(int typeId);


    BlogIndexCond getBlogIndexCond(int id);


    String  selectType(int id);

}
