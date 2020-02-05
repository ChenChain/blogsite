package com.chain.blog.dao;

import com.chain.blog.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/21
 **/
@Mapper
public interface TypeDao {
    int saveType(Type type);

    Type getType(int id);

    List<Type> getTypes(int page, int size);//页数 大小
    List<Type> getTypes();
    int updateType(int id, Type type);

    void deleteType(int id);



}
