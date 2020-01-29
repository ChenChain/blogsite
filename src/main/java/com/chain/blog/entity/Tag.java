package com.chain.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: chain
 * @create: 2020/01/19
 **/
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Tag {
    private  int id;
    private String name;
}
