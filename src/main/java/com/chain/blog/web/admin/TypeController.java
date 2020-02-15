package com.chain.blog.web.admin;

import com.chain.blog.entity.Type;
import com.chain.blog.service.type.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/21
 **/
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/types")
    public String types(Model model){
        List<Type> types=typeService.getTypes();
        model.addAttribute("types",types);//此处为分页查询的数据
        return "admin/types";
    }

    @GetMapping("/type_input")
    public String types(){
        return "admin/type_input";
    }
    @ResponseBody
    @PostMapping("/type_input")
    public Integer   type_input(Type type){
        Integer i= typeService.saveType(type);
        return i;
    }


    @GetMapping("/types/delete")
    public void  delete(int id, HttpServletResponse response) throws IOException {
         typeService.deleteType(id);
        response.setContentType("text/html;charset=utf-8");
         response.getWriter().println("<script>alert('删除成功'); window.location.href='/admin/types' ;</script>");
//         return "redirect:/admin/types";
    }

    @ResponseBody
    @GetMapping("/testjs")
    public List<Type> getTpes(){
        return typeService.getTypes();
    }

}
