package com.chain.blog.web;


import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: chain
 * @create: 2020/01/18
 **/

public class IndexController {
    @GetMapping("/achieves")
    public String index() {
        String blog = null;
        return "blog/achieve";
    }
    @GetMapping("/aaa")
    public String iaa(){
        return "admin/blogs";
    }
    @GetMapping("/index")
    public String indexa(){
        return "blog/index";
    }
    @GetMapping("/blog_input")
    public String indexa1(){
        return "admin/blog_input";
    }
    @GetMapping("/about")
    public String indexa2(){
        return "blog/about";
    }
    @GetMapping("/tags")
    public String indexa3(){
        return "blog/tags";
    }
    @GetMapping("/types")
    public String indexa4(){
        return "blog/types";
    }



}


