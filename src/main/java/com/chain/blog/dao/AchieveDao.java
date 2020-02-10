package com.chain.blog.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AchieveDao {
    List<String> findAllYear();
    List<String> findAllBlogByYear(String year);
}
