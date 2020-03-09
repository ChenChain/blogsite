package com.chain.blog.dao;

import com.chain.blog.entity.Footmark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FootmarkDao {

    void insertFootmark(Footmark footmark);
    List<Footmark> queryAllFootmark();
    Footmark queryFootmarkById(int id);
    void  deleteFootmarkById(int id);

}
