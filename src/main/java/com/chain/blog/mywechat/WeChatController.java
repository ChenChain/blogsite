package com.chain.blog.mywechat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: chain
 * @create: 2020/02/19
 **/
@Controller
@RequestMapping("/wechat")
public class WeChatController {

    @GetMapping("/check")
    public void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String str="";
        try {

        weChatDev w=  new weChatDev();
        w.doGet(request, response);
        str=w.getStr();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter o=response.getWriter();
        o.write(str);
//        return str;
    }
}
