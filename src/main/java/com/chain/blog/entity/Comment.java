package com.chain.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;
    private String nickname;//昵称  默认对应为ip地址
    private String ip;//评论来自的ip
    private String content;//评论内容
    private String avatar;//头像 默认头像
    private Date createTime;//评论时间
    private String brower;//浏览器
    private String client;//客户端
    private String email;//评论者邮箱
    private int blogId;//对应的博客id
    private Integer parentCommentId;//父级评论id
    /**
     * 父级评论对象
     * 不注入数据库
     * 数据库查询时完成赋值 https://blog.csdn.net/weixin_43863694/article/details/95618745
     */
    private Comment parentComment;
    /**
     * 子集评论集合
     * 不注入数据库
     * 在传递评论给前台数据时完成赋值
     */
    private List<Comment> replyComments =new ArrayList<>();
}
