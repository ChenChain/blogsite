package com.chain.blog.web.blog;

import com.chain.blog.entity.Footmark;
import com.chain.blog.service.footmark.FootmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 对应footmark
 * @author: chain
 * @create: 2020/02/04
 **/
@Controller
public class WalkController {

    @Autowired
    private FootmarkService footmarkService;

    @GetMapping("/walk")
    public String walk(Model model) {
        List<Footmark> footmarks=footmarkService.queryAllFootmark();
        model.addAttribute("footmarks",footmarks);
        return "outside/walk";
    }
}
