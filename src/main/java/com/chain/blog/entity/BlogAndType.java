package com.chain.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: chain
 * @create: 2020/01/29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogAndType {
    private int id;
    private int blogId;
    private int tagId;
}
