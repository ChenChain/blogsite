package com.chain.blog.web.admin;

import com.chain.blog.entity.Footmark;
import com.chain.blog.service.footmark.FootmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 足迹管理类
 * @author: chain
 * @create: 2020/02/23
 **/
@Controller
public class FootmarkController {
    @Autowired
    private FootmarkService footmarkService;

    @GetMapping("/admin/footmark")
    public String footmark(Model model){
        List<Footmark> footmarks=footmarkService.queryAllFootmark();
        model.addAttribute("footmarks",footmarks);
        return "admin/footmark";
    }
    @GetMapping("/admin/footmark_input")
    public String footmarkInput(){
        return  "admin/footmark_input";
    }

    @ResponseBody
    @PostMapping("/admin/footmark_input")
    public int saveFootmark(Footmark footmark){
        footmarkService.insertFootmark(footmark);
        return 1;
    }

    @ResponseBody
    @GetMapping("/admin/footmark/delete")
    public void deleteFootmark(int id, HttpServletResponse response){
        footmarkService.deleteFootmarkById(id);
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().println("<script>alert('删除成功'); window.location.href='/admin/footmark' ;</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
