package com.chain.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: chain
 * @create: 2020/01/19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;
    private String nickname;//昵称
    private String email;
    private String content;
    private String avatar;//头像
    private Date createTime;//评论时间

    private int blogId;//对应的博客id
}
