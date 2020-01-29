package com.chain.blog.cond;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 针对blog页面显示 数据传递类
 * @author: chain
 * @create: 2020/01/26
 **/

@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class BlogCond {
    private int blogId;
    private String blogTitle;
    private  String typeName;
    private Boolean isCommend;
    private Boolean isPublished;
    private Date updateTime;
}
