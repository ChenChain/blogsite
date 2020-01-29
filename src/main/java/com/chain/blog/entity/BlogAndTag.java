package com.chain.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: chain
 * @create: 2020/01/20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogAndTag {
    private int id;
    private int blogId;
    private int tagId;
    //一blog可以有多个tag
}
