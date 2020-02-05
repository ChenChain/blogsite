package com.chain.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/19
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Type {//t_type
    private int id;
    private String name;

    //存放关联的blog id
    private List<Integer> blogList;
}
