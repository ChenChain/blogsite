package com.chain.blog.service.archieve;

import com.chain.blog.cond.BlogIndexCond;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AchieveService {

   List<String> findAllYear();
    List<String> findAllBlogByYear(String year);

    Map<String,List<BlogIndexCond>> findAllBlog();
}
