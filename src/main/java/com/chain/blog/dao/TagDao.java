package com.chain.blog.dao;

import com.chain.blog.entity.Tag;
import com.chain.blog.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/21
 **/
@Mapper
public interface TagDao {
    int saveTag(Tag tag);

    Tag getTag(int id);

    List<Tag> getTags(int page, int size);//页数 大小
    List<Tag> getTags();
    int updateTag(int id, Tag tag);

    void deleteTag(int id);


}
