package com.chain.blog.service.footmark;

import com.chain.blog.entity.Footmark;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FootmarkService {
    void insertFootmark(Footmark footmark);
    List<Footmark> queryAllFootmark();
    Footmark queryFootmarkById(int id);
    void  deleteFootmarkById(int id);
}
