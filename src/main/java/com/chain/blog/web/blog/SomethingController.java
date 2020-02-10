package com.chain.blog.web.blog;

import com.chain.blog.entity.Something;
import com.chain.blog.service.something.SomethingService;
import com.chain.blog.utils.NickNameUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/02/04
 **/
@Controller
public class SomethingController {

    @Autowired
    private SomethingService somethingService;


    @GetMapping("/something")
    public  String initSomething(Model model){
        model.addAttribute("something_count",somethingService.getCount());
        return "/outside/something";
    }

    @GetMapping("/load")
    public String loadSomething(Model model){
        List<Something> somethings=somethingService.queryByPage(1,8);
        model.addAttribute("somethings",somethings);
        model.addAttribute("currentPage",1);
        return "/outside/something::something_list";
    }

    @GetMapping("/mobile_load")
    public String mobile_loadSomething(Model model){
        List<Something> somethings=somethingService.queryByPage(1,1);
        model.addAttribute("somethings",somethings);
        model.addAttribute("currentPage",1);
        return "/outside/something::something_list";
    }


    /**
     * PC按钮分页
     * @param page
     * @param model
     * @return
     */
    @GetMapping("/something/{page}")
    public String something(@PathVariable("page") Integer page ,Model model){
        if (page<1||page==null)
            page=1;
        List<Something> somethings=somethingService.queryByPage(page,8);
        model.addAttribute("somethings",somethings);
        model.addAttribute("currentPage",page);
        return "/outside/something::something_list";
    }


    @GetMapping("/mobile_something/{page}")
    public String mobile_something(@PathVariable("page") Integer page ,Model model){
        if (page<1||page==null)
            page=1;
        List<Something> somethings=somethingService.queryByPage(page,1);
        model.addAttribute("somethings",somethings);
        model.addAttribute("currentPage",page);
        return "/outside/something::something_list";
    }




    @PostMapping("/pc_something")
    public String saveSomething(Something something){
        somethingService.save(something);
        return "redirect:/load";
    }


    @PostMapping("/mobile_something")
    public String mobile_saveSomething(Something something){
        somethingService.save(something);
        return "redirect:/mobile_load";
    }

    @GetMapping("/getRandName")
    @ResponseBody
    public String  getRandName(){
        return NickNameUtil.generateRandomName();
    }
}
