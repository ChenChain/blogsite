package com.chain.blog.web.admin;

import com.chain.blog.cond.BlogCond;
import com.chain.blog.entity.Blog;
import com.chain.blog.entity.Type;
import com.chain.blog.entity.User;
import com.chain.blog.service.blog.BlogServce;
import com.chain.blog.service.tag.TagService;
import com.chain.blog.service.type.TypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * @author: chain
 * @create: 2020/01/21
 **/
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogServce blogServce;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

//    @ResponseBody
//    @GetMapping("/blogs")
//    public List<Blog> blogs(int page,int size,String title,String s2){
//        int page1=(page-1)*size;
//        List<Blog> blogs=blogServce.blogs(page1,size,title,s2);
//        return blogs;
//    }


    @GetMapping("/blogs")
    public String blogs() {

        return "admin/blogs";
    }

    @ResponseBody
    @GetMapping("/blogs/getblogs")
    public List<BlogCond> blogs(@Param("page") Integer page, @Param("size") Integer size, @Param("search1") String search1, @Param("search2") String search2, @Param("search3") String search3) {
        return blogServce.blogs(1, 2, "", "");
    }

    //博客列表
    @ResponseBody
    @GetMapping("/list")
    public PageInfo jumpJsp(@Param("pageNum") Integer pageNum, @Param("pageSize")
            Integer pageSize, @Param("search1") String search1, @Param("search2") String s2, @Param("search3") String s3
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<BlogCond> blogs = blogServce.blogs(pageNum, pageSize, search1, s2);
        PageInfo page = new PageInfo(blogs);
        return page;
    }


    //获得所有的type值
    @ResponseBody
    @GetMapping("/blog/types")
    public List<Type> blogTypes() {
        return typeService.getTypes();
    }

    //返回到 博客输入页面
    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("blog", new Blog());
        //初始化标签 类型
        model.addAttribute("types", typeService.getTypes());
        model.addAttribute("tags", tagService.getTags());
        return "admin/blog_input";
    }

    //提交
    @PostMapping("/blogs")
    public String post(Blog blog, HttpSession session, RedirectAttributes attributes) {
        User u = (User) session.getAttribute("user");
//        blog.setUserId(u.getId());
        Integer blogId = blog.getId();
        int a = 0;
        if (blogId==0) {
            //保存 即 新增
            a = blogServce.saveBlog(blog);
        }else {
            a=blogServce.updateBlog(blogId,blog);
        }

        if (a != 1) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/blogs";
    }

    //修改blog
    //返回到 博客输入页面
    @GetMapping("/blogs/{id}/input")
    public String editInput(Model model, @PathVariable("id") int id) {
        //初始化标签 类型
        model.addAttribute("types", typeService.getTypes());
        model.addAttribute("tags", tagService.getTags());
        model.addAttribute("blog", blogServce.getBlog(id));
        return "admin/blog_input";
    }


    //删除 id 博客
    @ResponseBody
    @GetMapping("/delete")
    public Integer delete(int id){
        return blogServce.deleteBlog(id);
    }

}
