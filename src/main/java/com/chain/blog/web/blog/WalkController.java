package com.chain.blog.web.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: chain
 * @create: 2020/02/04
 **/
@Controller
public class WalkController {

    @GetMapping("/walk")
    public String walk(){
        return "/outside/walk";
    }
}
