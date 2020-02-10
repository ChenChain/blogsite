package com.chain.blog.dao;

import com.chain.blog.entity.Something;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SomethingDao {

    /**
     * 保存
     * @param something
     */
    void save(Something something);

    /**
     * 移动端 根据id来查询内容
     * 每次查询一条内容
     * 返回链表内容始终为一条
     * @param id
     */
    List<Something> queryById(Integer id);

    /**
     * 分页查询
     * 针对 pc端
     * @return
     */
    List<Something> queryByPage();

    /**
     * 得到总数目
     * @return
     */
    Integer getCount();
}
