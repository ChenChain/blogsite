package com.chain.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: chain
 * @create: 2020/02/05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Something {
    private Integer id;
    private String name;
    private String content;
    private String ip;
    private Date createTime;
}
