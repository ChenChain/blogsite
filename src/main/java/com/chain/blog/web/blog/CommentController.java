package com.chain.blog.web.blog;

import com.chain.blog.dao.CommentDao;
import com.chain.blog.entity.Comment;
import com.chain.blog.entity.User;
import com.chain.blog.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * @author: chain
 * @create: 2020/01/31
 **/
@Controller
public class CommentController {

    @Autowired
    private CommentDao commentDao;

    @Value("${admin.avatar}")
    private String adminAvatar;

    @Autowired
    private CommentService commentService;
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable("blogId") int id, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogId(id));
        return "/blog/blog::commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        User user=(User) session .getAttribute("user");
        if (user!=null &&user.getEmail().equals("1759683080@qq.com")){
            System.out.println("管理员登陆");
            comment.setAvatar(adminAvatar);
            comment.setNickname("administrator");
        }
        commentService.saveComment(comment);
        return "redirect:/comments/"+comment.getBlogId();
    }

//    @GetMapping("/testc")
//    @ResponseBody
//    public Comment get(int id){
//        return commentDao.getCommentById(id);
//    }
//
//    @GetMapping("/testca")
//    @ResponseBody
//    public List<Comment> geta(int id){
//        return commentService.listCommentByBlogId(id);
//    }
}
