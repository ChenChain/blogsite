package com.chain.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.StringReader;
import java.util.Date;
import java.util.List;

/**
 * 博客类
 *
 * @author: chain
 * @create: 2020/01/19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog { //t_blog
    private int id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag; //标签
    private Integer viewed =0;//浏览次数
    private boolean appreciation;//赞赏 是否开启
    private boolean sharestatement;//转载声明 开启
    private boolean commentabled;//评论是否开启
    private boolean published;//是否发布
    private boolean recommend;//是否推荐
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    private int  userId;//对应的用户id
    private Integer typeId;//对应的类型id

    private String tagIds;//标签串

    private String description;//描述
    private String  typename;
}
