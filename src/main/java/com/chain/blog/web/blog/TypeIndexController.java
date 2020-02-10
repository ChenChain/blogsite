package com.chain.blog.web.blog;

import com.chain.blog.cond.BlogIndexCond;
import com.chain.blog.entity.Blog;
import com.chain.blog.entity.Type;
import com.chain.blog.service.blog.BlogServce;
import com.chain.blog.service.type.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/02/02
 **/
@Controller
public class TypeIndexController {



    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogServce blogServce;

    /**
     * @param id       类型id
     * @param pageNum  分页
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("/alltypes/{typeid}")
    public String types(@PathVariable("typeid") int id, Model model) {
        System.out.println(id);
        List<Type> types = typeService.getTypes();
        if (id == -1 || id == 0) {
            id = types.get(0).getId();
        }
        model.addAttribute("types", types);
        model.addAttribute("activeTypeId",id);
        return "blog/types";
    }


    @GetMapping("/typeblogs")
    @ResponseBody
    public PageInfo typeBlogsPageInfo(@RequestParam("search1")int typeId, Integer pageNum, Integer pageSize){
        List<BlogIndexCond> blogs=typeBlogs(typeId,pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(blogs);
        return pageInfo;
    }

    /**
     * 博客分页
     * @param typeId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<BlogIndexCond> typeBlogs(int typeId,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<BlogIndexCond> blogs=blogServce.typeBlogs(typeId);
        return blogs;
    }


}
