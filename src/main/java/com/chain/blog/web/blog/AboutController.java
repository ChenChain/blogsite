package com.chain.blog.web.blog;

import com.chain.blog.dao.AboutmeDao;
import com.chain.blog.entity.Link;
import com.chain.blog.service.aboutme.AboutmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/02/04
 **/
@Controller
public class AboutController {

    @Autowired
    private AboutmeService aboutmeService;

    @GetMapping("/about")
    public String about(Model model){
        List<Link> links=aboutmeService.getAllLinks();
        model.addAttribute("links",links);
        return "outside/about";
    }

    @ResponseBody
    @GetMapping("/about/getlinks")
    public List<Link> getAllLinks(){
        System.out.println("输出链接");
        return aboutmeService.getAllLinks();
    }

}
