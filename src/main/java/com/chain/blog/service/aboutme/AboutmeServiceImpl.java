package com.chain.blog.service.aboutme;

import com.chain.blog.dao.AboutmeDao;
import com.chain.blog.entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/03/13
 **/
@Service
public class AboutmeServiceImpl implements AboutmeService{

    @Autowired
    private AboutmeDao aboutmeDao;

    @Override
    public List<Link> getAllLinks() {
        return aboutmeDao.getAllLinks();
    }
}
