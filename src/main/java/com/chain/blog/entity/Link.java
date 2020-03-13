package com.chain.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 关于我界面 链接对象
 * @author: chain
 * @create: 2020/03/13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private int id;
    private String name;
    private String link;
}
