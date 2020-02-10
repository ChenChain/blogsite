package com.chain.blog.service.archieve;

import com.chain.blog.cond.BlogIndexCond;
import com.chain.blog.dao.AchieveDao;
import com.chain.blog.service.blog.BlogServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: chain
 * @create: 2020/02/03
 **/
@Service
public class ArchieveServiceImpl implements AchieveService {

    @Autowired
    private BlogServce blogServce;

    @Autowired
    private AchieveDao archieveDao;

    @Override
    public List<String> findAllYear() {

        return archieveDao.findAllYear();
    }

    @Override
    public List<String> findAllBlogByYear(String year) {
        return archieveDao.findAllBlogByYear(year);
    }

    @Override
    public Map<String, List<BlogIndexCond>> findAllBlog() {
        List<String> years = findAllYear();
        Map<String,List<BlogIndexCond>> yearBlogs=new LinkedHashMap<>();
        for (String year : years
        ) {
            List<String> yearBlogId=new ArrayList<>();
            List<BlogIndexCond> blogIndexConds=new ArrayList<>();
            yearBlogId=findAllBlogByYear(year);
            for (String id:yearBlogId){
                int bid=Integer.parseInt(id);
                BlogIndexCond blogIndexCond=blogServce.getBlogIndexCond( bid);
                if (blogIndexCond!=null){
                    blogIndexConds.add(blogIndexCond);
                }
            }
            if (blogIndexConds.size()!=0) {
                yearBlogs.put(year, blogIndexConds);
            }
        }
        return  yearBlogs;
    }

}
