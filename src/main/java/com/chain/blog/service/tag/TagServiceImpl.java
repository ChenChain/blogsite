package com.chain.blog.service.tag;

import com.chain.blog.dao.TagDao;
import com.chain.blog.entity.Tag;
import com.chain.blog.entity.Type;
import com.chain.blog.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/23
 **/
@Service
public class TagServiceImpl implements TagService {


    @Autowired
    private TagDao tagDao;

    @Override
    public int saveTag(Tag tag) {
        return tagDao.saveTag(tag);
    }

    @Override
    public Tag getTag(int id) {
        return tagDao.getTag(id);
    }

    @Override
    public List<Tag> getTags(int page, int size) {
        return tagDao.getTags(page * (size - 1) + 1, size);
    }

    @Override
    public int updateTag(int id, Tag tag) {
        return 0;
    }


    @Override
    public List<Tag> getTags() {
        return tagDao.getTags();
    }

    @Override
    public void deleteTag(int id) {
        tagDao.deleteTag(id);
    }

    @Override
    public List<Tag> listTag(String ids) {

        return null;
    }
}
