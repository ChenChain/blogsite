package com.chain.blog.service.tag;

import com.chain.blog.entity.Tag;
import com.chain.blog.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/23
 **/
@Service
public interface TagService {
    int saveTag(Tag tag);
    Tag getTag(int id);
    List<Tag> getTags(int page, int size);//页数 大小
    int updateTag(int id,Tag tag);
    List<Tag> getTags();
    void deleteTag(int id);

    //依据字符串分离出tag的id
    List<Tag> listTag(String ids);
}
