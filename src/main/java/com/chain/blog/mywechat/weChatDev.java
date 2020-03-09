package com.chain.blog.mywechat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: chain
 * @create: 2020/02/19
 **/
public class weChatDev extends HttpServlet {
    private String str;

    public String getStr() {
        return str;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signature=req.getParameter("signature");
        String timestamp=req.getParameter("timestamp");
        String nonce=req.getParameter("nonce");
        String echostr=req.getParameter("echostr");
        PrintWriter out=resp.getWriter();
        if (CheckUtil.checkSignature(signature,timestamp,nonce)){
            str=echostr;
        }


    }
}
