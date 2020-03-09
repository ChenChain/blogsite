package com.chain.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 足迹实体类
 * @author: chain
 * @create: 2020/02/23
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Footmark {
    private int id;
    private String city;
    private String title;
}
