package com.chain.blog.web.admin;

import com.chain.blog.entity.User;
import com.chain.blog.service.user.UserService;
import com.chain.blog.utils.MD5Util;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.awt.*;

/**
 * @author: chain
 * @create: 2020/01/20
 **/
@RequestMapping("/admin")
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping({"/","/login",""})
    public String loginPage(){
        return "admin/login";
    }
    @PostMapping("/login")
    public String login(@RequestParam(name = "username") String username, @RequestParam("password") String password,
                        HttpSession session,
    RedirectAttributes redirectAttributes){
        User user =userService.checkUser(username, MD5Util.code( password));
        if(user!=null){
            user.setPassword(null);//不把密码传递到前台
            session.setAttribute("user",user);//96e79218965eb72c92a549dd5a330112
            return "admin/index";
        }
        else {
            redirectAttributes.addFlashAttribute("message","用户名密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }

    @GetMapping("/index")
    public String index(){
        return "admin/index";
    }
}
