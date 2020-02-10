package com.chain.blog.service.something;

import com.chain.blog.dao.SomethingDao;
import com.chain.blog.entity.Something;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: chain
 * @create: 2020/02/05
 **/
@Service
public class SomethingServiceImpl implements  SomethingService{
    @Autowired
    private SomethingDao somethingDao;
    @Override
    public void save(Something something) {
        something.setCreateTime(new Date());
        somethingDao.save(something);
    }

    @Override
    public List<Something> queryById(Integer id) {
        return somethingDao.queryById(id);
    }

    @Override
    public List<Something> queryByPage(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Something> somethings= somethingDao.queryByPage();
        return somethings;
    }

    @Override
    public Integer getCount() {
        return somethingDao.getCount();
    }
}
