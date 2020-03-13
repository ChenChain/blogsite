package com.chain.blog.service.aboutme;

import com.chain.blog.entity.Link;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AboutmeService {
    List<Link> getAllLinks();//得到所有的链接
}
