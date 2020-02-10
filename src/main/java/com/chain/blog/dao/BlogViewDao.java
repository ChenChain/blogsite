package com.chain.blog.dao;

import org.apache.ibatis.annotations.Mapper;

/** 博客首页浏览次数控制
 * @author: chain
 * @create: 2020/02/01
 **/
@Mapper
public interface BlogViewDao {
    void addOnce();
}
