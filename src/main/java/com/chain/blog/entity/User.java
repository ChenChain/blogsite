package com.chain.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.Date;

/**
 * @author: chain
 * @create: 2020/01/19
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avatar;//头像
    private Integer type;//用户类型
    private Date createTime;
    private Date updateTime;
}
