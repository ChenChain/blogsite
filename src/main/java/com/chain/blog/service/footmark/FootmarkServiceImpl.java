package com.chain.blog.service.footmark;

import com.chain.blog.dao.FootmarkDao;
import com.chain.blog.entity.Footmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/02/23
 **/
@Service
public class FootmarkServiceImpl implements FootmarkService {

    @Autowired
    private FootmarkDao footmarkDao;


    @Override
    public void insertFootmark(Footmark footmark) {
        footmarkDao.insertFootmark(footmark);
    }

    @Override
    public List<Footmark> queryAllFootmark() {
        return footmarkDao.queryAllFootmark();
    }

    @Override
    public Footmark queryFootmarkById(int id) {
        return footmarkDao.queryFootmarkById(id);
    }

    @Override
    public void deleteFootmarkById(int id) {
        footmarkDao.deleteFootmarkById(id);
    }
}
