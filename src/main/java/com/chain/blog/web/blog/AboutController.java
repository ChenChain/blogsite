package com.chain.blog.web.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: chain
 * @create: 2020/02/04
 **/
@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(){
        return "/outside/about";
    }
}
