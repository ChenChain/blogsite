package com.chain.blog.web.blog;

import com.chain.blog.cond.BlogIndexCond;
import com.chain.blog.service.archieve.AchieveService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author: chain
 * @create: 2020/02/03
 **/
@Controller
public class AchieveController {

    //    视图
//    CREATE view blogAndYear4 as (
//            SELECT blog.id as blogId,  DATE_FORMAT(blog.updateTime,"%Y")as blogYear  from blog where   DATE_FORMAT(blog.updateTime,"%Y")  in
//            (select DATE_FORMAT(blog.updateTime,"%Y") from blog ) and blog.published=true order by  blogYear desc,blog.updateTime asc
//);

    @Autowired
    private AchieveService achieveService;
    @GetMapping("/achieve")
    public String achieve(Model model){
        model.addAttribute("years",achieveService.findAllBlog());
        return "/outside/achieve";
    }

//    @GetMapping("/achieves")
//    public String achieves(Model model){
//        model.addAttribute("years",achieveService.findAllBlog());
//        return "/blog/achieves";
//    }
}
