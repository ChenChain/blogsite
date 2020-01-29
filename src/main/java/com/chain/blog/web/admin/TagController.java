package com.chain.blog.web.admin;

import com.chain.blog.entity.Tag;
import com.chain.blog.entity.Type;
import com.chain.blog.service.tag.TagService;
import com.chain.blog.service.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/21
 **/
@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/tags")
    public String types(Model model){
        List<Tag> tags=tagService.getTags();
        model.addAttribute("tags",tags);//此处为分页查询的数据
        return "admin/tags";
    }

    @GetMapping("/tag_input")
    public String tags(){
        return "admin/tag_input";
    }
    @ResponseBody
    @PostMapping("/tag_input")
    public Integer   tag_input(Tag tag){
        Integer i= tagService.saveTag(tag);
        return i;
    }


    @GetMapping("/tags/delete")
    public void  delete(int id, HttpServletResponse response) throws IOException {
         tagService.deleteTag(id);
        response.setContentType("text/html;charset=utf-8");
         response.getWriter().println("<script>alert('删除成功'); window.location.href='/admin/tags' ;</script>");
//         return "redirect:/admin/tags";
    }


}
