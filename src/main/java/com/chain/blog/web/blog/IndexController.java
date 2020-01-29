package com.chain.blog.web.blog;

import com.chain.blog.service.blog.BlogServce;
import com.chain.blog.service.tag.TagService;
import com.chain.blog.service.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: chain
 * @create: 2020/01/29
 **/
@Controller
public class IndexController {

    @Autowired
    private BlogServce blogServce;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(){
        return "/blog/index";
    }
}
