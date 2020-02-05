package com.chain.blog.web.blog;

import com.chain.blog.cond.BlogCond;
import com.chain.blog.cond.BlogIndexCond;
import com.chain.blog.dao.BlogViewDao;
import com.chain.blog.entity.Blog;
import com.chain.blog.service.blog.BlogServce;
import com.chain.blog.service.tag.TagService;
import com.chain.blog.service.type.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/29
 **/
@Controller
public class IndexController {

    @Autowired
    private BlogViewDao blogViewDao;

    @Autowired
    private BlogServce blogServce;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    //访问首页面
    @GetMapping("/")
    public String index(Model model){
        blogViewDao.addOnce();
        model.addAttribute("recommendBlogs",blogServce.listBlogTop(3));
        return "/blog/index";
    }




    //博客列表
    @ResponseBody
    @GetMapping("/list")
    public PageInfo jumpJsp(@Param("pageNum") Integer pageNum, @Param("pageSize")
            Integer pageSize, @Param("search1") String search1, @Param("search2") String s2, @Param("search3") String s3
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<BlogIndexCond> blogs = blogServce.indexBlog(pageNum, pageSize, search1, s2);
        PageInfo page = new PageInfo(blogs);
        return page;
    }

    //search 全局搜索
    @PostMapping("/search")
    public String search(@RequestParam String query, Model model){
        model.addAttribute("query",query);
        return "/blog/search";
    }

    //search 全局搜索返回的博客数据 依据 query值 匹配 title / content / type 并按照时间降序
    @ResponseBody
    @GetMapping("/search/blog")
    public PageInfo<BlogIndexCond> searchBlog(@Param("pageNum") Integer pageNum, @Param("pageSize")
            Integer pageSize, @Param("search1") String search1) {
        PageHelper.startPage(pageNum,pageSize);
        List<BlogIndexCond> blogs=blogServce.indexBlog(pageNum,pageSize,search1,"");
        PageInfo pageInfo=new PageInfo(blogs);
        return pageInfo;
    }


    @GetMapping("/blog/{id}")
    public String blog(@PathVariable("id") int id ,Model model){
        blogServce.addOnce(id);
        model.addAttribute("blog",blogServce.htmlIndexBlog(id));
        return "/blog/blog";
    }


}
