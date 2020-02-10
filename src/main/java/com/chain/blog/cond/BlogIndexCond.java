package com.chain.blog.cond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 展示在游客界面的博客数据类
 * @author: chain
 * @create: 2020/01/29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogIndexCond {
    private int blogId;
    private String blogTitle;
    private  String typeName;
    private Date updateTime;
    private String description;
    private String firstPicture;
    private Integer viewed;
}
