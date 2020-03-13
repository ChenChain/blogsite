package com.chain.blog.dao;

import com.chain.blog.entity.Link;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AboutmeDao {
    List<Link> getAllLinks();//得到所有的链接
}
